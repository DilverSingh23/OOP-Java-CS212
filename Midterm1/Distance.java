public class Distance {
    private static int INCHES_IN_A_FOOT = 12;
    private static float FEET_IN_A_METER = 0.3048f;
    private int inches;
    private int feet; 

    public Distance () {
        this.feet = 0;
        this.inches = 0;
    }

    public Distance (int f, int i) {
        if (inches > 11) {
            throw new IllegalArgumentException("Inches cannot be greater than 11.");
        }
        feet = f;
        inches = i;
    }

    public int getFeet () {
        return feet;
    }

    public void setFeet (int f) {
        this.feet = f;
    }

    public int getInches () {
        return inches;
    }

    public void setInches (int i) {
        if (inches > 11) {
            throw new IllegalArgumentException("Inches cannot be greater than 11.");
        }
        this.inches = i;
    }

    public void add (Distance other) {
        feet += other.feet;
        if (inches + other.inches > 12) {
            feet += (inches + other.inches) / 12;
            inches += (inches + other.inches) % 12;
        }
        else {
            inches += other.inches;
        }
    }

    public float metricDistance () {
        float md;
        md = (feet * FEET_IN_A_METER) + ((inches / 12.0f) * FEET_IN_A_METER);
        return md;
    }

}
