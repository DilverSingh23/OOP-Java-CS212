import javax.swing.*;
public class P2Q1 {
    public static void main (String[] args) {
        String input = JOptionPane.showInputDialog(null, "Enter a string: ");
        int numofOccurances = twoDigits(input);
        JOptionPane.showMessageDialog(null, "Two digits happen " + numofOccurances + " times.");
    }

    public static int twoDigits (String userInput) {
        int count = 0;
        int i = 0;
        while (i+1 < userInput.length()){
            if (Character.isDigit(userInput.charAt(i)) && Character.isDigit(userInput.charAt(i+1))){
                count++;
            }
            i++;
        }
        return count;
    }
}
