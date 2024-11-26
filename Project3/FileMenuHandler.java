import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
/*
 * Class utilizing ActionListener to make buttons in the GUI usable and populating text areas with appliances
 */
public class FileMenuHandler implements ActionListener {
    private JFrame frame;
    private SortedApplianceList dishwashers;
    private SortedApplianceList microwaves;
    private SortedApplianceList refrigerators;
    private JTextArea dishwasherArea;
    private JTextArea microwaveArea;
    private JTextArea refrigeratorArea;

    /**
     * FileMenuHandler class constructor taking the frame, sorted appliance lists, and text areas as parameters.
     * 
     * @param f The GUI frame that will withold the buttons and sorted appliance lists in columns
     * @param d The sorted appliance list containing dishwashers
     * @param m The sorted appliance list containing microwaves
     * @param r The sorted appliance list containing refrigerators
     * @param dArea The textArea that will be displayed within the GUI containing the dishwasher sorted appliance list
     * @param mArea The textArea that will be displayed within the GUI containing the microwave sorted appliance list
     * @param rArea The textArea that will be displayed within the GUI containing the refrigerator sorted appliance list
     */
    public FileMenuHandler (JFrame f, SortedApplianceList d, SortedApplianceList m, SortedApplianceList r, JTextArea dArea, JTextArea mArea, JTextArea rArea) {
        this.frame = f;
        this.dishwashers = d;
        this.microwaves = m;
        this.refrigerators = r;
        this.dishwasherArea = dArea;
        this.microwaveArea = mArea;
        this.refrigeratorArea = rArea;
    }

    /**
     * Action preformed method to give the File, Open, Quit buttons functionality onclick
     * @param event Stores the action that occured when a menu item is selected
     */
    public void actionPerformed (ActionEvent event) {
        String action = event.getActionCommand();
        if (action.equals("Open")) {
            openFile(); // User is prompted to enter a file of their choice
        }
        else {
            System.exit(0); // The else refers to quit being pressed in which it will end the program
        }
    }
    /*
     * This method makes the user a choose a file and once the user selects one we move on to the reading file method
     */
    private void openFile () {
        JFileChooser chooser = new JFileChooser();
        int status = chooser.showOpenDialog(null);
        if (status == JFileChooser.APPROVE_OPTION) {
            readSource(chooser.getSelectedFile());
        }
    }

    /**
     * This method reads the file that the user entered, reading line by line till it reaches null
     * If the file entered is not a correct .txt file it will throw the illegal appliance exception
     * We use the isValid method to check if the current line we are reading has a valid serial number
     * If it doesn't have a valid serial number an exception is thrown
     * If it is valid it gets added to the sorted appliance list based on appliance type
     * @param selectedFile Stores the file that the user chose in the open file method
     */
    private void readSource (File selectedFile) {
        String selectedFileName = selectedFile.getName();
        String selectedFilePath = selectedFile.getAbsolutePath();
        TextFileInput inFile = new TextFileInput(selectedFilePath);
        refrigerators = new SortedApplianceList();
        microwaves = new SortedApplianceList();
        dishwashers = new SortedApplianceList();

        try {
            String line;
            while ((line = inFile.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length < 3) {
                    continue;
                }
                String serial = parts[0];
                char applianceType = parts[0].charAt(0);
                double price = Double.parseDouble(parts[1]);

                if (Appliance.isValid(serial)) {
                    try {
                        if (applianceType == 'R') {
                            double cubic_feet = Double.parseDouble(parts[2]);
                            refrigerators.add(new Refrigerator(serial, price, cubic_feet));
                        }

                        else if (applianceType == 'M') {
                            double watts = Double.parseDouble(parts[2]);
                            microwaves.add(new Microwave(serial, price, watts));
                        }

                        else if (applianceType == 'D') {
                            boolean installation = Boolean.parseBoolean(parts[2]);
                            dishwashers.add(new Dishwasher(serial, price, installation));
                        }
                    }
                    catch (Exception e) {
                        System.out.println("Error adding appliance: " + e.getMessage());
                    }
                }
                else {
                    System.out.println("Unable to add appliance: " + serial);
                }
            }
            inFile.close();
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(frame, "Reading file error: " + e.getMessage());
        }
        
        displayAppliances();
    }

    /**
     * The displayAppliances method begins by clearing each appliance text area and then iterates through the
     * linked list to add each portion of data from the sorted appliance lists to their respective text areas
     */
    private void displayAppliances () {
        refrigeratorArea.setText("");
        microwaveArea.setText("");
        dishwasherArea.setText("");

        // Refrigerators section will be the first column
        // A node is created to iterate through the sorted linked list
        // The iteration starts at .first.next because .first is always our dummy node, so by starting
        // at the one right after we get the first sorted element 
        // We iterate through nodes using .next until our node reaches a null node meaning we've reached the end of the linked list
        // The text shown on the GUI is the toString created for each node in Refrigerator.java 
        // The sorted linked lists are populated with data of type appliance
        ApplianceNode currentRefrigerator = refrigerators.first.next;
        while (currentRefrigerator != null){
            refrigeratorArea.append(currentRefrigerator.data.toString() + "\n");
            currentRefrigerator = currentRefrigerator.next;
        }

        // Dishwasher section will be the second column 
        // The logic for this section will follow the refirgerator
        ApplianceNode currentDishwasher = dishwashers.first.next; 
        while (currentDishwasher != null){
            dishwasherArea.append(currentDishwasher.data.toString() + "\n");
            currentDishwasher = currentDishwasher.next; 
        }

        // Microwave section will be the last column 
        // Logic for this section follows the refrigerator and microwave code
        ApplianceNode currentMicrowave = microwaves.first.next;
        while (currentMicrowave != null){
            microwaveArea.append(currentMicrowave.data.toString() + "\n");
            currentMicrowave = currentMicrowave.next;
        }
    }

}
