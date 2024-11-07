public abstract class Appliance {
    private String serialNumber; // Private instance variable for the string serial number

    public Appliance (String serialNumber) {  // Constructor that takes the serial number string as a parameter
        this.serialNumber = serialNumber;
    }

    public String getSerialNumber () {  // Get method to return serial number
        return serialNumber;
    }

    public void setSerialNumber (String serialNumber) {  // Set method to designate the serial number value
        this.serialNumber = serialNumber;
    }

    public char getApplianceType () {   // Get method to return the first character of the serial number (the appliance type)
        return serialNumber.charAt(0);  
    }

    public String toString() { 
        return serialNumber;
    }

    public int compareTo (Appliance other) {  // Compare two serial numbers to help order them numerically later on
        return this.serialNumber.compareTo(other.serialNumber);
    }

    public boolean equals (Appliance other) {
        return this.serialNumber.equals(other.serialNumber); // boolean to check if two serial numbers are equal, passing the compared serial number as a parameter
    }
}
