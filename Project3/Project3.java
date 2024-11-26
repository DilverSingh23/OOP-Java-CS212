/*
 * Class that allows us to run the program through the compilation of the rest of the files
 * We create the three sorted appliance lists for the respective appliances and
 * create a GUI that passes in these 3 sorted appliance lists for display
 */
public class Project3 {
    public static void main(String[] args) {
        SortedApplianceList refrigerators = new SortedApplianceList();
        SortedApplianceList microwaves = new SortedApplianceList();
        SortedApplianceList dishwashers = new SortedApplianceList();

        new ApplianceGUI(refrigerators, microwaves, dishwashers);
    }

}
