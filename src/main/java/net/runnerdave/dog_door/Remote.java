package net.runnerdave.dog_door;

/**
 * Created by davidajimenez on 24/11/2016.
 */
public class Remote {
    private DogDoor door;

    public Remote(DogDoor door) {
        this.door = door;
    }

    public void pressButton() {
        System.out.println("Pressing the remote control button...");
        if (door.isOpen()) {
            door.close();
        } else {
            door.open();
        }
    }

}
