import java.util.Scanner;

public class Calculator {

    public static final Scanner scanner_a = new Scanner(System.in);

    public int add(int a, int b) {
        return a + b;
    }
    public int subtract(int a, int b) {
        return a - b;
    }
    public int divide(int a, int b) {
        if (a == 0) {
            a = 1;
            System.out.println("Warning! Cannot divide by 0. First number increased to 1");
        }

        if (b == 0) {
            b = 1;
            System.out.println("Warning! Cannot divide by 0. Second number increased to 1");
        }
        return a / b;
    }
    public int multiply(int a, int b) {
        return a * b;
    }

    public static void main(String[] args) {


            System.out.println("\n" + "CalcuMaster 3000" + "\n*****************");

            System.out.println("Enter first number");
                int a = scanner_a.nextInt();

            System.out.println("\n" + "Enter 2nd number");
                int b = scanner_a.nextInt();

            System.out.println(
                        "\nPress 1 to add " + " (" + a + " + " + b + ")" +
                        "\nPress 2 to subtract" + " (" + a + " - " + b + ")" +
                        "\nPress 3 to divide" + " (" + a + " / " + b + ")" +
                        "\nPress 4 to multiply" + " (" + a + " * " + b + ")");

        int action = scanner_a.nextInt();
        scanner_a.nextLine();

                    switch (action) {

                        case 1:
                            System.out.println(a + " + " + b + " is " + new Calculator().add(a, b));
                            break;

                        case 2:
                            System.out.println(a + " - " + b + " is " + new Calculator().subtract(a, b));
                            break;

                        case 3:
                            System.out.println(a + " / " + b + " is " + new Calculator().divide(a, b));
                            break;

                        case 4:
                            System.out.println(a + " * " + b + " is " + new Calculator().multiply(a, b));
                            break;

                    }
         }
}
