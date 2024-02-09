import java.time.Duration;
import java.util.*;

public class Logic {

    public static List<LocationNode> calculatePath(LocationNode start, LocationNode end) {
        Map<LocationNode, Duration> shortestDistances = new HashMap<>();
        Map<LocationNode, LocationNode> predecessors = new HashMap<>();
        Set<LocationNode> unsettledNodes = new HashSet<>();

        // Initialize all distances to infinity except the start node
        for (LocationNode node : Locations.map) {
            shortestDistances.put(node, Duration.ofDays(Long.MAX_VALUE));
            predecessors.put(node, null);
            unsettledNodes.add(node);
        }
        shortestDistances.put(start, Duration.ZERO);

        while (!unsettledNodes.isEmpty()) {
            LocationNode currentNode = getClosestNode(unsettledNodes, shortestDistances);
            unsettledNodes.remove(currentNode);
            relaxNeighbors(currentNode, shortestDistances, predecessors, unsettledNodes);
        }

        return buildPath(start, end, predecessors);
    }

    private static LocationNode getClosestNode(Set<LocationNode> unsettledNodes, Map<LocationNode, Duration> shortestDistances) {
        LocationNode closestNode = null;
        Duration shortestDistance = Duration.ofDays(Long.MAX_VALUE);
        for (LocationNode node : unsettledNodes) {
            Duration distance = shortestDistances.get(node);
            if (distance.compareTo(shortestDistance) < 0) {
                shortestDistance = distance;
                closestNode = node;
            }
        }
        return closestNode;
    }

    private static void relaxNeighbors(LocationNode node, Map<LocationNode, Duration> shortestDistances,
                                       Map<LocationNode, LocationNode> predecessors, Set<LocationNode> unsettledNodes) {
        for (Connection connection : node.connections) {
            LocationNode neighbor = connection.target;
            Duration distance = connection.distance;
            Duration newDistance = shortestDistances.get(node).plus(distance);
            if (newDistance.compareTo(shortestDistances.get(neighbor)) < 0) {
                shortestDistances.put(neighbor, newDistance);
                predecessors.put(neighbor, node);
                unsettledNodes.add(neighbor);
            }
        }
    }

    private static List<LocationNode> buildPath(LocationNode start, LocationNode end, Map<LocationNode, LocationNode> predecessors) {
        List<LocationNode> path = new ArrayList<>();
        LocationNode currentNode = end;
        while (currentNode != null && !currentNode.equals(start)) {
            path.add(0, currentNode);
            currentNode = predecessors.get(currentNode);
        }
        if (currentNode != null && currentNode.equals(start)) {
            path.add(0, start);
        }
        return path;
    }
}
