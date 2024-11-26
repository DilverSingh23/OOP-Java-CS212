import javax.swing.*;
import java.awt.*;

public class ApplianceGUI {
    public ApplianceGUI(SortedApplianceList refrigerators, SortedApplianceList microwaves, SortedApplianceList dishwashers){

        JFrame frame = new JFrame(); // Create our GUI
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Create GUI close operation
        frame.setTitle("Project 3 | Appliance List"); 


        JTextArea refrigeratorArea = new JTextArea();
        JTextArea microwaveArea = new JTextArea();
        JTextArea dishwasherArea = new JTextArea();

        FileMenuHandler fmh = new FileMenuHandler(frame, dishwashers, microwaves, dishwashers, refrigeratorArea, microwaveArea, dishwasherArea);
        
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");

        JMenuItem item1 = new JMenuItem("Open"); 
        item1.addActionListener(fmh);
        fileMenu.add(item1);
        fileMenu.addSeparator(); 

        JMenuItem item2 = new JMenuItem("Quit"); 
        item2.addActionListener(fmh);
        fileMenu.add(item2);

        menuBar.add(fileMenu);
        frame.setJMenuBar(menuBar);

        JPanel applianceDisplay = new JPanel(new GridLayout(1, 3));
        applianceDisplay.add(new JScrollPane(refrigeratorArea));
        applianceDisplay.add(new JScrollPane(dishwasherArea));
        applianceDisplay.add(new JScrollPane(microwaveArea));

        frame.add(applianceDisplay, BorderLayout.CENTER);
        frame.setSize(900, 400);
        frame.setVisible(true);

    }
}
