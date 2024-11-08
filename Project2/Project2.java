// Name: Dilver Singh
// Lab Section: 121A
public class Project2 {
    public static void main(String[] args) {
        // Create a sorted linked list for each appliance type, this way when items are added it will automatically be put in the correct position
        // Used TextFileInput.java to read in p2input.txt and store the parsed values into these 
        // These sorted linked lists will be used in our GUI
        SortedApplianceList refrigerators = new SortedApplianceList();
        SortedApplianceList dishwashers = new SortedApplianceList();
        SortedApplianceList microwaves = new SortedApplianceList();

        // We read in the text from p2input.txt until we reach a line that is null
        // For each line that is read, .split is used to seperate the 3 sections -- this can be done but I opted for .split()
        // .split() generates a string array where index 0 holds the serial number, index 1 holds price, index 2 holds a unique element to each appliance type
        // Double.parseDouble is used to convert strings to the proper data type for parameters
        // We are identifying what kind of appliance it is by checking the first char in the serial number string
        // Once the appliance type is identified, the .add method from the SortedApplianceList class is used to add a node to the before created SortedApplianceLists 
        TextFileInput fileInput = new TextFileInput("p2input.txt");
        String line;
        while ((line = fileInput.readLine()) != null) {
            String[] parts = line.split(",");
            String serial = parts[0];
            char applianceType = parts[0].charAt(0);
            double price = Double.parseDouble(parts[1]);

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
        // Once the while loop ends and we reach a null value in the .txt file we end reading in
        fileInput.close();
        
        // Pass our sorted appliance lists into the appliance GUI to create the GUI
        new ApplianceGUI(refrigerators, microwaves, dishwashers);
    }
}