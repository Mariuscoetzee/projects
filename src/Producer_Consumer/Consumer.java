
package Producer_Consumer;

/**
 *
 * @author Marius
 * A Consumer in a Producer-Consumer application
 */
public class Consumer implements Runnable{


    private TakeBuffer buffer;
    /**
     * Creates a new instance of Consumer 
     * @param buffer - The Buffer where this Consumer takes its items.
     */
    public Consumer(TakeBuffer buffer) {
        this.buffer = buffer;
    }
    
    @Override
    public void run() {
    int value = buffer.take();
    while (value != Producer.STOP_VALUE){
        value = buffer.take();    
        System.out.println(Thread.currentThread().getName() + " took : " + value + "from : ");
    }
    
    }
    
}
