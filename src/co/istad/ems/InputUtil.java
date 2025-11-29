package co.istad.ems;

import java.math.BigDecimal;
import java.util.Scanner;

public class InputUtil {

    private static final Scanner scanner = new Scanner(System.in);

    public static String getText(String label) {
        DisplayUtil.print(label + " → ", false);
        return scanner.nextLine();
    }

    public static BigDecimal getMoney(String label) {
        while (true) {
            try {
                DisplayUtil.print(label + " → ", false);
                return new BigDecimal(scanner.nextLine());
            } catch (Exception e) {
                DisplayUtil.print("Invalid number!", true);
            }
        }
    }

    public static Integer getInteger(String label) {
        while (true) {
            try {
                DisplayUtil.print(label + " → ", false);
                return Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                DisplayUtil.print("Invalid input!", true);
            }
        }
    }
}
