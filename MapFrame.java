import javax.swing.*;
import java.awt.*;

// class for the map to be shown on the main panel
public class MapFrame extends JPanel {

    public Node startNode, destinationNode;

    // initialize graph elements
    public Graph graph;
    public Node nodeA, nodeB, nodeC, nodeD, nodeE;
    public Node node1, node2, node3, node4, node5, node6;

    private DijkstraTools dt;

    // constructor
    public MapFrame() {
        startNode = null;
        destinationNode = null;

        initializeGraph();

        dt = new DijkstraTools();
    }

    public int performDijkstras() {
        int distance = 0;
        if (startNode != null && destinationNode != null) {

            dt.calculateShortestPath(startNode);

            distance = destinationNode.getDistance();
        }
        return distance;
    }

    // function that sets up the corresponding graph to the image displayed
    public void initializeGraph() {
        graph = new Graph();

        nodeA = new Node("A");
        nodeB = new Node("B");
        nodeC = new Node("C");
        nodeD = new Node("D");
        nodeE = new Node("E");

        node1 = new Node("1");
        node2 = new Node("2");
        node3 = new Node("3");
        node4 = new Node("4");
        node5 = new Node("5");
        node6 = new Node("6");

        nodeA.addDestination(node1, 9);
        node1.addDestination(nodeA, 9);
        nodeA.addDestination(node2, 5);
        node2.addDestination(nodeA, 5);
        node1.addDestination(nodeB, 11);
        nodeB.addDestination(node1, 11);
        node1.addDestination(nodeC, 5);
        nodeC.addDestination(node1, 5);
        node2.addDestination(nodeC, 12);
        nodeC.addDestination(node2, 12);
        nodeC.addDestination(node3, 15);
        node3.addDestination(nodeC, 15);
        node2.addDestination(nodeD, 7);
        nodeD.addDestination(node2, 7);
        nodeD.addDestination(node5, 3);
        node5.addDestination(nodeD, 3);
        nodeB.addDestination(node3, 4);
        node3.addDestination(nodeB, 4);
        nodeC.addDestination(node4, 5);
        node4.addDestination(nodeC, 5);
        nodeD.addDestination(node4, 9);
        node4.addDestination(nodeD, 9);
        node3.addDestination(nodeE, 15);
        nodeE.addDestination(node3, 15);
        node5.addDestination(node6, 10);
        node6.addDestination(node5, 10);
        node4.addDestination(node6, 4);
        node6.addDestination(node4, 4);
        node6.addDestination(nodeE, 10);
        nodeE.addDestination(node6, 10);

        /*
        nodeA.addDestination(nodeB, 13);
        nodeA.addDestination(nodeD,10);
        nodeA.addDestination(nodeC,8);
        nodeB.addDestination(nodeA,13);
        nodeB.addDestination(nodeC,12);
        nodeB.addDestination(nodeE,20);
        nodeC.addDestination(nodeA,8);
        nodeC.addDestination(nodeB,12);
        nodeC.addDestination(nodeE,18);
        nodeC.addDestination(nodeD,5);
        nodeD.addDestination(nodeA,10);
        nodeD.addDestination(nodeC,5);
        nodeD.addDestination(nodeE,25);
        nodeE.addDestination(nodeD,25);
        nodeE.addDestination(nodeC,18);
        nodeE.addDestination(nodeB,20);

         */

        graph.addNode(nodeA);
        graph.addNode(nodeB);
        graph.addNode(nodeC);
        graph.addNode(nodeD);
        graph.addNode(nodeE);
    }

    // paint method
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // color lines based on chosen start & end nodes
        g.setColor(Color.BLUE);
        Graphics2D g2 = (Graphics2D)g;
        g2.setStroke(new BasicStroke(3));
        if (startNode != null && destinationNode != null) {
            if (startNode.getName().equals("A") && destinationNode.getName().equals("D") || startNode.getName().equals("D") && destinationNode.getName().equals("A")) {
                g.drawLine(100,105,100,253); // A to 2
                g.drawLine(100,253,100,375); // 2 to D
            }
            if (startNode.getName().equals("A") && destinationNode.getName().equals("B") || startNode.getName().equals("B") && destinationNode.getName().equals("A")) {
                g.drawLine(125,80,250,80); // A to 1
                g.drawLine(250,80,450,80); // 1 to B
            }
            if (startNode.getName().equals("A") && destinationNode.getName().equals("C") || startNode.getName().equals("C") && destinationNode.getName().equals("A")) {
                g.drawLine(125,80,250,80); // A to 1
                g.drawLine(250,80,250,225); // 1 to C
            }
            if (startNode.getName().equals("A") && destinationNode.getName().equals("E") || startNode.getName().equals("E") && destinationNode.getName().equals("A")) {
                g.drawLine(125,80,250,80); // A to 1
                g.drawLine(250,80,250,225); // 1 to C
                g.drawLine(250,280,250,403); // C to 4
                g.drawLine(250,403,250,453); // 4 to 6
                g.drawLine(250,453,450,453); // 6 to E
            }
            if (startNode.getName().equals("B") && destinationNode.getName().equals("C") || startNode.getName().equals("C") && destinationNode.getName().equals("B")) {
                g.drawLine(250,80,250,225); // 1 to C
                g.drawLine(250,80,450,80); // 1 to B
            }
            if (startNode.getName().equals("B") && destinationNode.getName().equals("D") || startNode.getName().equals("D") && destinationNode.getName().equals("B")) {
                g.drawLine(250,80,250,225); // 1 to C
                g.drawLine(250,80,450,80); // 1 to B
                g.drawLine(250,280,250,403); // C to 4
                g.drawLine(125,403,250,403); // D to 4
            }
            if (startNode.getName().equals("B") && destinationNode.getName().equals("E") || startNode.getName().equals("E") && destinationNode.getName().equals("B")) {
                g.drawLine(475,105,475,253); // B to 3
                g.drawLine(475,253,475, 425); // 3 to E
            }
            if (startNode.getName().equals("C") && destinationNode.getName().equals("D") || startNode.getName().equals("D") && destinationNode.getName().equals("C")) {
                g.drawLine(250,280,250,403); // C to 4
                g.drawLine(125,403,250,403); // D to 4
            }
            if (startNode.getName().equals("C") && destinationNode.getName().equals("E") || startNode.getName().equals("E") && destinationNode.getName().equals("C")) {
                g.drawLine(250,280,250,403); // C to 4
                g.drawLine(250,403,250,453); // 4 to 6
                g.drawLine(250,453,450,453); // 6 to E
            }
            if (startNode.getName().equals("D") && destinationNode.getName().equals("E") || startNode.getName().equals("E") && destinationNode.getName().equals("D")) {
                g.drawLine(100,430,100,453); // D to 5
                g.drawLine(100,453,250,453); // 5 to 6
                g.drawLine(250,453,450,453); // 6 to E
            }
        }

        g.setColor(Color.BLACK);
        g2.setStroke(new BasicStroke(1));
        g.drawRect(10,10, this.getWidth() - 20, this.getHeight() - 20); // draw outline

        // draw rectangles & labels
        g.drawRect(75, 50, 50,55);
        g.drawString("A", 95, 80);
        g.drawRect(450, 50, 50, 55);
        g.drawString("B", 470, 80);
        g.drawRect(225, 225, 50, 55);
        g.drawString("C", 245,255);
        g.drawRect(75, 375, 50, 55);
        g.drawString("D", 95, 405);
        g.drawRect(450, 425, 50 , 55);
        g.drawString("E", 470, 455);

        // draw number labels
        g.drawString("9", 180, 77);
        g.drawString("11", 355,77);
        g.drawString("5",90,175);
        g.drawString("5",240,175);
        g.drawString("4",480,175);
        g.drawString("7",90,315);
        g.drawString("5",240,340);
        g.drawString("15",480,345);
        g.drawString("12",165,250);
        g.drawString("9",180,400);
        g.drawString("10",180,465);
        g.drawString("15",355,250);
        g.drawString("10",355,465);
        g.drawString("3",90,445);
        g.drawString("4",240,435);

        // draw lines between nodes
        g.drawLine(100,105,100,253); // A to 2
        g.drawLine(100,253,100,375); // 2 to D
        g.drawLine(100,430,100,453); // D to 5
        g.drawLine(100,453,250,453); // 5 to 6
        g.drawLine(250,453,450,453); // 6 to E
        g.drawLine(125,80,250,80); // A to 1
        g.drawLine(250,80,250,225); // 1 to C
        g.drawLine(250,80,450,80); // 1 to B
        g.drawLine(475,105,475,253); // B to 3
        g.drawLine(475,253,475, 425); // 3 to E
        g.drawLine(100,253,225,253); // 2 to C
        g.drawLine(125,403,250,403); // D to 4
        g.drawLine(250,280,250,403); // C to 4
        g.drawLine(275,253,475,253); // C to 3
        g.drawLine(250,403,250,453); // 4 to 6

        // extra lines
        g.drawLine(100,50,100, 10);
        g.drawLine(10,80,75,80);
        g.drawLine(500,80,getWidth() - 10,80);
        g.drawLine(475,50,475,10);
        g.drawLine(475,480,475,getHeight() - 10);
        g.drawLine(100,253,10,253);
        g.drawLine(475,253,getWidth() - 10,253);
        g.drawLine(250,80,250,10);
        g.drawLine(250,453,250,getHeight() - 10);
        g.drawLine(75,403,10,403);
        g.drawLine(100,453,100,getHeight() - 10);
        g.drawLine(100,453,10,453);
        g.drawLine(500,453,getWidth() - 10,453);
    }
}
