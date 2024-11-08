import javax.swing.*;
import java.awt.*;

public class ApplianceGUI {
    public ApplianceGUI(SortedApplianceList refrigerators, SortedApplianceList dishwashers, SortedApplianceList microwaves){
        JFrame frame = new JFrame(); // Create our GUI
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Create GUI close operation
        frame.setLayout(new GridLayout(1, 3));  // Creates 3 sections for refrigerators, dishwashers, microwave
        frame.setTitle("Project 2 | Appliance List"); 

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

        // Make the GUI visbible and set it's size
        frame.setSize(900, 400);
        frame.setVisible(true);
    }
    
}

