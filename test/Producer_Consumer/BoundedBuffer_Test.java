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
    
    private PutBuffer putbuffer;
    private TakeBuffer takebuffer;
    private Producer testProducer;
    private Consumer testConsumer;
    private Consumer testConsumer_1;
    
    public BoundedBuffer_Test() {
    }
    
    @Before
    public void setUp() {
        BoundedBuffer boundedBuffer = new BoundedBuffer(1000, "bb");
        putbuffer = boundedBuffer;
        takebuffer = boundedBuffer;
        testProducer = new Producer(999,putbuffer);
        testConsumer = new Consumer(takebuffer);
        testConsumer_1 = new Consumer(takebuffer);
        
    }

    @Test
    public void testTake() throws InterruptedException{
     /**
     * If the buffer is empty, the current thread should be put in the wait state
     */
       //Check that buffer is empty
       assertEquals(takebuffer.getSize(),0); 
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
        assertEquals(putbuffer.getSize(),0);
        //make producer fill up the Buffer (max of producer was set to .getcapacity od BoundedBuffer)
        Thread producerThread = new Thread(testProducer, "Producer's thread "); 
        producerThread.start();
        //Pause the testing thread
        Thread.sleep(1000);
        //Thread should not be allive
        assertFalse(producerThread.isAlive());
        assertEquals("TERMINATED",producerThread.getState().toString());
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
        assertEquals(putbuffer.getSize(),0);
        //make producer with more items than buffer capacity
        testProducer.setmax(1010);
        Thread producerThread = new Thread(testProducer, "Producers Thread "); 
        producerThread.start();
        Thread.sleep(1000);
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
        assertEquals(1,takebuffer.getSize());
        //Thread should not be allive
        assertFalse(consumerThread.isAlive());
        assertEquals("TERMINATED",consumerThread.getState().toString());
        assertFalse(consumerThread_1.isAlive());
        assertEquals("TERMINATED",consumerThread_1.getState().toString());
    }
    

}
