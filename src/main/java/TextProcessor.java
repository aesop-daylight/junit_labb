import java.util.Scanner;
import java.lang.*;
import static java.lang.System.*;

public class TextProcessor {

    public static Scanner sc = new Scanner(in);
    public static String input = "Placeholder";

    public static void main(String[] args) {

        System.out.println  ("\n" + "StringMaster 3000" +
                            "\n*****************");
        System.out.println  ("Enter text: ");

        input = sc.nextLine();

        System.out.println(
                        "\nPress 1 to convert to UPPERS: " +
                        "\nPress 2 to convert to lower: " +
                        "\nPress 3 to reverse ");

        Scanner scanner_menu = new Scanner(System.in);
        int action = scanner_menu.nextInt();
        scanner_menu.nextLine();

        switch (action) {

            case 1:
                out.println("\n" + input + " in uppers is: ");
                new TextProcessor().toUpper();
                break;

            case 2:
                out.println("\n" + input + " in lowers is: ");
                new TextProcessor().toLower();
                break;

            case 3:
                out.println("\n" + input + " reversed is: ");
                new TextProcessor().reverse();
                break;
        }
    }

    public String toUpper() {
        String output = input.toUpperCase();
        System.out.println(output);
        return output;
    }

    public String toLower() {

        String output = input.toLowerCase();
        System.out.println(output);

        return output;

    }

    public String reverse() {

        String reverseString;
        String output;

        StringBuilder inputStr = new StringBuilder(input);
        reverseString = inputStr.reverse().toString();
        output = reverseString;
        System.out.println(reverseString);
        return output;
    }
}


