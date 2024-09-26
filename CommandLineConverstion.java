package Converstion;
import java.util.*;

public class CommandLineConverstion {
    public static Constant constant = new Constant();
    public static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println(constant.ENTER_COMMAND);
        String emptyString = "";
        String command = input.nextLine().toLowerCase();
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
		if (!emptyString.isEmpty()) {
            inputArray[index] = emptyString;
            index++;
        }

        if(inputArray[0].equals(constant.CONVERT)){
            int index_1 = 1;
            int index_2 = 2;
            int index_3 = 3;
            convert(inputArray, index_1, index_2, index_3);
        } else if(inputArray[0].equals(constant.ADD) && inputArray[3].equals(constant.IN)){
            int index_1 = 1;
            int index_2 = 2;
            int index_3 = 4;
            additon(inputArray, index_1, index_2, index_3);
        } else if(inputArray[0].equals(constant.SUB) && inputArray[3].equals(constant.FROM)){
            int index_1 = 1;
            int index_2 = 2;
            int index_3 = 4;
            subtraction(inputArray, index_1, index_2, index_3);
        } else {
            System.out.println(constant.INVALID_COMMAND);
        }
    }

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

    public static long binaryToOctal(long binary){
        long result = binaryToDecimal(binary);
        long octal = decimalToOctal(result);
        return octal;
    }

    public static long hexaToOctal(long hexa){
        long result = hexadecimalToDecimal(hexa);
        long octal = decimalToOctal(result);
        return octal;
    }

    public static long octalToBinary(long octal){
        long result = octalToDecimal(octal);
        long binary = decimalToBinary(result);
        return binary;
    }

    public static long hexaToBinary(long hexa){
        long result = hexadecimalToDecimal(hexa);
        long binary = decimalToBinary(result);
        return binary;
    }

    public static String binaryToHexa(long binary){
        long result = binaryToDecimal(binary);
        String hexa = decimalToHexa(result);
        return hexa;
    }

    public static String octalToHexa(long octal){
        long result = octalToDecimal(octal);
        String hexa = decimalToHexa(result);
        return hexa;
    }

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

    public static long addBinary(String binary1, String binary2) {
        long bin1 = Long.parseLong(binary1);
        long bin2 = Long.parseLong(binary2);
        long decimal1 = binaryToDecimal(bin1);
        long decimal2 = binaryToDecimal(bin2);
        long sum = decimal1 + decimal2;
        long result = decimalToBinary(sum);
        return result;
    }

    public static long addOctal(String octal1, String octal2) {
        long oct1 = Long.parseLong(octal1);
        long oct2 = Long.parseLong(octal2);
        long decimal1 = binaryToDecimal(oct1);
        long decimal2 = binaryToDecimal(oct2);
        long sum = decimal1 + decimal2;
        long result = decimalToBinary(sum);
        return result;
    }
    
    public static long addDecimal(String decimal1, String decimal2) {
        long dec1 = Long.parseLong(decimal1);
        long dec2 = Long.parseLong(decimal2);
        long sum = dec1 + dec2;
        return sum;
    }

    public static long addHexa(String hexa1, String hexa2) {
        long hex1 = Long.parseLong(hexa1);
        long hex2 = Long.parseLong(hexa2);
        long decimal1 = hexadecimalToDecimal(hex1);
        long decimal2 = hexadecimalToDecimal(hex2);
        long sum = decimal1 + decimal2;
        long result = decimalToBinary(sum);
        return result;
    }

    public static long subBinary(String binary1, String binary2) {
        long bin1 = Long.parseLong(binary1);
        long bin2 = Long.parseLong(binary2);
        long decimal1 = binaryToDecimal(bin1);
        long decimal2 = binaryToDecimal(bin2);
        long sum = decimal2 - decimal1;
        long result = decimalToBinary(sum);
        return result;
    }

    public static long subOctal(String octal1, String octal2) {
        long oct1 = Long.parseLong(octal1);
        long oct2 = Long.parseLong(octal2);
        long decimal1 = octalToDecimal(oct1);
        long decimal2 = octalToDecimal(oct2);
        long sum = decimal2 - decimal1;
        long result = decimalToOctal(sum);
        return result;
    }

    public static long subHexa(String hexa1, String hexa2) {
        long hex1 = Long.parseLong(hexa1);
        long hex2 = Long.parseLong(hexa2);
        long decimal1 = hexadecimalToDecimal(hex1);
        long decimal2 = hexadecimalToDecimal(hex2);
        long sum = decimal2 - decimal1;
        long result = decimalToBinary(sum);
        return result;
    }

    public static long subDecimal(String decimal1, String decimal2) {
        long dec1 = Long.parseLong(decimal1);
        long dec2 = Long.parseLong(decimal2);
        long sum = dec2 - dec1;
        return sum;
    }
}
