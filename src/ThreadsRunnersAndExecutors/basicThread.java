package ThreadsRunnersAndExecutors;

/**
 * Created by SFerrel on 6/10/2017. This is just a basic thread
 */
public class basicThread extends Thread {
    public void run() {
            System.out.println("This is the output from basicThread");
        }

// this is where the thread is actually called
    public static void main(String[] args){
        basicThread bt = new basicThread();
        bt.run();
    }

    }












