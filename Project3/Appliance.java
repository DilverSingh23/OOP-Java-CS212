import java.util.regex.Pattern;
/**
 * The Appliance class is an abstract class that represents an appliance with a serial number.
 * The class provides get and set methods for the serial number, way to determine the appliance type,
 * and a way to compare appliances based on serial number.
 */
public abstract class Appliance {
    private String serialNumber; // Private instance variable for the string serial number

    /**
     * Constructor which takes the string serial number as a parameter
     * 
     * @param serialNumber the serial number of the appliance
     */
    public Appliance (String serialNumber) throws IllegalApplianceException {  
        if(!isValid(serialNumber)){
            throw new IllegalApplianceException("Invalid serial number: " + serialNumber);
        }
        this.serialNumber = serialNumber;
    }

    public static boolean isValid (String serialNumber) {
        return Pattern.matches("^[RDM][A-Z0-9]{11}$", serialNumber);
    }

    /**
     * Get method to return the serial number of the appliance 
     * @return the serial number of the appliance
     */
    public String getSerialNumber () {
        return serialNumber;
    }

    /**
     * Set method to designinate the serial number value
     * @param serialNumber the new designated serial number of the appliance
     */
    public void setSerialNumber (String serialNumber) {  
        this.serialNumber = serialNumber;
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
