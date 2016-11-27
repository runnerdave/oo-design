package net.runnerdave.rick_guitars.guitar_shop;

/**
 * Created by davidajimenez on 23/11/2016.
 */
public class Guitar {
    private String serialNumber;
    private double price;
    GuitarSpec spec;

    @Override
    public String toString() {
        return "Guitar{" +
                "serialNumber='" + serialNumber + '\'' +
                ", price=" + price +
                ", spec=" + spec +
                '}';
    }

    public String printSearchForSearchMatch() {
        return "  We have a " +
                spec.getBuilder() + " " + spec.getModel() + " " +
                spec.getType() + " guitar:\n     " +
                spec.getBackWood() + " back and sides,\n     " +
                spec.getTopWood() + " top.\n  You can have it for only $" +
                this.getPrice() + "!\n  ----";
    }

    public Guitar(String serialNumber, double price,
                  GuitarSpec spec) {
        this.serialNumber = serialNumber;
        this.price = price;
        this.spec = spec;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(float newPrice) {
        this.price = newPrice;
    }

    public GuitarSpec getSpec() {
        return spec;
    }


}
