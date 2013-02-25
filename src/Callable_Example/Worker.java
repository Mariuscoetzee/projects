/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Callable_Example;


import java.util.concurrent.Callable;


/**
 *
 * @author Standard
 */
public class Worker implements Callable<Integer> {
    
    private int[] numbers;
    private int smallestSoFar;
    
    Worker(int[] numbers){
        this.numbers = numbers;
    }
  
    @Override
    public Integer call() throws Exception {
        if (numbers.length < 1) {
            throw new IllegalArgumentException("There must be at least one element in the array");
        }
        smallestSoFar = numbers[0];
        for (int number : numbers) {
            if (number < smallestSoFar) {
                smallestSoFar = number;
            }
        }
        return smallestSoFar;
    }

   



}
