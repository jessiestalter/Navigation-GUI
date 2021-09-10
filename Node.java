import java.util.*;

// class to represent each individual node of the graph
public class Node {

    private String name;

    private List<Node> shortestPath;

    private Integer distance;

    private Map<Node, Integer> adjacentNodes;

    // constructor
    public Node(String name) {
        this.name = name;

        shortestPath = new LinkedList<>();

        distance = Integer.MAX_VALUE; // sets the initial distance to be the maximum value

        adjacentNodes = new HashMap<>();
    }
    public String getName() {
        return name;
    }

    public void addDestination(Node destination, int distance) {
        adjacentNodes.put(destination, distance);
    }

    public void setShortestPath(List<Node> shortestPath) {
        this.shortestPath = shortestPath;
    }

    public List<Node> getShortestPath() {
        return shortestPath;
    }

    public void setDistance(Integer givenDistance) {
        distance = givenDistance;
    }

    public Integer getDistance() {
        return distance;
    }

    public Map<Node, Integer> getAdjacentNodes() {
        return adjacentNodes;
    }
}
