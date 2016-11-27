package net.runnerdave.dog_door;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by davidajimenez on 24/11/2016.
 */
public class DogDoor {
    private boolean open;
    private List<Bark> allowedBarks;


    public DogDoor() {
        this.open = false;
        this.allowedBarks =  new ArrayList<>();
    }

    public List<Bark> getAllowedDogBarks() {
        return allowedBarks;
    }

    public void addAllowedDogBark(Bark allowedBark) {

        this.allowedBarks.add(allowedBark);
    }

    public void open() {
        System.out.println("The dog door opens.");
        open = true;
        TimerUtils.delayWithConcurrentAPI(this, 5);
    }

    public void close() {
        System.out.println("The dog door closes.");
        open = false;
    }

    public boolean isOpen() {
        return open;
    }
}
