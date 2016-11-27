package net.runnerdave.dog_door;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by davidajimenez on 26/11/2016.
 */
public class TimerUtils {
    public static void delayWithTimer(DogDoor door, int seconds) {
        final Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                door.close();
                timer.cancel();
            }
        }, seconds * 1000);
    }

    public static void delayWithConcurrentAPI(DogDoor door, int seconds) {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        Runnable task = () -> door.close();
        executor.schedule(task, seconds, TimeUnit.SECONDS);
        executor.shutdown();
    }

    public static void delayWithThreadDirectly(int seconds) {
        try{
            Thread.currentThread().sleep(seconds*1000);
        } catch (InterruptedException e) {
            //do nothing
        }
    }
}
