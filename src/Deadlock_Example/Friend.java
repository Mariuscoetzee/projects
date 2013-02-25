/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Deadlock_Example;

/**
 *
 * @author Standard
 */
public class Friend {
    private final String name;
    private  boolean bowing;
    private boolean didBow;

    public boolean isBowing() {
        return bowing;
    }
   
        public Friend (String name){
            this.name = name;
            this.bowing = false;
            this.didBow = false;
        }
        
        public String getName(){
            return this.name;
        }
        /**
         * 
         * @param friend 
         */
        public synchronized  void bow(Friend friend) throws InterruptedException{
            System.out.println(this.name  + " bowing  to: " + friend.getName() );
            this.bowing = true;
            this.didBow = true;
        while (!friend.isBowing()){
            try {
                wait();
            }
            catch (InterruptedException ex){
                System.out.println(ex.getMessage());
            }
        }
        this.bowing = false;
        }
       
        
}
