public class Project3 {
    public static void main(String[] args) {
        SortedApplianceList refrigerators = new SortedApplianceList();
        SortedApplianceList microwaves = new SortedApplianceList();
        SortedApplianceList dishwashers = new SortedApplianceList();

        new ApplianceGUI(refrigerators, microwaves, dishwashers);
    }

}
