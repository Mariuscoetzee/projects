/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Producer_Consumer;

/**
 *A MiddleMan acts as a combined Producer and Consumer.
 *A MiddleMan forwards items taken from one Buffer to another Buffer.
 * @author Standard
 */
public class MiddleMan {
        private static MiddleMan singleton = null;
        private BoundedBuffer fromBuffer;
        private BoundedBuffer toBuffer;
        
    /**
     * Creates a new instance of MiddleMan
     * @param fromBuffer - The Buffer where the MiddleMan should take the items.
     * @param toBuffer - The Buffer where the MiddleMan should put the items.
     */
       
    private MiddleMan(BoundedBuffer fromBuffer, BoundedBuffer toBuffer){
               
    }
    
    public static MiddleMan getInstance(BoundedBuffer fromBuffer, BoundedBuffer toBuffer){
        if (singleton == null){
        return new MiddleMan(fromBuffer, toBuffer);   
        }
        else 
        {
            return singleton;
        }    
    }

    void doMiddlemanStuff() {
  
  int theInt = fromBuffer.take();
  while (theInt != 0){
      theInt = fromBuffer.take();
      System.out.println(Thread.currentThread().getName() +" Took :" + theInt + " from buffer");
      toBuffer.put(theInt);
      System.out.println(Thread.currentThread().getName() +" Put :" + theInt + " from buffer");
      }
    }
    
    
}
