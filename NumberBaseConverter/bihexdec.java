/*
    Description:
    A utility program to perform conversions and additions between binary, decimal, and hexadecimal numbers.
    This file represents a cleaner, more structured version of a conversion calculator.

    Originally written by Steven Pham.
    This version includes structural refinements and minor UI improvements for clarity.
    Functionality includes:
    - Convert between binary, decimal, and hexadecimal
    - Add any two numbers from any base and show result in all three bases
    - Menu-driven interface with Scanner input
    Note: Logic was refined from the prototype version but remains faithful to its intent.
 */

import java.util.Scanner;

public class bihexdec {

    public static String[] HEX_LETTERS = {"A", "B", "C", "D", "E", "F"};
    public static int[] HEX_VALUES = {10, 11, 12, 13, 14, 15};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            long inputBase, operation, secondBase;
            long decimalInput1 = 0, decimalInput2 = 0;
            String inputStr1 = "0", inputStr2 = "0";

            System.out.println("Choose input base: 0 = Binary, 1 = Hexadecimal, 2 = Decimal, -1 = Exit");
            inputBase = safeLongInput(scanner);
            if (inputBase == -1) {
                scanner.close();
                return;
            }

            System.out.println("Enter the value:");
            if (inputBase == 0 || inputBase == 1) {
                scanner.nextLine();
                inputStr1 = scanner.nextLine();
            } else if (inputBase == 2) {
                decimalInput1 = safeLongInput(scanner);
            }

            System.out.println("Choose operation: 0 = Convert, 1 = Add, 2 = Subtract");
            operation = safeLongInput(scanner);

            if (operation == 0) {
                System.out.println("Convert to base: 0 = Binary, 1 = Hexadecimal, 2 = Decimal");
                secondBase = safeLongInput(scanner);
                if (inputBase == 2) {
                    printConversion(decimalInput1, secondBase);
                } else if (inputBase == 0) {
                    printConversion(binToDec(inputStr1), secondBase);
                } else if (inputBase == 1) {
                    printConversion(hexToDec(inputStr1), secondBase);
                }
            } else {
                System.out.println("Enter the second value:");
                secondBase = safeLongInput(scanner);
                if (secondBase == 0 || secondBase == 1) {
                    scanner.nextLine();
                    inputStr2 = scanner.nextLine();
                } else if (secondBase == 2) {
                    decimalInput2 = safeLongInput(scanner);
                }

                if (inputBase == 0) decimalInput1 = binToDec(inputStr1);
                if (inputBase == 1) decimalInput1 = hexToDec(inputStr1);
                if (secondBase == 0) decimalInput2 = binToDec(inputStr2);
                if (secondBase == 1) decimalInput2 = hexToDec(inputStr2);

                long result = operation == 1 ? decimalInput1 + decimalInput2 : decimalInput1 - decimalInput2;

                System.out.println("Result in Binary: " + decToBin(result));
                System.out.println("Result in Hex: " + decToHex(result));
                System.out.println("Result in Decimal: " + result);
            }
        }
    }

    public static long safeLongInput(Scanner scanner) {
        while (!scanner.hasNextLong()) {
            System.out.println("Invalid input. Please enter a valid number:");
            scanner.next();
        }
        return scanner.nextLong();
    }

    public static String decToBin(long num) {
        if (num == 0) return "0";
        String result = "";
        while (num > 0) {
            result = (num % 2) + result;
            num /= 2;
        }
        return result;
    }

    public static long binToDec(String bin) {
        long result = 0;
        int power = 0;
        for (int i = bin.length() - 1; i >= 0; i--) {
            result += (bin.charAt(i) - '0') * Math.pow(2, power++);
        }
        return result;
    }

    public static String decToHex(long num) {
        if (num == 0) return "0";
        String result = "";
        while (num > 0) {
            int rem = (int)(num % 16);
            if (rem < 10) result = rem + result;
            else result = HEX_LETTERS[rem - 10] + result;
            num /= 16;
        }
        return result;
    }

    public static long hexToDec(String hex) {
        long result = 0;
        int power = 0;
        for (int i = hex.length() - 1; i >= 0; i--) {
            char ch = Character.toUpperCase(hex.charAt(i));
            int value;
            if (Character.isDigit(ch)) value = ch - '0';
            else value = 10 + (ch - 'A');
            result += value * Math.pow(16, power++);
        }
        return result;
    }

    public static void printConversion(long num, long base) {
        if (base == 0) System.out.println("Binary: " + decToBin(num));
        else if (base == 1) System.out.println("Hex: " + decToHex(num));
        else if (base == 2) System.out.println("Decimal: " + num);
    }
}
