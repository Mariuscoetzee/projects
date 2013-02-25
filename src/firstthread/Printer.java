package firstthread;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author andersb
 */
public class Printer implements Runnable {
    private final String message;
    private final int howManyTimes;

    public Printer(final String message, int howManyTimes) {
        this.message = message;
        this.howManyTimes = howManyTimes;
        
    }

    public void run(){
        for (int i = 0; i < howManyTimes; i++) {
            System.out.println(i + ":" + message);
            try {
                Thread.sleep(0);
                
            } catch (InterruptedException ex) {
                Logger.getLogger(Printer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
