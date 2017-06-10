package ThreadsRunnersAndExecutors;

/**
 * Created by SFerrel on 6/10/2017. Purpose of this java class is test if multi threading is faster
 * than an traditional loop.
 */
public class multiThreadGuesser {

    public static void main(String[] args){

        //standard loop
        long startTime1 = System.nanoTime();
        int number;
        for (int i = 0; i < 105; i++) {
            comparison c = new comparison(i);
        }
        long endTime1 = System.nanoTime();


        //threads
        long startTime = System.nanoTime();
        oddGuesser thread1 = new oddGuesser();
        thread1.start();

        evenGuesser thread2 = new evenGuesser();
        thread2.start();
        long endTime = System.nanoTime();


        //Display of time it took each
        System.out.println("It took the loop " +(endTime1-startTime1)+" nano seconds");
        System.out.println("It took the threads " +(endTime-startTime)+" nano seconds");

    }
/** From what I can tell the loop is faster. I know that threads should be faster,
 *  but I'm not sure why this isn't displaying that.
 *  The threads are consistently about 1,000,000ns behind the loop.
 */

}

//comparison of numbers to find correct numbers
class comparison{
    public comparison(int number){
        if (number==4||number==5||number==101||number==100){
            System.out.println(/**"Nailed it! " + number + " is correct!"*/);
        }
        else{
        }

    }


}

//class that guesses all odd numbers
class oddGuesser extends Thread {
    public void show() {

        int oddNumbers =0;

        for (int i = 0; i < 105; i++) {
            if(i%2 !=0){
                oddNumbers = i;
            }
            comparison c = new comparison(oddNumbers);
        }
    }
    public void run(){
            show();
    }



}

//class that guesses all even numbers
class evenGuesser extends Thread {
    public void show() {

        int evenNumbers =0;

        for (int i = 0; i < 105; i++) {
            if(i%2 ==0){
                evenNumbers = i;
            }
            comparison c = new comparison(evenNumbers);
        }
    }
    public void run(){
        show();
    }



}

