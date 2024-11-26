import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class FileMenuHandler implements ActionListener {
    private JFrame frame;
    private SortedApplianceList dishwashers;
    private SortedApplianceList microwaves;
    private SortedApplianceList refrigerators;
    private JTextArea dishwasherArea;
    private JTextArea microwaveArea;
    private JTextArea refrigeratorArea;

    public FileMenuHandler (JFrame f, SortedApplianceList d, SortedApplianceList m, SortedApplianceList r, JTextArea dArea, JTextArea mArea, JTextArea rArea) {
        this.frame = f;
        this.dishwashers = d;
        this.microwaves = m;
        this.refrigerators = r;
        this.dishwasherArea = dArea;
        this.microwaveArea = mArea;
        this.refrigeratorArea = rArea;
    }

    public void actionPerformed (ActionEvent event) {
        String action = event.getActionCommand();
        if (action.equals("Open")) {
            openFile();
        }
        else {
            System.exit(0);
        }
    }

    private void openFile () {
        JFileChooser chooser = new JFileChooser();
        int status = chooser.showOpenDialog(null);
        if (status == JFileChooser.APPROVE_OPTION) {
            readSource(chooser.getSelectedFile());
        }
    }

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
        JTextArea fridgeArea = new JTextArea();
        ApplianceNode currentRefrigerator = refrigerators.first.next;
        while (currentRefrigerator != null){
            fridgeArea.append(currentRefrigerator.data.toString() + "\n");
            currentRefrigerator = currentRefrigerator.next;
        }
        frame.add(new JScrollPane(fridgeArea));

        // Dishwasher section will be the second column 
        // The logic for this section will follow the refirgerator
        JTextArea dishWasherArea = new JTextArea();
        ApplianceNode currentDishwasher = dishwashers.first.next; 
        while (currentDishwasher != null){
            dishWasherArea.append(currentDishwasher.data.toString() + "\n");
            currentDishwasher = currentDishwasher.next; 
        }
        frame.add(new JScrollPane(dishWasherArea));

        // Microwave section will be the last column 
        // Logic for this section follows the refrigerator and microwave code
        JTextArea microwaveArea = new JTextArea();
        ApplianceNode currentMicrowave = microwaves.first.next;
        while (currentMicrowave != null){
            microwaveArea.append(currentMicrowave.data.toString() + "\n");
            currentMicrowave = currentMicrowave.next;
        }
        frame.add(new JScrollPane(microwaveArea));
    }

}
