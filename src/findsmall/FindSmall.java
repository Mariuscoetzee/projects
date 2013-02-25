
package findsmall;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FindSmall {

    /* array of arrays of integers */
    private static final int[][] DATA = new int[][]{
        {4, 3, 28, 22, 8},
        {333, 2, 2, 454, 9},
        {22, 3, 25, 3, 5, 565, 4, 3, 9}
    };

   
    /**
     * @param args the command line arguments
     */
    public static void main(final String[] args) {
        
        ExecutorService pool = Executors.newFixedThreadPool(3);
        
        for (int[] data : DATA) {
           final Runnable worker = new Worker(data);
           pool.execute(worker);
        }
         pool.shutdown();
    }
}
