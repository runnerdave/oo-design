package net.runnerdave.route_finder.loader;

import net.runnerdave.route_finder.subway.Connection;
import net.runnerdave.route_finder.subway.Station;
import net.runnerdave.route_finder.subway.Subway;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by davidajimenez on 10/12/2016.
 */
public class SubwayLoader {
    private Subway subway;

    public SubwayLoader() {
        this.subway = new Subway();
    }

    public static void main(String[] args) throws IOException {
        System.out.println("== Welcome to the Route Finder ==");
        SubwayLoader sb = new SubwayLoader();
        File inputFile = new File("documents/route-finder/input-file.txt");
        sb.readFile(inputFile);
        sb.subway.getConnections().forEach(System.out::println);
        sb.subway.getStations().forEach(System.out::println);
        sb.subway.getNetwork().forEach((k,v)->{
            System.out.println(k.toString() + "|connecions:" + v.toString());
        });
    }

    public Subway getSubway() {
        return subway;
    }

    public void readFile(File source) throws IOException {
        if (!source.exists()) {
            throw new RuntimeException("file does not exist");
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(source))) {
            loadStations(subway, reader);
            String lineName = reader.readLine();
            while(lineName != null && lineName.length() > 0) {
                loadConnections(subway, reader, lineName);
                lineName = reader.readLine();
            }
        }
    }

    private void loadConnections(Subway subway, BufferedReader reader, String lineName) throws IOException {
        String station1 = reader.readLine();
        String station2 = reader.readLine();
        while (station2 != null && station2.length() > 0) {
            subway.addConnection(lineName, station1, station2);
            station1 = station2;
            station2 = reader.readLine();
        }
    }

    private void loadStations(Subway subway, BufferedReader reader) throws IOException {
        String currentLine = reader.readLine();
        while (currentLine.length() > 0) {
            subway.addStation(new Station(currentLine));
            currentLine = reader.readLine();
        }
    }
}
