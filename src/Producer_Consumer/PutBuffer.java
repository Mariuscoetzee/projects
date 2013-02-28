/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Producer_Consumer;

/**
 *
 * @author Standard
 */
public interface PutBuffer {
    
    boolean 	isEmpty();
    void 	put(int element);
    int 	getSize();
}
