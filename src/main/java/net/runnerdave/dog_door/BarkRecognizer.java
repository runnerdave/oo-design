package net.runnerdave.dog_door;

/**
 * Created by davidajimenez on 26/11/2016.
 */
public class BarkRecognizer {
    private DogDoor door;

    public BarkRecognizer(DogDoor door) {
        this.door = door;
    }

    public void recognizeBark(Bark bark) {
        System.out.println("Recognized the following bark sound: " + bark.getBarkSound());
        if (door.getAllowedDogBarks().contains(bark)) {
            door.open();
        } else {
            System.out.println("not a valid bark");
        }
    }

}
