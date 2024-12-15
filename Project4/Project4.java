// Name: Dilver Singh
// Lab Section: 121A
import java.util.TreeMap;
public class Project4 {
    public static void main(String[] args) {
        /*
         * This program takes its file input through args[0], and then stored within the filePath
         */
        String filePath = args[0];
        /*
         * Each treemap defined holds the serial number and the appliance for each respective treemap per appliance type
         */
        TreeMap<String, Refrigerator> refrigerators = new TreeMap<>(new ApplianceComparator());
        TreeMap<String, Dishwasher> dishwashers = new TreeMap<>(new ApplianceComparator());
        TreeMap<String, Microwave> microwaves = new TreeMap<>(new ApplianceComparator());
        /*
         * We read in the text from p2input.txt until we reach a line that is null
         * For each line that is read, .split is used to seperate the 3 sections -- this can be done but I opted for .split()
         * .split() generates a string array where index 0 holds the serial number, index 1 holds price, index 2 holds a unique element to each appliance type
         * Double.parseDouble is used to convert strings to the proper data type for parameters
         * We are identifying what kind of appliance it is by checking the first char in the serial number string
         * We are using the method .put() to add data to the TreeMaps
         */
        try{
            TextFileInput fileInput = new TextFileInput(filePath);
            String line;
            while ((line = fileInput.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length < 3) continue;

                String serial = parts[0];
                double price = Double.parseDouble(parts[1]);
                if (Appliance.isValid(serial)) {
                    if (serial.charAt(0) == 'R') {
                        int cubicFeet = Integer.parseInt(parts[2]);
                        refrigerators.put(serial, new Refrigerator(serial, price, cubicFeet));
                    } else if (serial.charAt(0) == 'M') {
                        int watts = Integer.parseInt(parts[2]);
                        microwaves.put(serial, new Microwave(serial, price, watts));
                    } else if (serial.charAt(0) == 'D') {
                        boolean undercounterInstallation = parts[2].equalsIgnoreCase("Y");
                        dishwashers.put(serial, new Dishwasher(serial, price, undercounterInstallation));
                    }
                }
            }
            fileInput.close();
        }
        catch(Exception e){
            System.out.println("Error processing file: " + e.getMessage());
        }
        /*
         * Passing all 3 of the TreeMaps that have data to the GUI 
         */
        new ApplianceGUI(refrigerators, dishwashers, microwaves);
    }
}
