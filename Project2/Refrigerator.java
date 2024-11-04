public class Refrigerator extends Appliance {
    private double price;
    private double cubicFeet;

    public Refrigerator (String serialNumber, double price, double cubicfeet) {
        super(serialNumber);
        this.price = price;
        this.cubicFeet = cubicFeet;
    }

    public String toString() { 
        String info = serialNumber + " - " + "Price: $" + price + " - " + cubicFeet + " cubic feet.";
        return info;
    }

    


}
