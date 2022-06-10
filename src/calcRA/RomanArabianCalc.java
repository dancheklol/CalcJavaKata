package calcRA;

import java.util.InputMismatchException;
import java.util.Scanner;
public class RomanArabianCalc {
    static Scanner scanner = new Scanner(System.in);
    static int a, b;
    static char o;
    static int r;
    public static void main (String[] args) {
        System.out.println("Введите выражение");
        String userInput = scanner.nextLine();
        char[] under_char = new char[10];
        for (int i = 0; i < userInput.length(); i++) {
            under_char[i] = userInput.charAt(i);
            if (under_char[i] == '+') {
                o = '+';
            }
            if (under_char[i] == '-') {
                o = '-';
            }
            if (under_char[i] == '*') {
                o = '*';
            }
            if (under_char[i] == '/') {
                o = '/';
            }
        }
        String under_charString = String.valueOf(under_char);
        String[] blacks = under_charString.split("[+-/*]");
        String stable00 = blacks[0];
        String stable01 = blacks[1];
        String string03 = stable01.trim();
        a = romanToNumber(stable00);
        b = romanToNumber(string03);
        if (a < 0 && b < 0) {
            r = 0;
        } else {
            r = calculated(a, b, o);
            String rRoman = convertNumToRoman(r);
            System.out.println(stable00 + " " + o + " " + string03 + " = " + rRoman);
        }
        a = Integer.parseInt(stable00);
        b = Integer.parseInt(string03);
        r = calculated(a, b, o);
        System.out.println(a + " " + o + " " + b + " = " + r);
    }
    private static String convertNumToRoman (int numArabian) {
        String[] roman = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
        };
        return roman[numArabian];
    }
    private static int romanToNumber (String roman) {
        try {
            return switch (roman) {
                case "I" -> 1;
                case "II" -> 2;
                case "III" -> 3;
                case "IV" -> 4;
                case "V" -> 5;
                case "VI" -> 6;
                case "VII" -> 7;
                case "VIII" -> 8;
                case "IX" -> 9;
                case "X" -> 10;
                default -> -1;
            };
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static int calculated (int num1, int num2, char op) {
        int r = 0;
        switch (op) {
            case '+':
                r = num1 + num2;
                break;
            case '-':
                r = num1 - num2;
                break;
            case '*':
                r = num1 * num2;
                break;
            case '/':
                try {
                    r = num1 / num2;
                } catch (ArithmeticException | InputMismatchException e) {
                    System.out.println("Exception : " + e);
                    System.out.println("Укажите целое число больше нуля ");
                    break;
                }
                break;
            default:
                throw new IllegalArgumentException("Выражение некорректно.");
        }
        return r;
    }
}