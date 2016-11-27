package net.runnerdave.dog_door;

import java.io.IOException;

/**
 * Created by davidajimenez on 24/11/2016.
 */
public class DogSimulator {
    public static void main(String[] args) throws IOException {
        DogDoor door = new DogDoor();
        Remote remote = new Remote(door);
        door.addAllowedDogBark(new Bark("Woof"));
        door.addAllowedDogBark(new Bark("rooowlf"));
        door.addAllowedDogBark(new Bark("rawlf"));
        door.addAllowedDogBark(new Bark("rowlf"));
        BarkRecognizer  recognizer = new BarkRecognizer(door);

        System.out.println("== Path with button clicking");

        System.out.println("Fido barks to go outside...");
        remote.pressButton();

        System.out.println("\nFido has gone outside...");
        //remote.pressButton(); --removed with the implementation of the automatic closing

        System.out.println("\nFido's all done...");
        //remote.pressButton();

        System.out.println("\nFido's back inside...");
        //remote.pressButton();

        System.out.println("\nPress enter when you are ready for the next path (you may want to wait for the door to close)...");

        System.in.read();

        System.out.println("== Path with bark recognizer");

        System.out.println("Fido barks...");
        recognizer.recognizeBark(new Bark("Woof"));

        System.out.println("\nFido has gone outside...");

        System.out.println("\nFido's all done...");

        TimerUtils.delayWithThreadDirectly(10);

        System.out.println("\n..but Fido is stuck outside!");

        System.out.println("Fido barks...");
        recognizer.recognizeBark(new Bark("rawlf"));
        System.out.println("\nFido's back inside...");

        System.out.println("== Path with a small dog bark recognizer");
        Bark smallDogBark = new Bark("yip");
        recognizer.recognizeBark(smallDogBark);


    }

}
