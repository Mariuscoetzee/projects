/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Deadlock_Example;

/**
 * Example of deadlock scenario.
 * @author Standard
 */
public class DeadLock {
  
    public static void main(String [] args) throws InterruptedException{
        
        final Friend alphonse = new Friend("Alphonse");
        final Friend gastone = new Friend ("Gastone");
         
       Thread gastonesThread =  new Thread(
           new Runnable() {
            @Override
            public void run() {
                try {
                    alphonse.bow(gastone);
                } catch (InterruptedException ex) {
                    System.out.println("dude");
                }
            }
        }, "Gastone_bowing_to_Alphonse");
              
        Thread alphonsesThread = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    gastone.bow(alphonse);
                } catch (InterruptedException ex) {
                      System.out.println("dude");
                }
               
            }
        }, "Alphonse_Bowing_to_Gastone");
        
        gastonesThread.start();
        
        alphonsesThread.start();
        System.out.println("both bowing the hell out of each other");
        
        
    }
    
    
}
