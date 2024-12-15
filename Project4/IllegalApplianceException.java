/*
 * Class that creates an argument exception for appliances
 */
public class IllegalApplianceException extends IllegalArgumentException {
    /**
     * 
     * @param message contains the info of what the exception at hand is to be displayed
     */
    public IllegalApplianceException (String message) {
        super(message);
    }
}
