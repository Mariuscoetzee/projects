/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Producer_Consumer;

/**
 *
 * @author Standard
 */
public final class Main {
    
    
    private static final BoundedBuffer BOUNDED_BUFFER = new BoundedBuffer(100);
    private static Consumer consumer;
    private static Producer producer;
    
    public static void main(final String[] args) {

//         BoundedBuffer toBuffer = new BoundedBuffer(10);   
//         final MiddleMan middleMan = MiddleMan.getInstance(BOUNDED_BUFFER, toBuffer);
        
         producer = new Producer(100, BOUNDED_BUFFER);
         Thread producerThread = new Thread(producer, "producers thread");
         producerThread.start();
        
        Thread middleMansThread = new Thread(new Runnable() {
            @Override
            public void run() {
//                middleMan.doMiddlemanStuff();
            }
        }, "the middleMan's thread");
        
    }
    private static void producer_consumer(){
    consumer = new Consumer(BOUNDED_BUFFER);
    producer = new Producer(100, BOUNDED_BUFFER);
    
    
    Thread producerThread = new Thread(producer, "producers thread");
    producerThread.start();
    
        for (int i = 0; i < 10; i++) {
         Thread consumerThread = new Thread(consumer, "consumer_"+ i + "'s thread");
         consumerThread.start();
        }
 
    
    }

}
