import javax.swing.*;
public class P1Q3 {
    public static void main (String[] args) {
        String input = JOptionPane.showInputDialog(null, "Enter a string:");
        int digitCount = 0;

        for (int i = 0; i < input.length(); i++) {
            if (Character.isDigit(input.charAt(i))) {
                digitCount++;
            }
        }
        JOptionPane.showMessageDialog(null, "There are " + digitCount + " digits in the provided string.");

    }
}