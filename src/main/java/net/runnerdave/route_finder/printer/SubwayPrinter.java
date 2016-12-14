package net.runnerdave.route_finder.printer;

import net.runnerdave.route_finder.subway.Connection;

import java.io.PrintStream;
import java.util.List;

/**
 * Created by davidajimenez on 14/12/2016.
 */
public class SubwayPrinter {
    private PrintStream out;

    public SubwayPrinter(PrintStream out) {
        this.out = out;
    }

    public void printRoute(List<Connection> connectionList) {
        Connection firstConnection = connectionList.get(0);
        out.format("Start out at: %s", firstConnection.getStation1().getName());
        out.format("\nGet on the %s heading towards %s.",
                firstConnection.getLineName(),
                firstConnection.getStation2().getName());
        if (connectionList.size() > 2) {
            for (int i = 1; i < connectionList.size(); i++) {
                Connection currentConnection = connectionList.get(i);
                Connection previousConnection = connectionList.get(i - 1);
                if (!currentConnection.getLineName().equalsIgnoreCase(previousConnection.getLineName())) {
                    out.format("\nWhen you get to %s, get off the %s.\n Switch over to the %s, heading towards %s",
                            currentConnection.getStation1().getName(),
                            previousConnection.getLineName(),
                            currentConnection.getLineName(),
                            currentConnection.getStation2().getName());
                } else {
                    out.format("\n    Continue past %s", currentConnection.getStation1().getName());
                }
            }
        }
        out.format("\nGet off at %s and enjoy yourself.",
                connectionList.get(connectionList.size() - 1).getStation2().getName());
    }
}
