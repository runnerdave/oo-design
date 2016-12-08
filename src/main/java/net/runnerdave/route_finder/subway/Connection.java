package net.runnerdave.route_finder.subway;

/**
 * Created by davidajimenez on 9/12/2016.
 */
public class Connection {
    private Station station1;
    private Station station2;
    private String lineName;

    public Station getStation1() {
        return station1;
    }

    public Station getStation2() {
        return station2;
    }

    public String getLineName() {
        return lineName;
    }

    public Connection(Station station1, Station station2, String lineName) {

        this.station1 = station1;
        this.station2 = station2;
        this.lineName = lineName;
    }
}