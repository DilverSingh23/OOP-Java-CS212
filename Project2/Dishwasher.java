public class Dishwasher extends Appliance {
    private double price;
    private boolean installation;

    public Dishwasher (String serialNumber, double price, boolean installation) {
        super(serialNumber);
        this.price = price;
        this.installation = installation;
    }

    public String toString() { 
        String info = serialNumber + " - " + "Price: $" + price + " - ";
        if (installation) {
            info += " Undercounter Installation";
        }
        else {
            info += " No Undercounter Installation";
        }
        return info;
    }
}
