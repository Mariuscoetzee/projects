/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Producer_Consumer;

/**
 *
 * @author Standard
 */
public class Producer implements Runnable{
/**
 * Special element sent from the Producer to signal that the Producer has stopped producing, and has terminated. 
 */
    public static final int STOP_VALUE = -2147483648;
    private PutBuffer buffer;
    private int max;
    /**
     * Creates a new instance of Producer 
     * @param max - the number of items that this Producer should produce
     * @param buffer  - the Buffer to put the items into
     */
    public Producer(int max, PutBuffer buffer){
       this.buffer = buffer;
       this.max = max;
    }
   
    /**
     * Runs this Producer
     */
    @Override
    public void run() {
        for (int i = 0; i < max ; i++) {
            buffer.put(i);
        }
       buffer.put(STOP_VALUE);
    }
    
    public void setmax(final int max){
        this.max = max;
        
    }
}
