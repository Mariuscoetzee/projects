/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Producer_Consumer;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Standard
 */
public class BoundedBuffer_Test {
    
    private BoundedBuffer testBoundedBuffer;
    private BoundedBuffer testBoundedBuffer_1;
    private Producer testProducer;
    private Consumer testConsumer;
    private Consumer testConsumer_1;
    
    public BoundedBuffer_Test() {
    }
    
    @Before
    public void setUp() {
        
        testBoundedBuffer = new BoundedBuffer(1000);
        testBoundedBuffer_1 = new BoundedBuffer(testBoundedBuffer.getCapacity());
        testProducer = new Producer(testBoundedBuffer.getCapacity() - 1,testBoundedBuffer);
        testConsumer = new Consumer(testBoundedBuffer);
        testConsumer_1 = new Consumer(testBoundedBuffer_1);
        
    }

    @Test
    public void testTake() throws InterruptedException{
     /**
     * If the buffer is empty, the current thread should be put in the wait state
     */
       //Check that buffer is empty
       assertEquals(testBoundedBuffer.getSize(),0); 
       Thread consumerThread = new Thread (testConsumer,"consumer_thread_");
       consumerThread.start();
       Thread.sleep(1000);
       // check that it is waiting
       assertTrue(consumerThread.isAlive());
       assertEquals(consumerThread.getState().toString(),"WAITING");
       
    }
    @Test 
    public void testPut() throws InterruptedException{
        /**
         * If the buffer is full, the current thread should be put in wait state.
         */
        //Check that buffer is empty
        assertEquals(testBoundedBuffer.getSize(),0);
        //make producer fill up the Buffer (max of producer was set to .getcapacity od BoundedBuffer)
        Thread producerThread = new Thread(testProducer); 
        producerThread.start();
        //Pause the testing thread
        Thread.sleep(100);
        //Thread should not be allive
        assertFalse(producerThread.isAlive());
        assertEquals("TERMINATED",producerThread.getState().toString());
        //Buffer Should be full
        assertEquals(testBoundedBuffer.getSize(), testBoundedBuffer.getCapacity());
        //Start new producerThread again
        //Thread should be waiting
        producerThread = new Thread(testProducer);
        producerThread.start();
        Thread.sleep(100);
        assertEquals("WAITING",producerThread.getState().toString());
        //Make the consumer 
        
    }
    
    @Test 
    public void putAndTake() throws InterruptedException{
         /**
         * If the buffer is full, the current thread should be put in wait state.
         */
        //Check that buffer is empty
        assertEquals(testBoundedBuffer.getSize(),0);
        //make producer with more items than buffer capacity
        testProducer.setmax(testBoundedBuffer.getCapacity() + 10);
        Thread producerThread = new Thread(testProducer); 
        producerThread.start();
        Thread.sleep(1000);
        //Buffer should be full
        assertEquals(testBoundedBuffer.getSize(),testBoundedBuffer.getCapacity());
        //Start consumer threads
        Thread consumerThread = new Thread (testConsumer,"consumer_thread_");
        consumerThread.start();
        Thread consumerThread_1 = new Thread (testConsumer,"consumer_thread_1");
        consumerThread_1.start();
        //Check both are running 
        assertEquals("RUNNABLE",consumerThread.getState().toString());
        assertEquals("RUNNABLE",consumerThread_1.getState().toString());
        Thread.sleep(1000);
        //Buffer should be empty again
        assertEquals(1,testBoundedBuffer.getSize());
        //Thread should not be allive
        assertFalse(consumerThread.isAlive());
        assertEquals("TERMINATED",consumerThread.getState().toString());
        assertFalse(consumerThread_1.isAlive());
        assertEquals("TERMINATED",consumerThread_1.getState().toString());
    }
    

}
