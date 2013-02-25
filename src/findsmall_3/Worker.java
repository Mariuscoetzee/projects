/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package findsmall_3;

import java.util.Arrays;

/**
 *
 * @author Standard
 */
public class Worker extends Thread {
    
    private int[] numbers;
    private int smallestSoFar;

    Worker(int[] numbers){
        this.numbers = numbers;
    }
    
    @Override
    public void run() {
        if (numbers.length < 1) {
            throw new IllegalArgumentException("There must be at least one element in the array");
        }

        smallestSoFar = numbers[0];
        for (int number : numbers) {
            if (number < smallestSoFar) {
                smallestSoFar = number;
            }
        }
    }
    
    public int getResult(){
        return smallestSoFar;
    }

}
