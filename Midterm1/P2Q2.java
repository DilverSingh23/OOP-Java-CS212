public class P2Q2 {
    public static void main (String[] args) {
        int[][] myArray1 = {{1,3,5,7,9},{2,3,4,6,8},{0,1,5,1,3},{4,5,2,7,8},{7,6,3,2,9}};
        int[][] myArray2 = {{1,3,3,2},{4,2,5,6},{1,2,3,4},{7,8,9,4}};
        int[][] myArray3 = {{1,3,5,6,7},{0,8,7,4,3}};
        int[][] myArray4 = {{1,3,3,2},{4,2,5,6},{1,2,3,4},{7,8,9,4}};

        System.out.println(diagonalEqualsRow(myArray1, 0));
        System.out.println(diagonalEqualsRow(myArray2, 2));
        System.out.println(diagonalEqualsRow(myArray3, 0));
        System.out.println(diagonalEqualsRow(myArray4, 6));
    }

    public static boolean diagonalEqualsRow (int[][] arr, int row) {
        if (arr.length != arr[0].length) {
            throw new IllegalArgumentException("Not a square matrix.");
        }
        if (row > arr.length - 1) {
            throw new IllegalArgumentException("Illegal row.");
        }
        int rowSum = 0;
        int diagonalSum = 0;
        int i = 0;
        while (i < arr[row].length) {
            rowSum += arr[row][i];
            diagonalSum += arr[i][i];
            i++;
        }
        if (diagonalSum == rowSum) {
            return true;
        }
        else {
            return false;
        }
    }
}