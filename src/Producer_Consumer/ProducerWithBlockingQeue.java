/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Producer_Consumer;

import java.util.concurrent.BlockingQueue;

/**
 *
 * @author Standard
 */

class ProducerWithBlockingQeue implements Runnable {
   private final BlockingQueue queue;
   
   public ProducerWithBlockingQeue(BlockingQueue q) { queue = q; }
   
   public void run() {
     try {
       while (true) { queue.put(produce()); }
     } catch (InterruptedException ex) {}
   }
   
   Object produce() {
       
    return "dude"; 
       }
   
   
   
//    class ConsumerWithBlockingQeue implements Runnable {
//   private final BlockingQueue queue;
//   Consumer(BlockingQueue q) { queue = q; }
//   public void run() {
//     try {
//       while (true) { consume(queue.take()); }
//     } catch (InterruptedException ex) { ... handle ...}
//   }
//   void consume(Object x) { ... }
// }
//
// class Setup {
//   void main() {
//     BlockingQueue q = new SomeQueueImplementation();
//     Producer p = new Producer(q);
//     Consumer c1 = new Consumer(q);
//     Consumer c2 = new Consumer(q);
//     new Thread(p).start();
//     new Thread(c1).start();
//     new Thread(c2).start();
//   }
// }
 
 }


