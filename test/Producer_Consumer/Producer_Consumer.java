/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Producer_Consumer;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author Standard
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({BoundedBuffer_Test.class, Middleman_Test.class})
public class Producer_Consumer {

    @Before
    public void setUp() throws Exception {
    }
    
}
