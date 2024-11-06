public class Project2 {
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
        TextFileInput applianceFile = new TextFileInput("Project2.txt"); 

        line = applianceFile.readLine(); // Have the variable store the first line of the .txt file

        /* While loop that continues to store the appliances consequently in the appliances array while incrementing
        the appliance count and moving on to the next line until there are no more lines */
        while (line != null) {
            appliances[applianceCount++] = new Appliance(line);
            line = applianceFile.readLine();
        }

        applianceFile.close();
    }
}
