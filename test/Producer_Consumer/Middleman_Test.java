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
    private Buffer testBuffer;
    private Buffer testBuffer_1;
    private Producer testProducer;
    private Consumer testConsumer;
    
    public Middleman_Test() {
    }
    
    @Before
    public void setUp() {
        testBuffer = new BoundedBuffer(1000, "bb");
        testBuffer_1 = new BoundedBuffer(1000, "bb");
        testProducer = new Producer(999,testBuffer);
        testConsumer = new Consumer(testBuffer_1);
    }
    
     @Test
    public void middleMan() throws InterruptedException{
        //Check that buffer is empty
        assertEquals(testBuffer.getSize(),0);
        //Make Producer thread
        Thread producerThread = new Thread(testProducer); 
        //Pause the testing thread
        Thread.sleep(100);
        //Make the Middlemans thread
        MiddleMan middelMan = MiddleMan.getInstance(testBuffer, testBuffer_1);
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
