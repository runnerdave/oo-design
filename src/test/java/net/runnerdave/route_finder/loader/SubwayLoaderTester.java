package net.runnerdave.route_finder.loader;

import net.runnerdave.route_finder.subway.Connection;
import net.runnerdave.route_finder.subway.Station;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by davidajimenez on 12/12/2016.
 */
public class SubwayLoaderTester {
    @Test
    public void testLoadStations() throws IOException {
        SubwayLoader sbl = new SubwayLoader();
        File inputFile = new File("documents/route-finder/input-file.txt");
        sbl.readFile(inputFile);
        List<Station> stations = sbl.getSubway().getStations();
        Assert.assertEquals(stations.contains(new Station("Ajax Rapids")), true);
        Assert.assertEquals(stations.contains(new Station("Ajax Rapido")), false);
        Assert.assertEquals(stations.contains(new Station("LSP Lane")), true);
        Assert.assertEquals(stations.contains(new Station("Objectville Diner")), true);
    }

    @Test
    public void testLoadConnections() throws IOException {
        SubwayLoader sbl = new SubwayLoader();
        File inputFile = new File("documents/route-finder/input-file.txt");
        sbl.readFile(inputFile);
        List<Connection> connections = sbl.getSubway().getConnections();
        Assert.assertEquals(connections.contains(new Connection(new Station("Ajax Rapids"), new Station("UML Walk"), "Booch Line")), true);
    }
}
