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
public class Duplicator_Test {
    
    private BoundedBuffer inputBuffer;
    private BoundedBuffer outputBuffer;
    private BoundedBuffer outputBuffer_1;
    private Producer producer;
    private Consumer consumer;
    private Consumer consumer_1;
    private Duplicator duplicator;
    
    public Duplicator_Test() {
        inputBuffer = new BoundedBuffer(100, "inbuffer");
        outputBuffer = new BoundedBuffer(500,"outbuffer");
        outputBuffer_1 = new BoundedBuffer(500, "outbuffer_1");
        
        producer = new Producer(1000, inputBuffer);
        consumer = new Consumer(outputBuffer);
        consumer_1 = new Consumer(outputBuffer_1);
        duplicator = new Duplicator(inputBuffer,outputBuffer,outputBuffer_1);
    }
    
    @Before
    public void setUp() {
       
       
    }
    
    @Test
    public void Duplicator() throws InterruptedException{
        Thread producerThread = new Thread(producer, "producer's thread ");
        Thread consumerThread = new Thread(consumer,"consumer's thread");
        Thread consumerThread_1 = new Thread(consumer_1, "consumer_1's thread");
        Thread duplicatorThread = new Thread(duplicator,"duplicators thread");
        
        producerThread.start();
        duplicatorThread.start();
        consumerThread.start();
        consumerThread_1.start();
        Thread.sleep(7000);
       
        assertEquals(1,inputBuffer.getSize());
        assertEquals(0,outputBuffer.getSize());
        assertEquals(0,outputBuffer_1.getSize());
        //Check all threads running 
       
        //    
        
        

    }
}
