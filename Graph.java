import java.util.*;

// class to represent a graph consisting of nodes
public class Graph {

    // nodes making up the graph
    private Set<Node> graphNodes = new HashSet<>();

    // constructor
    public Graph() {}

    // method to add a node to the graph
    public void addNode(Node node) {
        graphNodes.add(node);
    }
}
