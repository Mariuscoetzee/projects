/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Producer_Consumer;

import java.util.Queue;

/**
 *
 * @author Standard
 */
public abstract class AbstractBuffer implements Buffer {
    /**
     * A bounded buffer. Methods are thread safe
     */
    protected Queue<Integer> boundedBufferQeue;

    @Override
    public int getSize() {
        return boundedBufferQeue.size();
    }

    public boolean isEmpty() {
        return boundedBufferQeue.isEmpty();
    }

    /**
     * Removes an item from this buffer
     * @return - the item that was removed
     */
    public synchronized int take() {
        while (isEmpty()) {
            try {
                System.out.println(Thread.currentThread().getName() + " waiting ...");
                wait();
            } catch (InterruptedException ex) {
            }
        }
        notifyAll();
        if (boundedBufferQeue.peek() == Producer.STOP_VALUE) {
            System.out.println(Thread.currentThread().getName() + " peeked :" + Producer.STOP_VALUE + " buffer : ");
            return Producer.STOP_VALUE;
        } else {
            return boundedBufferQeue.poll();
        }
    }
    
}
