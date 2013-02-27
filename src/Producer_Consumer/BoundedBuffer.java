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
public final  class BoundedBuffer implements Buffer   {
 
 /**
 * A bounded buffer. Methods are thread safe
 */
    private Queue<Integer> boundedBufferQeue;
    private int capacity;
    public final String name;
    
    /**
     * 
     * @param capacity - The capacity of the buffer. The capacity remains fixed throughout the buffers life. 
     */
    public BoundedBuffer (final int capacity, String name){
        this.name = name;
        if (capacity == 0){
            throw new IllegalArgumentException("A bounded buffer has to have a capacity greater than 0");
        }
        this.capacity = capacity;
        boundedBufferQeue = new LinkedList<Integer>();
    }
    /**
     * Removes an item from this buffer
     * @return - the item that was removed
     */
    public synchronized int take(){
        while (isEmpty()){
            try {
                System.out.println(Thread.currentThread().getName() + " waiting ...");
                wait();
            }
            catch (InterruptedException ex){  
            }
        }
        notifyAll();
        
        if (boundedBufferQeue.peek() == Producer.STOP_VALUE){
             System.out.println(Thread.currentThread().getName() + " peeked :" + Producer.STOP_VALUE  + " buffer : "+ this.name );
             return Producer.STOP_VALUE;
        }else{
            return boundedBufferQeue.poll();
        }
       
    }
    
    /**
     * Put a new item into this buffer
     * @param element - the item to be inserted 
     */
    public synchronized void put(int element){
        while (isFull()){
            try {
                System.out.println(Thread.currentThread().getName() + " waiting ...");
                wait();
            } catch (InterruptedException ex) {
            }
        }
        System.out.println(Thread.currentThread().getName() + " Added : " + element);
        boundedBufferQeue.add(element);
        notify();
    }
    /**
     * Put a new item into this buffer
     * @return true if empty... 
     */    
   
    public boolean isEmpty(){
        return (boundedBufferQeue.isEmpty());
    }
    
    public boolean isFull(){
        return(boundedBufferQeue.size()== capacity);
    }

    public int getCapacity() {
        return capacity;
    }
    
    @Override
    public int getSize(){
        return boundedBufferQeue.size();
    }

}
