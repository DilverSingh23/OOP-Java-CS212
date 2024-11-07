public class Microwave extends Appliance {
    private double price;
    private double watts;

    public Microwave (String serialNumber, double price, double watts) {
        super(serialNumber);
        this.price = price;
        this.watts = watts;
    }

    public String toString() { 
        String info = getSerialNumber() + " - " + "Price: $" + price + " - " + watts + " W";
        return info;
    }

}
