/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Producer_Consumer;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Standard
 */
public class Middleman_Test {
    private BoundedBuffer testBoundedBuffer;
    private Producer testProducer;
    private Consumer testConsumer;
    
    public Middleman_Test() {
    }
    
    @Before
    public void setUp() {
        testBoundedBuffer = new BoundedBuffer(1000);
        testProducer = new Producer(testBoundedBuffer.getCapacity() - 1,testBoundedBuffer);
        testConsumer = new Consumer(testBoundedBuffer);
    }
    
     @Test
    public void middleMan() throws InterruptedException{
        //Check that buffer is empty
        assertEquals(testBoundedBuffer.getSize(),0);
        //Make Producer thread
        Thread producerThread = new Thread(testProducer); 
        //Pause the testing thread
        Thread.sleep(1000);
        //Make the Middlemans thread
        MiddleMan middelMan = MiddleMan.getInstance(testBoundedBuffer, testBoundedBuffer);
        Thread middlemansThread = new Thread(middelMan);
        //Make the consumerThread
        Thread consumerThread = new Thread(testConsumer);
        // Start the threads
        producerThread.start();
        consumerThread.start();
        middlemansThread.start();
        //
        
        assertEquals("RUNNABLE",producerThread.getState().toString());
        assertEquals("RUNNABLE",consumerThread.getState().toString());
        assertEquals("RUNNABLE",middlemansThread.getState().toString());
   
    
    }
}
