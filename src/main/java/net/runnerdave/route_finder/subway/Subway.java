package net.runnerdave.route_finder.subway;

import java.util.*;

/**
 * Created by davidajimenez on 9/12/2016.
 */
public class Subway {
    private List<Connection> connections;
    private List<Station> stations;

    public Map<Station, List<Station>> getNetwork() {
        return network;
    }

    private Map<Station, List<Station>> network;

    public Subway() {
        this.stations = new ArrayList<>();
        this.connections = new ArrayList<>();
        this.network = new HashMap<>();
    }

    public void addStation(Station s) {
        if(!hasStation(s.getName())){
            stations.add(s);
        }
    }

    private boolean hasStation(String stationName) {
        return stations.contains(new Station(stationName));
    }

    public void addConnection(String lineName, String stationName1, String stationName2) {
        if(hasStation(stationName1) && hasStation(stationName2)) {
            Station station1 = new Station(stationName1);
            Station station2 = new Station(stationName2);
            Connection connection = new Connection(station1, station2, lineName);
            connections.add(connection);
            connections.add(new Connection(station2, station1, lineName));
            addToNetwork(station1, station2);
            addToNetwork(station2, station1);
        }
    }

    public Optional<Connection> getOptionalConnection(Station station1, Station station2) {
        return connections.stream().filter(s-> (s.getStation1().equals(station1) &&
                                                s.getStation2().equals(station2))).findFirst();
    }

    private Connection getConnection(Station station1, Station station2) {
        for (Iterator i = connections.iterator(); i.hasNext(); ) {
            Connection connection = (Connection) i.next();
            Station one = connection.getStation1();
            Station two = connection.getStation2();
            if ((station1.equals(one)) && station2.equals(two)) {
                return connection;
            }
        }
        return null;
    }


    private void addToNetwork(Station station1, Station station2) {
        if(network.containsKey(station1)) {
            List<Station> list = network.get(station1);
            if(!list.contains(station2)){
                list.add(station2);
            }
        } else {
            List<Station> list = new ArrayList<>();
            list.add(station2);
            network.put(station1, list);
        }
    }

    public List<Station> getStations(){
        return this.stations;
    }

    public List<Connection> getConnections() {
        return this.connections;
    }

    public List<Connection> getDirections(String startStationName, String endStationName) {
        if (!this.hasStation(startStationName) || !this.hasStation(endStationName))
        {
            throw new RuntimeException("Stations entered do not exist on this subway");
        }

        Station start = new Station(startStationName);
        Station end = new Station(endStationName);
        List<Connection> route = new LinkedList();
        List<Station> reachableStations = new LinkedList();
        Map<Station, Station> previousStations = new HashMap();
        List<Station> neighbors = network.get(start);

        for (Iterator i = neighbors.iterator(); i.hasNext(); ) {
            Station station = (Station) i.next();
            if (station.equals(end)) {
                route.add(getConnection(start, end));
                return route;
            } else {
                reachableStations.add(station);
                previousStations.put(station, start);
            }
        }

        List<Station> nextStations = new LinkedList<>();
        nextStations.addAll(neighbors);
        Station currentStation = start;

        searchLoop:
        for (int i = 1; i < stations.size(); i++) {
            List tmpNextStations = new LinkedList();
            for (Iterator j = nextStations.iterator(); j.hasNext(); ) {
                Station station = (Station) j.next();
                reachableStations.add(station);
                currentStation = station;
                List<Station> currentNeighbors = network.get(currentStation);
                for (Iterator k = currentNeighbors.iterator(); k.hasNext(); ) {
                    Station neighbor = (Station) k.next();
                    if (neighbor.equals(end)) {
                        reachableStations.add(neighbor);
                        previousStations.put(neighbor, currentStation);
                        break searchLoop;
                    } else if (!reachableStations.contains(neighbor)) {
                        reachableStations.add(neighbor);
                        tmpNextStations.add(neighbor);
                        previousStations.put(neighbor, currentStation);
                    }
                }
            }
            nextStations = tmpNextStations;
        }

        //We've found the path now!
        boolean keepLooping = true;
        Station keyStation = end;
        Station station;

        while (keepLooping) {
            station = previousStations.get(keyStation);
            route.add(0, getConnection(station, keyStation));
            if (start.equals(station)) {
                keepLooping = false;
            }
            keyStation = station;
        }

        return route;
    }

}
