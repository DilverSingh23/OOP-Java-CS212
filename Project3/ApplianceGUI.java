import javax.swing.*;
import java.awt.*;

/**
 * Class to display the sorted appliance data for each respective appliance within columns and 
 * provide the file, open, and quit buttons on display for use
 */
public class ApplianceGUI {
    /**
     * This is the Appliance GUI constructor that takes in three sorted appliance lists and displays them in 3 columns
     * The FileMenuHandler assists in providing the sorted appliances lists filled with the data to display
     * @param refrigerators The sorted appliance list containing refrigerators for display
     * @param microwaves The sorted appliance list containing microwaves for display
     * @param dishwashers The sorted appliance list containing dishwashers for display
     */
    public ApplianceGUI(SortedApplianceList refrigerators, SortedApplianceList microwaves, SortedApplianceList dishwashers){

        JFrame frame = new JFrame(); // Create our GUI
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Create GUI close operation
        frame.setTitle("Project 3 | Appliance List"); 

        // Creates the text areas for each individual appliance to store sorted appliance data
        JTextArea refrigeratorArea = new JTextArea();
        JTextArea microwaveArea = new JTextArea();
        JTextArea dishwasherArea = new JTextArea();

        // Creates a file menu handler and pass in our frame, sorted appliance lists and text areas so it can populate it with our file data
        FileMenuHandler fmh = new FileMenuHandler(frame, dishwashers, microwaves, refrigerators, refrigeratorArea, microwaveArea, dishwasherArea);
        
        // Creates a menu to withold the File option that will display the two JMenu items, Open and Quit
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");

        // The action listener for both items is obtained from our file menu handler, specfically the actionPerformed method
        JMenuItem item1 = new JMenuItem("Open"); 
        item1.addActionListener(fmh);
        fileMenu.add(item1);
        fileMenu.addSeparator(); 

        JMenuItem item2 = new JMenuItem("Quit"); 
        item2.addActionListener(fmh);
        fileMenu.add(item2);

        menuBar.add(fileMenu);
        frame.setJMenuBar(menuBar);

        // Creates a JPanel with 3 columns adding the indivdual appliance scroll panes to a respective column
        JPanel applianceDisplay = new JPanel(new GridLayout(1, 3));
        applianceDisplay.add(new JScrollPane(refrigeratorArea));
        applianceDisplay.add(new JScrollPane(dishwasherArea));
        applianceDisplay.add(new JScrollPane(microwaveArea));

        // Add the applianceDisplay to the frame, and make it visible
        frame.add(applianceDisplay, BorderLayout.CENTER);
        frame.setSize(900, 400);
        frame.setVisible(true);

    }
}
