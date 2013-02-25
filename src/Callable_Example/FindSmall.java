package Callable_Example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

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
    public static void main(final String[] args) throws InterruptedException, ExecutionException {
       
        
        ExecutorService pool = Executors.newFixedThreadPool(3);
        List<Future<Integer>> listOfFutures = new ArrayList<Future<Integer>>();
  
        for (int[] data : DATA) {
            Callable<Integer> worker = new Worker(data);
            Future<Integer> smallestFuture = pool.submit(worker);
            listOfFutures.add(smallestFuture);
        }

        for (Future<Integer> future : listOfFutures) {
          System.out.println(Arrays.toString(DATA[listOfFutures.indexOf(future)]) + ": " +  future.get());
        }
        pool.shutdown();
    }
}
