import javax.swing.*;
public class MakeWords {
    public static void main (String[] args){
        String[] words = {"cap", "door", "home", "gap", "arts", "camera", "film"};
        String[][] arr2D = {
            {"yes", "no", "up"},
            {"maybe", "right", "left"},
            {"right", "right", "left"},
            {"up", "right", "down"}
        };
        String newWord = makeWordfromArray(words);
        String[] newWordArr = makeMultipleWords(arr2D);
        System.out.println(newWord);
        for (int i = 0; i < newWordArr.length; i++){
            System.out.print(newWordArr[i] + " ");
        }
    }
    public static String makeWordfromArray (String[] arr) {
        String createdWord = "";
        int min = 0;
        int max = 0;
        int randomNumber = 0;
        char character;
        for (int i = 0; i < arr.length; i++) {
            max = arr[i].length() - 1;
            randomNumber = min + (int) (Math.random() * (max - min + 1));
            character = arr[i].charAt(randomNumber);
            createdWord += Character.toString(character);
        }
        return createdWord;
    }
    
    public static String[] makeMultipleWords (String[][] arr2D) {
        String[] createdWordArr = new String[arr2D.length];
        for (int k = 0; k < createdWordArr.length; k++){
            createdWordArr[k] = "";
        }
        int min = 0;
        int max = 0;
        int randomNumber = 0;
        char character;
        for (int i = 0; i < arr2D.length; i++) {
            for (int j = 0; j < arr2D[i].length; j++) {
                max = arr2D[i][j].length() - 1;
                randomNumber = min + (int) (Math.random() * (max - min + 1));
                character = arr2D[i][j].charAt(randomNumber);
                createdWordArr[i] += Character.toString(character);
            }
        }
        return createdWordArr;
    }
}