/**
 * Refrigerator extends the Appliance.java class as it a specific type of appliance
 * The unique variable to the refrigerator class is its cubic feet
 */
public class Refrigerator extends Appliance {
    private double price;
    private double cubicFeet;

     /**
     * Constructor for a refrigerator object
     * @param serialNumber is the serial number of the refrigerator
     * @param price is the price of the refrigerator
     * @param cubicFeet is the cubic feet of the refrigerator 
     * All passed in parameters set the values for the private instance 
     * variables while retriving serialNumber from the parent class which is appliance
     */
    public Refrigerator (String serialNumber, double price, double cubicfeet) {
        super(serialNumber);
        this.price = price;
        this.cubicFeet = cubicFeet;
    }

     /** 
     * @return a string that concatenates all the components of the refrigerator class for our GUI
     * (serial number, price, cubic feet)
     */
    public String toString() { 
        String info = getSerialNumber() + " - " + "Price: $" + price + " - " + cubicFeet + " cubic feet.";
        return info;
    }

}
