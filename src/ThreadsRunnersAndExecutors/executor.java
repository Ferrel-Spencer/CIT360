package ThreadsRunnersAndExecutors;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/** Just a basic executor
 * Created by SFerrel on 6/10/2017.
 */
public class executor{
    public static void main(String[] args) throws InterruptedException{

        ExecutorService executorService = Executors.newFixedThreadPool(100);
        for(int i=0; i<=10; i++){
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                    System.out.println("Hello!");
                    Thread.currentThread().sleep(200);
                    System.out.println("HoLa");
                    Thread.currentThread().sleep(200);
                }catch (Exception e){

                    }
            }});
        }
    }
}
