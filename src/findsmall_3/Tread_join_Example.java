/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package findsmall_3;

import java.util.ArrayList;

public class Tread_join_Example {
    
    private ArrayList<String> threadNames = new ArrayList<String>();
    private static int threadcount;
    
    public static void main(String[] args) throws InterruptedException {
        Tread_join_Example test = new Tread_join_Example();
        test.threadTest(Integer.parseInt(args[0]));
        System.out.println(test.threadNames.size()); 
        System.out.println(threadcount);
    }
    
    private void threadTest(int numOfThreads) throws InterruptedException {
       
        Thread[] threads = new Thread[numOfThreads];
        
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Tread_join_Example.MyThread(); 
            threads[i].start();
            threadcount = threadcount + 1;
        }
        
//        for (int i = 0; i < threads.length ; i++) {
//             threads[i].join();     
//            }
    }
    
    class MyThread extends Thread { 
        public void run()
        {
        for (int i = 0; i < 1; i++) {
            i = i + 0;     
        }     
        threadNames.add(getName()); 
        }
    }
} 

