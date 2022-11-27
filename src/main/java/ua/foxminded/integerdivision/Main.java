package ua.foxminded.integerdivision;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Dividend: ");
            int dividend = scanner.nextInt();
            System.out.print("Divisor: ");
            int divisor = scanner.nextInt();
            System.out.println();

            IntegerDivision integerDivision = new IntegerDivision();
            DivisionData result = integerDivision.divide(dividend, divisor);
            DivisionFormatter formatter = new DivisionFormatter();
            System.out.println(formatter.format(result));
        }
    }
}