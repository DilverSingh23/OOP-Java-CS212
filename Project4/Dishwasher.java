/**
 * Dishwasher extends the Appliance.java class as it a specific type of appliance
 * The unique variable to the dishwasher class is whether it needs undercounter installation or not
 */
public class Dishwasher extends Appliance {
    private boolean installation;

    /**
     * Constructor for a dishwasher object
     * @param serialNumber is the serial number of the dishwasher 
     * @param price is the price of the dishwasher 
     * @param installation if Y then it needs undercounter installion and it doesn't if its n
     * All passed in parameters set the values for the private instance 
     * variables while retriving serialNumber from the parent class which is appliance
     */
    public Dishwasher (String serialNumber, double price, boolean installation) {
        super(serialNumber, price);
        this.installation = installation;
    }

    /**
     * Returns a string, this toString comes very useful in our GUI. The string concatenates
     * all parts of the object (serial number, price, under counter installation)
     */
    public String toString() { 
        String info = getSerialNumber() + " - " + "Price: $" + getPrice() + " - ";
        if (installation) {
            info += " Undercounter Installation";
        }
        else {
            info += " No Undercounter Installation";
        }
        return info;
    }
}
