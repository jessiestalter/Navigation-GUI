import java.util.*;

// class to hold the methods used to perform Dijkstra's algorithm
public class DijkstraTools {

    public DijkstraTools() {}

    // function to calculate the shortest path using a source node using Dijkstra's Algorithm
    public void calculateShortestPath(Node source) {
        source.setDistance(0); // set distance of source node to be 0

        // create HashSets for settled & unsettled nodes
        Set<Node> settledNodes = new HashSet<>();
        Set<Node> unsettledNodes = new HashSet<>();

        unsettledNodes.add(source); // add source node to unsettled nodes

        while (unsettledNodes.size() != 0) {
            // find node with smallest distance & remove it from the unsettled nodes
            Node currNode = getNodeWithSmallestDist(unsettledNodes);
            unsettledNodes.remove(currNode);

            // iterate over adjacent nodes of the node w the smallest distance
            for (Map.Entry<Node,Integer> adjPair : currNode.getAdjacentNodes().entrySet()) {
                Node adjacentNode = adjPair.getKey();
                Integer edgeWeight = adjPair.getValue();
                if (!settledNodes.contains(adjacentNode)) {
                    calculateMinimumDistance(adjacentNode, edgeWeight, currNode);
                    unsettledNodes.add(adjacentNode);
                }
            }
            settledNodes.add(currNode); // add current node to the settled nodes
        }
    }

    // function to find & return the node with the smallest distance
    public Node getNodeWithSmallestDist(Set <Node> unsettledNodes) {
        Node smallestDistanceNode = null;
        int smallestDistance = Integer.MAX_VALUE;
        for (Node node: unsettledNodes) {
            int currDistance = node.getDistance();
            if (currDistance < smallestDistance) {
                smallestDistance = currDistance;
                smallestDistanceNode = node;
            }
        }
        return smallestDistanceNode;
    }

    // function to calculate the minimum distance & update shortestPath
    public void calculateMinimumDistance(Node evalNode, Integer edgeWeight, Node srcNode) {
        Integer srcDistance = srcNode.getDistance();
        if (srcDistance + edgeWeight < evalNode.getDistance()) {
            evalNode.setDistance(srcDistance + edgeWeight);
            LinkedList<Node> shortestPath = new LinkedList<>(srcNode.getShortestPath());
            shortestPath.add(srcNode);
            evalNode.setShortestPath(shortestPath);
        }
    }
}
