/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package firstthread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author Standard
 */
public class Main_1 {

    /**
     * Example of thread pool , 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ExecutorService pool = Executors.newFixedThreadPool(2);
        
        final Runnable printer1 = new Printer("Hi there from first thread", 9);
//        final Thread thread = new Thread(printer1);

        pool.execute(printer1);
        
        final Runnable printer2 = new Printer("Hi there from second thread", 9);
//        final Thread thread2 = new Thread(printer2);
        
         pool.execute(printer2);
         
        final Runnable printer3 = new Printer("Hi there from third thread", 9);
//        final Thread thread3 = new Thread(printer3);
        
         pool.execute(printer3);
        
       pool.shutdown();
    }
}
