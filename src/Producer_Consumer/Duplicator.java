/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Producer_Consumer;

/**
 *
 * @author Standard
 */
public class Duplicator implements Runnable {
    private BoundedBuffer inputBuffer;
    private BoundedBuffer outputBuffer;
    private BoundedBuffer outputBuffer_1;
    
    public Duplicator (BoundedBuffer inputBuffer, BoundedBuffer outputBuffer, BoundedBuffer outputBuffer_1){
        this.inputBuffer = inputBuffer;
        this.outputBuffer = outputBuffer;
        this.outputBuffer_1 = outputBuffer_1;
    }

    @Override
    public void run() {
        int i;
        for (i = 0; i != Producer.STOP_VALUE; i++) {
            inputBuffer.take();
        }
    }
    
}
