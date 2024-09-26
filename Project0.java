// Name: Dilver Singh
// Lab Section: 121A
import javax.swing.*;

public class Project0 {
    public static void main(String[] args) {
        /* Intializing the value of the user input so the while loop can initially run, and both counts as well 
        to keep track of e's by case */ 
        String input = "N/A";
        int upperCount = 0;
        int lowerCount = 0;

        // While loop so the program can run for as many inputs the user wishes until they input stop to end the program
        while(!input.equalsIgnoreCase("Stop")) {
            //Reset the count variables to 0 so the count of e's from previous inputs don't continue to add up
            upperCount = 0;
            lowerCount = 0;
            // Recieve user input and store it in a string variable to be able to check individual characters for e's after
            input = JOptionPane.showInputDialog( null, "Please enter a sentence.");
            // if statement to end the program if the user enters the word stop in any case
            if (input.equalsIgnoreCase("Stop")){
                System.exit(0);
            }
            else {
                for (int i = 0; i < input.length(); i++) {
                    //store each proceeding letter in a variable to later determine whether or not its an e
                    char currentLetter = input.charAt(i);
                    // if condition calling a boolean function to check if the current letter is an e
                    if (eIsThere(currentLetter)) {
                        // if the function returns true and the e is there we use the .isUpperCase to delibrate whether the e seen is upper or lower case
                        if (Character.isUpperCase(currentLetter)) {
                            upperCount++;
                        }
                        else {
                            lowerCount++;
                        }
                        // increment either count based on the case of e to be able to output to the JOptionPane the number of lower and uppercase e's in the input
                    }
                }
            }
            JOptionPane.showMessageDialog(null, "Number of lowercase e's: " + lowerCount + "\nNumber of uppercase e's: " + upperCount);
        }
    }

    // function passing in the currentLetter of the loop to see if it is an e
    public static boolean eIsThere(char currentLetter) 
    {
        // making the character lowercase to begin with just to check if there is an e as case is checked in the main program
        if (Character.toLowerCase(currentLetter) == 'e') {
            return true;
        }
        return false;
    }
}
