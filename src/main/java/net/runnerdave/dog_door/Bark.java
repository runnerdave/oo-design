package net.runnerdave.dog_door;

/**
 * Created by davidajimenez on 27/11/2016.
 */
public class Bark {
    String barkSound;

    public String getBarkSound() {
        return barkSound;
    }

    public Bark(String barkSound) {
        this.barkSound = barkSound;
    }

    @Override
    public boolean equals(Object anotherBark) {
        if(anotherBark instanceof Bark) {
            if (((Bark) anotherBark).getBarkSound().equalsIgnoreCase(this.barkSound)){
                return true;
            }
        }
        return false;
    }
}
