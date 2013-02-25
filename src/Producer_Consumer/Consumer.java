
package Producer_Consumer;

/**
 *
 * @author Marius
 * A Consumer in a Producer-Consumer application
 */
public class Consumer implements Runnable{
public static final int STOP_VALUE = 1;

    private BoundedBuffer buffer;
    /**
     * Creates a new instance of Consumer 
     * @param buffer - The Buffer where this Consumer takes its items.
     */
    public Consumer(BoundedBuffer buffer) {
        this.buffer = buffer;
    }

 
    @Override
    public void run() {

    while (buffer.take() != STOP_VALUE){
      System.out.println(Thread.currentThread().getName() + " took : " + buffer.take() );
    }
  
    }
    
}
