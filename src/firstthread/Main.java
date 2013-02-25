package firstthread;

/**
 *
 * @author andersb
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(final String[] args) {
        final Runnable printer1 = new Printer("Hi there from first thread", 9);
        final Thread thread = new Thread(printer1);

        final Runnable printer2 = new Printer("Hi there from second thread", 9);
        final Thread thread2 = new Thread(printer2);
        
        final Runnable printer3 = new Printer("Hi there from third thread", 9);
        final Thread thread3 = new Thread(printer3);

        
        thread.setPriority(Thread.MIN_PRIORITY);
        thread2.setPriority(Thread.MAX_PRIORITY);
        thread3.setPriority(Thread.NORM_PRIORITY);
        thread.start();
        thread2.start();
        thread3.start();
    }
}
