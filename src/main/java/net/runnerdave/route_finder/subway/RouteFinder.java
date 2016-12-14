package net.runnerdave.route_finder.subway;

import net.runnerdave.route_finder.loader.SubwayLoader;
import net.runnerdave.route_finder.printer.SubwayPrinter;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by davidajimenez on 14/12/2016.
 */
public class RouteFinder {
    public static void main(String[] args) throws IOException {
        SubwayPrinter sbp = new SubwayPrinter(System.out);
        SubwayLoader sbl = new SubwayLoader();
        File inputFile = new File("documents/route-finder/input-file.txt");
        sbl.readFile(inputFile);

        System.out.println("== Welcome to the Route Finder ==");


//        sbl.getSubway().getConnections().forEach(System.out::println);
//        sbl.getSubway().getStations().forEach(System.out::println);
//        sbl.getSubway().getNetwork().forEach((k,v)->{
//            System.out.println(k.toString() + "|connecions:" + v.toString());
//        });
        System.out.println("== get directions from \"GoF Gardens\" to \"Objectville Diner\"");
        List<Connection> route = sbl.getSubway().getDirections("GoF Gardens", "Objectville Diner");
        //route.stream().forEach(System.out::println);
        sbp.printRoute(route);

        System.out.println("\n");

        System.out.println("== get directions from \"EJB Estates\", \"UML Walk\"");
        route = sbl.getSubway().getDirections("EJB Estates", "UML Walk");
        //route.stream().forEach(System.out::println);
        sbp.printRoute(route);

        System.out.println("\n");

        System.out.println("== get directions from \"JavaRanch\", \"Head First Lounge\"");
        route = sbl.getSubway().getDirections("JavaRanch", "Head First Lounge");
//        route.stream().forEach(System.out::println);
        sbp.printRoute(route);

    }
}
