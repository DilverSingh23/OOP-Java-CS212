public class P1Q1 {
    public static void main(String[] args) {
        if (args.length != 2) {
            throw new IllegalArgumentException ("Please enter two inputs, no more, no less.");
        }
        else {
            int num1 = Integer.parseInt(args[0]);
            int num2 = Integer.parseInt(args[1]);
            int sum = num1 + num2;
            int product = num1 * num2;
            System.out.println(num1 + " + " + num2 + " = " + sum);
            System.out.println(num1 + " * " + num2 + " = " + product);
        }
    }
}