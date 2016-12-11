package net.runnerdave.route_finder.subway;

/**
 * Created by davidajimenez on 9/12/2016.
 */
public class Connection {
    private Station station1;
    private Station station2;
    private String lineName;

    public Connection(Station station1, Station station2, String lineName) {
        this.station1 = station1;
        this.station2 = station2;
        this.lineName = lineName;
    }

    public Station getStation1() {
        return station1;
    }

    public Station getStation2() {
        return station2;
    }

    public String getLineName() {
        return lineName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Connection that = (Connection) o;

        if (getStation1() != null ? !getStation1().getName().equalsIgnoreCase(that.getStation1().getName()) : that.getStation1() != null)
            return false;
        if (getStation2() != null ? !getStation2().getName().equalsIgnoreCase(that.getStation2().getName()) : that.getStation2() != null)
            return false;
        return getLineName() != null ? getLineName().equalsIgnoreCase(that.getLineName()) : that.getLineName() == null;

    }

    @Override
    public int hashCode() {
        int result = getStation1() != null ? getStation1().hashCode() : 0;
        result = 31 * result + (getStation2() != null ? getStation2().hashCode() : 0);
        result = 31 * result + (getLineName() != null ? getLineName().hashCode() : 0);
        return result;
    }
}
