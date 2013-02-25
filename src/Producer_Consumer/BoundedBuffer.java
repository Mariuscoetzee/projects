/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Producer_Consumer;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Standard
 */
public class BoundedBuffer  {
 
 /**
 * A bounded buffer. Methods are thread safe
 */
    private static final int STOP_VALUE = 1;
    private static Queue<Integer> boundedBufferQeue;
    private static int capacity;
    
    /**
     * 
     * @param capacity - The capacity of the buffer. The capacity remains fixed throughout the buffers life. 
     */
    public BoundedBuffer(final int capacity){
        if (capacity == 0){
            throw new IllegalArgumentException("A bounded buffer has to have a capacity greater than 0");
        }
        BoundedBuffer.capacity = capacity;
        boundedBufferQeue = new LinkedList<Integer>();
    }
    /**
     * Removes an item from this buffer
     * @return - the item that was removed
     */
    public synchronized int take(){
        while (isEmpty()){
            try {
                wait();
            }
            catch (InterruptedException ex){  
            }
        }
        notifyAll();
        return boundedBufferQeue.poll();
    }
    
    /**
     * Put a new item into this buffer
     * @param element - the item to be inserted 
     */
    public void put(int element){
        
    }
    /**
     * Put a new item into this buffer
     * @return true if empty... 
     */    
   
    public boolean isEmpty(){
        return (boundedBufferQeue.isEmpty());
    }
    
    public boolean isFull(){
        return(capacity == boundedBufferQeue.size());
    }
}
