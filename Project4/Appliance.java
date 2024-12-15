import java.util.regex.Pattern;
/**
 * The Appliance class is an abstract class that represents an appliance with a serial number.
 * The class provides get and set methods for the serial number, way to determine the appliance type,
 * and a way to compare appliances based on serial number. If an invalid serial number is provided, 
 * it will be printed to the terminal for the user.
 */
public abstract class Appliance {
    private String serialNumber; // Private instance variable for the string serial number
    private double price;

    /**
     * Constructor which takes the string serial number as a parameter
     * 
     * @param serialNumber the serial number of the appliance
     * @throws IllegalApplianceException when the serial is deemed to be invalid through the isValid method
     */
    public Appliance (String serialNumber, double price) throws IllegalApplianceException {  
        if(!isValid(serialNumber)){
            throw new IllegalApplianceException("Invalid serial number: " + serialNumber);
        }
        this.serialNumber = serialNumber;
        this.price = price;
    }

    /**
     * This method uses a regex pattern and the Pattern.matches from java.util.regex.Pattern
     * to determine if the passed serial number is valid 
     * The regex pattern it must follow is that it must begin with an R, D, or M for appliance type
     * And the next 11 characters must be letters A-Z or number 0-9
     * @param serialNumber the serial number of the appliance we are checking
     * @return true if the serial number follows the regex pattern, false if it doesn't
     */
    public static boolean isValid (String serialNumber) {
        return Pattern.matches("^[RDM][A-Z0-9]{11}$", serialNumber);
    }

    /**
     * This method follows a regex pattern using input.matches
     * It checks whether or not if our current input follows the input pattern required to search
     * @return true if the input matches the regex pattern, false otherwise
     */
    public static boolean isValidInput(String input){
        return input.matches("[RDM],\\d+"); 
    }

    /**
     * Get method to return the serial number of the appliance 
     * @return the serial number of the appliance
     */
    public String getSerialNumber () {
        return serialNumber;
    }

    /**
     * Set method to designate the serial number value
     * @param serialNumber the new designated serial number of the appliance
     */
    public void setSerialNumber (String serialNumber) {  
        this.serialNumber = serialNumber;
    }
    /**
     * Get method to return the price of the current appliance
     * @return the price of current appliance
     */
    public double getPrice () {
        return price;
    }

    /**
     * Set method to designate the price of the current appliance 
     * @param price the set price of the appliance
     */
    public void setPrice (double price) {
        this.price = price;
    }

    /**
     * Get method to return the first character of the serial number to determine its appliance type
     * @return the first character of the serial number, the type of the appliance
     */
    public char getApplianceType () {  
        return serialNumber.charAt(0);  
    }

    /**
     * Returns the string version of the appliance, which is the appliance's serial number
     * @return the serial number of the appliance
     */
    public String toString() { 
        return serialNumber;
    }

    /**
     * Compares two appliances based on their serial numbers to assist in ordering them numerically
     * @param other the other appliance which we are comparing to
     * @return a negative integer if the appliance's serial number is less than the other appliance serial number,
     * a positive integer if the appliance's serial number is greater than the other appliance's serial number,
     * 0 if the two appliances' serial number being compared are equal 
     */
    public int compareTo (Appliance other) {  
        return this.serialNumber.compareTo(other.serialNumber);
    }

    /**
     * Determines whether two appliances are equal based on their serial number
     * @param other the other appliance we are comparing to
     * @return true if the appliance's serial number is equal to the other appliance's serial number
     * false if otherwise
     */
    public boolean equals (Appliance other) {
        return this.serialNumber.equals(other.serialNumber);
    }

}