public class P1Q2 {
    public static void main (String[] args) {
        int arr[][] = {{10,45}, {2,42,67,3}, {3,21}};

        System.out.println(getSumofRow(arr, 1));
    }

    private static int getSumofRow(int[][] arr, int index) {
        int sum = 0;
        for (int i = 0; i < arr[index].length; i++) {
            sum += arr[index][i];
        }
        return sum;
    }
}
