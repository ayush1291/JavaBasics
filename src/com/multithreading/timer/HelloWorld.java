import java.util.Timer;
import java.util.TimerTask;

public class HelloWorld{
    public static void main(String args[]){
        
        TimerTask timerTask = new MyTimerTask();
        //running timer task as daemon thread
        Timer timer = new Timer(true);
        //(timertask, startTime, interval (here 5 secs))
        timer.scheduleAtFixedRate(timerTask, 0, 5*1000);
        System.out.println("TimerTask started");
        //cancel after sometime
        try {
            Thread.sleep(25000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        timer.cancel();
        System.out.println("TimerTask cancelled");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Shotdown");
    }

}