package net.runnerdave.route_finder.subway;

/**
 * Created by davidajimenez on 9/12/2016.
 */
public class Station {
    private String name;

    public String getName() {
        return name;
    }

    public Station(String name) {

        this.name = name;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Station station = (Station) o;

        return name.equalsIgnoreCase(station.name);

    }

    @Override
    public int hashCode() {
        return name.toLowerCase().hashCode();
    }
}
