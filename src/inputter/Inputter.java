package inputter;

import java.util.Scanner;
import java.util.regex.Pattern;


public class Inputter {
    private static Scanner sc = new Scanner(System.in);

    public static String getInputString(String prompt) {
        System.out.print(prompt);
        return sc.nextLine();
    }

    public static int getInputInt(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
            }
        }
    }

    public static double getInputDouble(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Double.parseDouble(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }
    public static String inputStr(String msg, String pattern) {
        while (true) {
            System.out.print(msg);
            String input = sc.nextLine().trim();
            if (Pattern.matches(pattern, input)) 
                return input;
            else
                System.out.println("Invalid format. Please enter a valid value.");
        }
    }
}
