package net.runnerdave.route_finder.subway;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by davidajimenez on 9/12/2016.
 */
public class Subway {
    private List<Connection> connections;
    private List<Station> stations;

    public Subway() {
        this.stations = new ArrayList<>();
        this.connections = new ArrayList<>();
    }

    public void addStation(Station s) {
        if(!hasStation(s.getName())){
            stations.add(s);
        }
    }

    private boolean hasStation(String stationName) {
        return stations.contains(new Station(stationName));
    }

    public void addConnection(String lineName, String station1, String station2) {
        if(hasStation(station1) && hasStation(station2)) {
            Connection connection = new Connection(new Station(station1), new Station(station2), lineName);
            connections.add(connection);
        }
    }

    public List<Station> getStations(){
        return this.stations;
    }

    public List<Connection> getConnections() {
        return this.connections;
    }


}
