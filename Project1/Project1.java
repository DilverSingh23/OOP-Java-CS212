// Name: Dilver Singh
// Lab Section: 121A
import javax.swing.*;
import java.awt.*;

public class Project1 {
    public static void main (String[] args) {
        // Create appliance arrays for each individual appliance for respective storing purposes //
        Appliance[] refridgerator = new Appliance[50]; 
        Appliance[] dishwasher = new Appliance[50];
        Appliance[] microwave = new Appliance[50];
        Appliance[] appliances = new Appliance [150]; // Appliance array that will withold all serial numbers to store file info

        // Count variables to assist the for loops test expression to develop these arrays and output them to the GUI
        int applianceCount = 0;    
        int refridgeratorCount = 0;
        int dishwasherCount = 0;
        int microwaveCount = 0;

        // Intialize a String variable named line to store the consequent lines of the file input that we created below
        String line;
        TextFileInput applianceFile = new TextFileInput("Project1.txt"); 

        line = applianceFile.readLine(); // Have the variable store the first line of the .txt file

        /* While loop that continues to store the appliances consequently in the appliances array while incrementing
        the appliance count and moving on to the next line until there are no more lines */
        while (line != null) {
            appliances[applianceCount++] = new Appliance(line);
            line = applianceFile.readLine();
        }

        applianceFile.close(); // Close the file after completion for resource management and avoiding file access issues

        /* For loop utiliizng getAppliance type to add the correct serial numbers to the 3 
        respective appliance arrays */
        for (int i = 0; i < applianceCount; i++) {
            if (appliances[i].getApplianceType() == 'R'){
                refridgerator[refridgeratorCount++] = appliances[i];
            }

            if (appliances[i].getApplianceType() == 'D') {
                dishwasher[dishwasherCount++] = appliances[i];
            }

            if (appliances[i].getApplianceType() == 'M') {
                microwave[microwaveCount++] = appliances[i];
            }
        }

        // Utilize selection sort function to numerically sort the serial numbers for the respective appliance arrays
        selectionSort(refridgerator, refridgeratorCount);
        selectionSort(dishwasher, dishwasherCount);
        selectionSort(microwave, microwaveCount);

        // Create JFrame for appliances GUI
        JFrame applianceGUI = new JFrame();

        applianceGUI.setTitle("Appliances");
        applianceGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // close operation to exit appliance GUI window

        applianceGUI.setLayout(new GridLayout(1, 3));  // create content pane within the GUI to set a 1 x 3 grid to display appliances 

        // Create the text areas for the serial numbers of the respective appliances to be displayed in
        JTextArea refridgerators = new JTextArea();
        JTextArea dishwashers = new JTextArea();
        JTextArea microwaves = new JTextArea();

        // Add scroll panes to the GUI for each individual appliance column to display all their serial numbers
        applianceGUI.add(new JScrollPane(refridgerators));
        applianceGUI.add(new JScrollPane(dishwashers));
        applianceGUI.add(new JScrollPane(microwaves));

        /* For loop for each appliance type to add all serial numbers to the respective appliance type, convert to a string, 
        and append to its scroll pane */ 
        for (int i = 0; i < refridgeratorCount; i++){
            refridgerators.append(refridgerator[i].toString() + "\n");
        }

        for (int i = 0; i < dishwasherCount; i++){
            dishwashers.append(dishwasher[i].toString() + "\n");
        }

        for (int i = 0; i < microwaveCount; i++){
            microwaves.append(microwave[i].toString() + "\n");
        }

        /* GUI customization, setting a width of 600 and height of 400, 
        setting the location to the center of the screen, and making the GUI visible */ 
        applianceGUI.setSize(600, 400);
        applianceGUI.setLocationRelativeTo(null);
        applianceGUI.setVisible(true);
    }

    // Selection sort algorithim to order the appliances numerically in the respective columns 
    private static void selectionSort (Appliance[] appliances, int applianceCount) {
        for (int i = 0; i < applianceCount - 1; i++ ) 
        {
            int indexLowest = i;
            for (int j = i + 1; j < applianceCount; j++ ) 
            {
                if (appliances[indexLowest].compareTo(appliances[j]) > 0) {
                    indexLowest = j;
                } 
            }
            Appliance temp = appliances[indexLowest]; // changing the index lowest to the old lowest value and changing i to the current lowest value
            appliances[indexLowest] = appliances[i];
            appliances[i] = temp;
        }
    }
}
