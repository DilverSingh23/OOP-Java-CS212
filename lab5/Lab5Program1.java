import javax.swing.*;

public class Lab5Program1 {

	private static int inputFromFile (String filename, String[] words){
		TextFileInput in = new TextFileInput(filename);
		int lengthFilled = 0;
		String line = in.readLine();
		while ( lengthFilled < words.length && line != null ) {
			words[lengthFilled++] = line;
			line = in.readLine();
		} // while
		if ( line != null ) {
			System.out.println("File contains too many numbers.");
			System.out.println("This program can process only " + words.length + " numbers.");
			System.exit(1);
		} 
		in.close();
		return lengthFilled;
	} 		

	public static void main(String[] args) {
	
		String[] wordArray = new String[8];
		String myFile = args[0];
		String isOrIsNot = "is", inputWord = "N/A";
		inputFromFile (myFile, wordArray);
			
		// This line asks the user for input by popping out a single window
		// with text input
		while (!inputWord.equals("STOP")) {
			inputWord = JOptionPane.showInputDialog(null, "Enter a word in all lower case:");
			if (inputWord.equals("STOP")) {
				System.exit(0);
			}
			else {
				// if the inputWord is contained within wordArray return true
				if (wordIsThere(inputWord, wordArray)) 
					isOrIsNot = "is"; // set to is if the word is on the list
				else
					isOrIsNot = "is not"; // set to is not if the word is not on the list
		
			}
			// Output to a JOptionPane window whether the word is on the list or not
			JOptionPane.showMessageDialog(null, "The word " + inputWord + " " + isOrIsNot + " on the list.");
		}
	} //main

	public static boolean wordIsThere(String findMe, String[] theList) {
		for(int i=0; i < theList.length; i++) {
			if (findMe.equals(theList[i])) {
				return true;
			}
		}
		return false;
	} // wordIsThere
} // class Lab4Program1
