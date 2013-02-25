
package findsmall_3;
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
    public static void main(final String[] args) throws InterruptedException {
        
        Thread[]threads = new Thread[Integer.parseInt(args[0])];
        Worker[]workers = new Worker[Integer.parseInt(args[0])];
        
        for (int i = 0; i < threads.length; i++) {
            Worker worker = new Worker(DATA[i]);
            workers[i]= worker;
            threads[i]= new Thread(worker);
            threads [i].start();
        }
        
        for (int i = 0; i < threads.length; i++) {
            threads[i].join();
            System.err.println("Dude : " +workers[i].getResult());
        }


    }
}
