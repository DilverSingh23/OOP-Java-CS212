import javax.swing.*;
import java.awt.*;
import java.util.TreeMap;

public class ApplianceGUI {
    private TreeMap<String, Refrigerator> refrigerators; 
    private TreeMap<String, Dishwasher> dishwashers; 
    private TreeMap<String, Microwave> microwaves; 
    private JTextArea fridgeArea;
    private JTextArea dishWasherArea;
    private JTextArea microwaveArea;
    private JTextArea resultsArea;

    /**
     * Constructor to create and initialize the ApplianceGUI
     * @param refrigerators  A treemap withholding Refrigerator objects with serial numbers as keys
     * @param dishwashers    A treemap withholding Dishwasher objects with serial numbers as keys
     * @param microwaves     A treemap withholding Microwave objects with serial numbers as keys
     */
    public ApplianceGUI(TreeMap<String, Refrigerator> refrigerators, TreeMap<String, Dishwasher> dishwashers,
                        TreeMap<String, Microwave> microwaves) {
        this.refrigerators = refrigerators;
        this.dishwashers = dishwashers;
        this.microwaves = microwaves;

        // Develop the main frame for the GUI
        JFrame frame = new JFrame("Project4 -- Appliances with TreeMap and Search");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Create the text areas for each individual appliance
        fridgeArea = new JTextArea();
        dishWasherArea = new JTextArea();
        microwaveArea = new JTextArea();

        // Creates the first panel which is split into 3 columns to display the sorted appliances 
        JPanel appliancePanel = new JPanel(new GridLayout(1, 3));
        appliancePanel.add(new JScrollPane(fridgeArea)); 
        appliancePanel.add(new JScrollPane(dishWasherArea)); 
        appliancePanel.add(new JScrollPane(microwaveArea)); 

        // Creates a menu bar
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");

        // Add a "Search" menu item to the menu bar. This menu item takes in user input and is 
        // used to filter which appliances to display in the terminal
        JMenuItem searchMenuItem = new JMenuItem("Search");
        searchMenuItem.addActionListener(e -> searchAppliances());
        fileMenu.add(searchMenuItem);

        // Add a "Quit" menu item to the menu bar that simply quits the program 
        JMenuItem quitMenuItem = new JMenuItem("Quit");
        quitMenuItem.addActionListener(e -> System.exit(0));
        fileMenu.add(quitMenuItem);
        menuBar.add(fileMenu);
        frame.setJMenuBar(menuBar);

        // Add both panels to the frame 
        frame.add(appliancePanel, BorderLayout.CENTER);

        frame.setSize(1600, 400);
        frame.setVisible(true);

        // Calls a method that populates all the appliance text areas with data 
        updateDisplay();
    }
    private void updateDisplay(){
        // Clear all text areas 
        fridgeArea.setText(""); 
        dishWasherArea.setText("");
        microwaveArea.setText("");

        // Use the entrySet and iterator methods that allow us to traverse through a TreeMap until we reach 
        // a null value. At each iteration append the value of the Appliance Object which is 
        // esstentially it's toString method to the proper text area 
        var fridgeIterator = refrigerators.entrySet().iterator();
        while(fridgeIterator.hasNext()){
            var entry = fridgeIterator.next();
            fridgeArea.append(entry.getValue() + "\n");
        }
        var dishwasherIterator = dishwashers.entrySet().iterator();
        while (dishwasherIterator.hasNext()) {
            var entry = dishwasherIterator.next();
            dishWasherArea.append(entry.getValue() + "\n");
        }
        var microwaveIterator = microwaves.entrySet().iterator();
        while (microwaveIterator.hasNext()) {
            var entry = microwaveIterator.next();
            microwaveArea.append(entry.getValue() + "\n");
        }
    }

    private void searchAppliances(){
        String input = JOptionPane.showInputDialog(null,"Enter search criteria (format: R/D/M,price):");
        if(input==null||!Appliance.isValidInput(input)){
            JOptionPane.showMessageDialog(null,"Invalid input.");
            return; 
        }
        // Parse the input and store the appliance type and price for search
        String[] parts = input.split(",");
        char type = parts[0].charAt(0); 
        int price = Integer.parseInt(parts[1]);


        // Use if else statements to first identify which appliance type the user inputted
        // Then we use the same exact iteration using iterator, entrySet, and hasNext like we did 
        // in updateDisplay but with an additional if statemnt which uses the getPrice() method 
        // from Appliance.java to check if the current appliance object fits the users entered critera
        // only if that if statement is true then will the object be output to the terminal
        if(type=='R'){
            var fridgeIterator = refrigerators.values().iterator();
            while (fridgeIterator.hasNext()) {
                var fridge = fridgeIterator.next();
                if (fridge.getPrice() <= price) {
                    System.out.println(fridge);
                }
            }
        }
        else if(type=='D'){
            var dishwasherIterator = dishwashers.values().iterator();
            while (dishwasherIterator.hasNext()) {
                var dishwasher = dishwasherIterator.next();
                if (dishwasher.getPrice() <= price) {
                    System.out.println(dishwasher);
                }
            }
        }
        else if(type=='M'){
            var microwaveIterator = microwaves.values().iterator();
            while (microwaveIterator.hasNext()) {
                var microwave = microwaveIterator.next();
                if (microwave.getPrice() <= price) {
                    System.out.println(microwave);
                }
            }
        }
    }
}

