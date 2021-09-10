// AUTHOR: Jessie Stalter
// STID: 0862
// DATE: December 3, 2020
// CLASS: CS315-001 Fall 2020
// PROJECT: Final Project
// ALGORITHM: Dijkstra's algorithm
// COMPLEXITY: O(|V||E|) running time
// BUGS: this program is limited solely to the graph I have provided, the paint method will not work for another graph
// REFERENCES: I used references from the Internet for ideas of how to implement Dijkstra's algorithm, but the code is my own
// NOTES: no additional comments

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// main class, creates the main panel
public class Main extends JFrame implements ActionListener {

    // set up panels
    private JPanel topPanel, bottomPanel;

    // set up button
    private JButton findDistance;

    // set up labels
    private JLabel startLabel, destinationLabel, distanceLabel;

    // set up JTextField
    private JTextField inputStart, inputDest;

    private MapFrame mapFrame; // set up map object

    // constructor
    public Main() {
        // MapFrame
        mapFrame = new MapFrame();

        // JPanels
        topPanel = new JPanel();
        bottomPanel = new JPanel();

        // JButton
        findDistance = new JButton("Find Travel Time");
        findDistance.addActionListener(this);

        // JLabels
        startLabel = new JLabel("Starting Location: ", SwingConstants.CENTER);
        destinationLabel = new JLabel("Enter Destination: ", SwingConstants.CENTER);
        distanceLabel = new JLabel("Time: ", SwingConstants.CENTER);

        // JTextField
        inputStart = new JTextField();
        inputDest = new JTextField();

        // add to panels
        topPanel.setLayout(new GridLayout(2,2));
        topPanel.add(startLabel);
        topPanel.add(inputStart);
        topPanel.add(destinationLabel);
        topPanel.add(inputDest);

        bottomPanel.add(findDistance);
        bottomPanel.add(distanceLabel);

        Container c = getContentPane();
        c.setLayout(new BorderLayout());

        c.add(topPanel, BorderLayout.NORTH);
        c.add(mapFrame, BorderLayout.CENTER);
        c.add(bottomPanel, BorderLayout.SOUTH);

        setSize(new Dimension(650, 650));
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // main function
    public static void main(String[] args) {
        Main M = new Main();

        M.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    // implement actionListeners
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(findDistance)) {
            mapFrame.initializeGraph(); // to reset the variables for each node

            // get values from text fields
            String start = inputStart.getText();
            String dest = inputDest.getText();

            if (start.equals("A") || start.equals("a"))
                mapFrame.startNode = mapFrame.nodeA;
            else if (start.equals("B") || start.equals("b"))
                mapFrame.startNode = mapFrame.nodeB;
            else if (start.equals("C") || start.equals("c"))
                mapFrame.startNode = mapFrame.nodeC;
            else if (start.equals("D") || start.equals("d"))
                mapFrame.startNode = mapFrame.nodeD;
            else if (start.equals("E") || start.equals("e"))
                mapFrame.startNode = mapFrame.nodeE;
            else { // if the inputted start location is not one of the above options
                JFrame startFrame = new JFrame();
                JTextArea startText = new JTextArea();
                startText.setText("\n                       Input a Correct Start Location (A-E)!");
                startText.setEditable(false);
                startFrame.add(startText);
                startFrame.setLocationRelativeTo(null);
                startFrame.setSize(new Dimension(200,80));
                startFrame.setVisible(true);
            }

            if (dest.equals("A") || dest.equals("a"))
                mapFrame.destinationNode = mapFrame.nodeA;
            else if (dest.equals("B") || dest.equals("b"))
                mapFrame.destinationNode = mapFrame.nodeB;
            else if (dest.equals("C") || dest.equals("c"))
                mapFrame.destinationNode = mapFrame.nodeC;
            else if (dest.equals("D") || dest.equals("d"))
                mapFrame.destinationNode = mapFrame.nodeD;
            else if (dest.equals("E") || dest.equals("e"))
                mapFrame.destinationNode = mapFrame.nodeE;
            else { // if the inputted destination is not one of the above options
                JFrame destFrame = new JFrame();
                JTextArea destText = new JTextArea();
                destText.setText("\n                           Input a Correct Destination (A-E)!");
                destText.setEditable(false);
                destFrame.add(destText);
                destFrame.setLocationRelativeTo(null);
                destFrame.setSize(new Dimension(200,80));
                destFrame.setVisible(true);
            }

            // invoke method to find the distance
            int distance = mapFrame.performDijkstras();

            distanceLabel.setText("Time: " + distance);

            mapFrame.repaint();
        }
    }
}
