/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package findsmall;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Standard
 */
public class Worker implements Runnable {
    
    private int[] numbers;

    Worker(int[] numbers){
        this.numbers = numbers;
    }
    
    @Override
    public void run() {
        if (numbers.length < 1) {
            throw new IllegalArgumentException("There must be at least one element in the array");
        }

        int smallestSoFar = numbers[0];
        for (int number : numbers) {
            if (number < smallestSoFar) {
                smallestSoFar = number;
            }
        }
        System.out.println(Arrays.toString(numbers) + ": " +  smallestSoFar);
    }

}
