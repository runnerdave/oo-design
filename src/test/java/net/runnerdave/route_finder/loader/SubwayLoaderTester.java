package net.runnerdave.route_finder.loader;

import net.runnerdave.route_finder.subway.Connection;
import net.runnerdave.route_finder.subway.Station;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

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
        Assert.assertEquals(connections.contains(new Connection(new Station("Head First Lounge"), new Station("OOA&D Oval"), "Gamma Line")), true);
        Assert.assertEquals(connections.contains(new Connection(new Station("Servlet Springs"), new Station("Mighty Gumball, Inc."), "Jacobson Line")), true);
        Assert.assertEquals(connections.contains(new Connection(new Station("Ajax Rapids"), new Station("Bullshit Walk"), "Booch Line")), false);
    }

    @Test
    public void testGetConnection() throws IOException {
        SubwayLoader sbl = new SubwayLoader();
        File inputFile = new File("documents/route-finder/input-file.txt");
        sbl.readFile(inputFile);
        Optional<Connection> connection = sbl.getSubway().getConnection(new Station("Ajax Rapids"), new Station("UML Walk"));
        Assert.assertEquals(new Connection(new Station("Ajax Rapids"), new Station("UML Walk"), "Booch Line"), connection.get());

        Optional<Connection> connection2 = sbl.getSubway().getConnection(new Station("Ajax Rapido"), new Station("UML Walk"));
        Assert.assertEquals(null, connection2.orElse(null));

        Optional<Connection> connection3 = sbl.getSubway().getConnection(new Station("JavaRanch"), new Station("JSP Junction"));
        Assert.assertEquals(new Connection(new Station("JavaRanch"), new Station("JSP Junction"), "Jacobson Line"), connection3.get());

    }

    @Test
    public void testGetDirections() throws IOException {
        SubwayLoader sbl = new SubwayLoader();
        File inputFile = new File("documents/route-finder/input-file.txt");
        sbl.readFile(inputFile);
        Optional<Connection> connection = sbl.getSubway().getConnection(new Station("Ajax Rapids"), new Station("UML Walk"));
        Assert.assertEquals(new Connection(new Station("Ajax Rapids"), new Station("UML Walk"), "Booch Line"), connection.get());

//        List<Connection> route = sbl.getSubway().getDirections("HTML Heights", "XHTML Expressway");
//        Assert.assertEquals(2, route.size());
//
//        route = sbl.getSubway().getDirections("JavaRanch", "JSP Junction");
//        Assert.assertEquals(1, route.size());
//
//
//        route = sbl.getSubway().getDirections("JavaRanch", "Servlet Springs");
//        Assert.assertEquals(3, route.size());
//
//        route = sbl.getSubway().getDirections("EJB Estates", "Break Neck Pizza");
//        Assert.assertEquals(1, route.size());

        List<Connection> route = sbl.getSubway().getDirections("The Tikibean Lounge", "Algebra Avenue");
        Assert.assertEquals(6, route.size());
    }
}
