/*
 * This program converts between binary, octal, decimal, and hexadecimal number systems and supports addition and subtraction for each base.
 * Owner : Arjun Gautam
 * Date : 24/09/24
 */
package Conversion;
import java.util.*;

public class CommandLineConverstion {
    public static Constant constant = new Constant();
    public static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        while(true){
            System.out.println(constant.ENTER_COMMAND);
            String emptyString = "";
            String command = input.nextLine().toLowerCase();
            if (command.equals(constant.EXIT)) {
				System.out.println(constant.EXITING_PROGRAM);
            break;
			}
            String[] inputArray = new String[command.length()];
            int index = 0;
            for(int i = 0 ; i < command.length() ; i++) {
                char character = command.charAt(i);
                if(character != ' ') {
                    emptyString = emptyString + character;
                    continue;
                } else {
                    inputArray[index] = emptyString;
                    index++;
                    emptyString = "";
                }
            }
            if (emptyString != null) {
                inputArray[index] = emptyString;
                index++;
            }

            switch (inputArray[0]) {
                case "convert":
                    convert(inputArray, 1, 2, 3);
                    break;
                    
                case "add":
                    if (inputArray[3].equals(constant.IN)) {
                        additon(inputArray, 1, 2, 4);
                    } else {
                        System.out.println(constant.INVALID_COMMAND);
                    }
                    break;
            
                case "sub":
                    if (inputArray[3].equals(constant.FROM)) {
                        subtraction(inputArray, 1, 2, 4);
                    } else {
                        System.out.println(constant.INVALID_COMMAND);
                    }
                    break;
            
                default:
                    System.out.println(constant.INVALID_COMMAND);
                    break;
            }
        }
    }

    //This method converts a number between binary, octal, decimal, and hexadecimal formats based on the user's input.
    public static void convert(String[] command, int index_1, int index_2, int index_3){
        switch (command[index_1]) {
            case "binary":
                if (command[index_2].matches(constant.IS_BINARY)) {
                    binaryToOther(command, index_2, index_3);
                } else {
                    System.out.println(constant.INVALID_BINARY);
                }
                break;
            case "octal":
                if (command[index_2].matches(constant.IS_OCTAL)) {
                    octalToOther(command, index_2, index_3);
                } else {
                    System.out.println(constant.INVALID_OCTAL);
                }
                break;
            case "decimal":
                if (command[index_2].matches(constant.IS_OCTAL)) {
                    decimalToOther(command, index_2, index_3);
                } else {
                    System.out.println(constant.INVALID_DECIMAL);
                }
                break;
            case "hexa":
                if (command[index_2].matches(constant.IS_HEXA)) {
                    hexaToOther(command, index_2, index_3);
                } else {
                    System.out.println(constant.INVALID_HEXA);
                }
                break;
            default:
                System.out.println(constant.INVALID_INPUT_BASE);
                break;
        }
    }

    //This method converts a binary number to binary, octal, decimal, or hexadecimal based on the user's output format choice.
    public static void binaryToOther(String[] command, int index_2, int index_3){
        long binaryNum = Long.parseLong(command[index_2]);
        switch (command[index_3]){
            case "binary":
                System.out.println(command[index_2]);
                break;
            case "octal":
                System.out.println(constant.OUTPUT + binaryToOctal(binaryNum));
                break;
            case "decimal":
                System.out.println(constant.OUTPUT + binaryToDecimal(binaryNum));
                break;
            case "hexa":
                System.out.println(constant.OUTPUT + binaryToHexa(binaryNum));
                break;
            default:
                System.out.println(constant.INVALID_OUTPUT_BASE);
                break;
        }
    }

    // This method converts an octal number to binary, octal, decimal, or hexadecimal based on the user's output format choice.
    public static void octalToOther(String[] command, int index_2, int index_3){
        long octalNum = Long.parseLong(command[index_2]);
        switch (command[index_3]) {
            case "binary":
                System.out.println(constant.OUTPUT + octalToBinary(octalNum));
                break;
            case "octal":
                System.out.println(command[index_2]);
                break;
            case "decimal":
                System.out.println(constant.OUTPUT + octalToDecimal(octalNum));
                break;
            case "hexa":
                System.out.println(constant.OUTPUT + octalToHexa(octalNum));
                break;
            default:
                System.out.println(constant.INVALID_OUTPUT_BASE);
                break;
        }
    }

    // This method converts a decimal number to binary, octal, decimal, or hexadecimal based on the specified output format.
    public static void decimalToOther(String[] command, int index_2, int index_3){
        long decimalNum = Long.parseLong(command[index_2]);
        switch (command[index_3]) {
            case "binary":
                System.out.println(constant.OUTPUT + decimalToBinary(decimalNum));
                break;
            case "octal":
                System.out.println(constant.OUTPUT + decimalToOctal(decimalNum));
                break;
            case "decimal":
                System.out.println(command[index_2]);
                break;
            case "hexa":
                System.out.println(constant.OUTPUT + decimalToHexa(decimalNum));
                break;
            default:
                System.out.println(constant.INVALID_OUTPUT_BASE);
                break;
        }
    }

    // This method converts a hexadecimal number to binary, octal, decimal, or hexadecimal based on the specified output format.
    public static void hexaToOther(String[] command, int index_2, int index_3){
        long hexa = Long.parseLong(command[index_2], 16);
        switch (command[index_3]) {
            case "binary":
                System.out.println(constant.OUTPUT + hexaToBinary(hexa));
                break;
            case "octal":
                System.out.println(constant.OUTPUT + hexaToOctal(hexa));
                break;
            case "decimal":
                System.out.println(constant.OUTPUT + hexadecimalToDecimal(hexa));
                break;
            case "hexa":
                System.out.println(command[index_2]);
                break;
            default:
                System.out.println(constant.INVALID_OUTPUT_BASE);
                break;
        }
    }

    // This method calculates and returns the value of a number raised to a given exponent using recursive multiplication.
    public static long power(long x, int n) {
        if (n == 0) {
            return 1;
        } else if (n % 2 == 0) {
            long halfPower = power(x, n / 2);
            return halfPower * halfPower;
        } else {
            return x * power(x, n - 1);
        }
    }

    // This method converts a binary number (represented as a long) to its decimal equivalent using positional value calculation.
    public static long binaryToDecimal(long binary) {
        int power = 0;
        long decimal = 0;
        while (binary > 0) {
            long lastDigit = binary % 10;
            decimal = decimal + (lastDigit * power(2, power));
            binary /= 10;
            power++;
        }
        return decimal;
    }

    // This method converts an octal number (represented as a long) to its decimal equivalent using positional value calculation.
    public static long octalToDecimal(long octal) {
        int power = 0;
        long decimal = 0;
        while (octal > 0) {
            long lastDigit = octal % 10;
            decimal = decimal + (lastDigit * power(8, power));
            octal /= 10;
            power++;
        }
        return decimal;
    }

    // This method converts a hexadecimal number (represented as a long) to its decimal equivalent using positional value calculation.
    public static long hexadecimalToDecimal(long hexadecimal) {
        long decimal = 0;
        int power = 0;
                
        while (hexadecimal > 0) {
            long lastDigit = hexadecimal % 16;
            decimal += (lastDigit * power(16, power)); 
            hexadecimal /= 16; 
                power++;
        }
        return decimal;
    }
    
    // This method converts a decimal number (represented as a long) to its binary equivalent, building the binary value using positional notation.
    public static long decimalToBinary(long decimal){
        long binary = 0;
        int power = 0;
        while(decimal > 0){
            long remainder = decimal % 2;
            binary = binary + (remainder * power(10, power));
            power ++;
            decimal /= 2;
        }
        return binary;
    }

    // This method converts a decimal number (represented as a long) to its octal equivalent, constructing the octal value using positional notation.
    public static long decimalToOctal(long decimal){
        long octal = 0;
        int power = 0;
        while(decimal > 0){
            long remainder = decimal % 8;
            octal = octal + (remainder * power(10, power));
            power ++;
            decimal /= 8;
        }
        return octal;
    }

    // This method converts a decimal number (represented as a long) to its hexadecimal equivalent, building the hexadecimal string from its remainder values.
    public static String decimalToHexa(long decimal) {
        String hexa = "";         
        while (decimal > 0) {
            long remainder = decimal % 16;
            
            if (remainder < 10) {
                hexa = remainder + hexa;  
            } else {
                hexa = (char) ('A' + (remainder - 10)) + hexa; 
            }
            decimal /= 16;
        }
        return hexa;
    }    

    // This method converts a binary number to an octal number by first converting the binary to decimal and then decimal to octal.
    public static long binaryToOctal(long binary){
        long result = binaryToDecimal(binary);
        long octal = decimalToOctal(result);
        return octal;
    }

    // This method converts a hexadecimal number to an octal number by first converting the hexadecimal to decimal and then decimal to octal.
    public static long hexaToOctal(long hexa){
        long result = hexadecimalToDecimal(hexa);
        long octal = decimalToOctal(result);
        return octal;
    }

    // This method converts an octal number to a binary number by first converting the octal to decimal and then decimal to binary.
    public static long octalToBinary(long octal){
        long result = octalToDecimal(octal);
        long binary = decimalToBinary(result);
        return binary;
    }

    // This method converts a hexadecimal number to a binary number by first converting the hexadecimal to decimal and then decimal to binary.
    public static long hexaToBinary(long hexa){
        long result = hexadecimalToDecimal(hexa);
        long binary = decimalToBinary(result);
        return binary;
    }

    // This method converts a binary number to a hexadecimal string by first converting the binary to decimal and then decimal to hexadecimal.
    public static String binaryToHexa(long binary){
        long result = binaryToDecimal(binary);
        String hexa = decimalToHexa(result);
        return hexa;
    }

    // This method converts an octal number to a hexadecimal string by first converting the octal to decimal and then decimal to hexadecimal.
    public static String octalToHexa(long octal){
        long result = octalToDecimal(octal);
        String hexa = decimalToHexa(result);
        return hexa;
    }

    // Performs addition of two numbers in the specified base after validating their format.
    public static void additon(String[] command, int index_1, int index_2, int index_3){
        switch (command[index_1]) {
            case "binary":
                if (command[index_2].matches(constant.IS_BINARY) && command[index_3].matches(constant.IS_BINARY)) {
                    System.out.println(constant.OUTPUT + addBinary(command[index_2], command[index_3]));
                } else {
                    System.out.println(constant.INVALID_BINARY);
                }
                break;
            case "octal":
                if (command[index_2].matches(constant.IS_OCTAL) && command[index_3].matches(constant.IS_OCTAL)) {
                    System.out.println(constant.OUTPUT + addOctal(command[index_2], command[index_3]));
                } else {
                    System.out.println(constant.INVALID_OCTAL);
                }
                break;
            case "decimal":
                if (command[index_2].matches(constant.IS_DECIMAL) && command[index_3].matches(constant.IS_DECIMAL)) {
                    System.out.println(constant.OUTPUT + addDecimal(command[index_2], command[index_3]));
                } else {
                    System.out.println(constant.INVALID_DECIMAL);
                }
                break;
            case "hexa":
                if (command[index_2].matches(constant.IS_HEXA) && command[index_3].matches(constant.IS_HEXA)) {
                    System.out.println(constant.OUTPUT + addHexa(command[index_2], command[index_3]));
                } else {
                    System.out.println(constant.INVALID_HEXA);
                }
                break;
            default:
                System.out.println(constant.INVALID_INPUT_BASE);
                break;
        }
    }

    // Performs subtraction of two numbers in the specified base after validating their format.
    public static void subtraction(String[] command, int index_1, int index_2, int index_3){
        switch (command[index_1]) {
            case "binary":
                if (command[index_2].matches(constant.IS_BINARY) && command[index_3].matches(constant.IS_BINARY)) {
                    System.out.println(constant.OUTPUT + subBinary(command[index_2], command[index_3]));
                } else {
                    System.out.println(constant.INVALID_BINARY);
                }
                break;
            case "octal":
                if (command[index_2].matches(constant.IS_OCTAL) && command[index_3].matches(constant.IS_OCTAL)) {
                    System.out.println(constant.OUTPUT + subOctal(command[index_2], command[index_3]));
                } else {
                    System.out.println(constant.INVALID_OCTAL);
                }
                break;
            case "decimal":
                if (command[index_2].matches(constant.IS_DECIMAL) && command[index_3].matches(constant.IS_DECIMAL)) {
                    System.out.println(constant.OUTPUT + subDecimal(command[index_2], command[index_3]));
                } else {
                    System.out.println(constant.INVALID_DECIMAL);
                }
                break;
            case "hexa":
                if (command[index_2].matches(constant.IS_HEXA) && command[index_3].matches(constant.IS_HEXA)) {
                    System.out.println(constant.OUTPUT + subHexa(command[index_2], command[index_3]));
                } else {
                    System.out.println(constant.INVALID_HEXA);
                }
                break;
            default:
                System.out.println(constant.INVALID_INPUT_BASE);
                break;
        }
    }

    // Adds two binary numbers by converting them to decimal, performing the addition, and converting the result back to binary.
    public static long addBinary(String binary1, String binary2) {
        long binNum1 = Long.parseLong(binary1);
        long binNum2 = Long.parseLong(binary2);
        long decimal1 = binaryToDecimal(binNum1);
        long decimal2 = binaryToDecimal(binNum2);
        long sum = decimal1 + decimal2;
        long result = decimalToBinary(sum);
        return result;
    }

    // Adds two octal numbers by converting them to decimal, performing the addition, and converting the result back to octal.
    public static long addOctal(String octal1, String octal2) {
        long octNum1 = Long.parseLong(octal1);
        long octNum2 = Long.parseLong(octal2);
        long decimal1 = binaryToDecimal(octNum1);
        long decimal2 = binaryToDecimal(octNum2);
        long sum = decimal1 + decimal2;
        long result = decimalToBinary(sum);
        return result;
    }
    
    // Adds two decimal numbers and returns the sum as a long.
    public static long addDecimal(String decimal1, String decimal2) {
        long decNum1 = Long.parseLong(decimal1);
        long decNum2 = Long.parseLong(decimal2);
        long sum = decNum1 + decNum2;
        return sum;
    }

    // This method adds two hexadecimal strings and returns their sum as a hexadecimal string.
    public static String addHexa(String hexaDecimal1, String hexaDecimal2) {
        long hexaNum1 = Long.parseLong(hexaDecimal1, 16);
        long hexaNum2 = Long.parseLong(hexaDecimal2, 16);
        long decimal1 = hexadecimalToDecimal(hexaNum1);
        long decimal2 = hexadecimalToDecimal(hexaNum2);
        long sum = decimal1 + decimal2;
        String result = decimalToHexa(sum);
        return result;
    }

    // This method subtracts two binary strings and returns the result as a binary number.
    public static long subBinary(String binary1, String binary2) {
        long binNum1 = Long.parseLong(binary1);
        long binNum2 = Long.parseLong(binary2);
        long decimal1 = binaryToDecimal(binNum1);
        long decimal2 = binaryToDecimal(binNum2);
        long sub = decimal2 - decimal1;
        if(sub < 0){
            System.out.println("The first binary number is small than second, So answer is not print");
            return 0;
        } else {
            long result = decimalToBinary(sub);
            return result;
        }
    }

    // This method subtracts two octal strings and returns the result as an octal number.
    public static long subOctal(String octal1, String octal2) {
        long octNum1 = Long.parseLong(octal1);
        long octNum2 = Long.parseLong(octal2);
        long decimal1 = octalToDecimal(octNum1);
        long decimal2 = octalToDecimal(octNum2);
        long sub = decimal2 - decimal1;
        if(sub < 0){
            System.out.println("The first binary number is small than second, So answer is not print");
            return 0;
        } else {
            long result = decimalToOctal(sub);
            return result;
        }
    }

    // This method subtracts two hexadecimal strings and returns the result as a hexadecimal string.
    public static String subHexa(String hexaDecimal1, String hexaDecimal2) {
        long hexaNum1 = Long.parseLong(hexaDecimal1, 16);
        long hexaNum2 = Long.parseLong(hexaDecimal2, 16);
        long decimal1 = hexadecimalToDecimal(hexaNum1);
        long decimal2 = hexadecimalToDecimal(hexaNum2);
        long sub = decimal2 - decimal1;
        if(sub < 0){
            return "The first binary number is small than second, So answer is not print";
        } else {
            String result = decimalToHexa(sub);
            return result;
        }
    }

    // This method subtracts two decimal strings and returns the result as a long value.
    public static long subDecimal(String decimal1, String decimal2) {
        long decNum1 = Long.parseLong(decimal1);
        long decNum2 = Long.parseLong(decimal2);
        long sub = decNum2 - decNum1;
        return sub;
    }
}
