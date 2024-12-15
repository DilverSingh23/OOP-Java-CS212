import java.util.Comparator;
public class ApplianceComparator implements Comparator<String> {
    /**
     * Compares two serial numbers for their ordering in the TreeMap
     * @param serial1 The first serial number compared
     * @param serial2 The second serial number compared
     * @return An integer < 0 if serial1 is less than serial2,
     * an integer > 0 if serial1 is greater than serial2,
     * or a 0 if serial1 and serial2 are equal
     */
    @Override
    public int compare(String serial1, String serial2) {
        return serial1.compareTo(serial2); 
    }
}