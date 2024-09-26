/**
 * This class defines constant strings used for user prompts, error messages, 
 * and regular expressions for input validation in a conversion application.
 */
package Conversion;

public class Constant {
    String OPEATION_TYPE = "What you want to perform \n 1. Binary to Decimal \n 2. Octal to Decimal \n 3. Hexadecimal to Decimal \n 4. Decimal to Binary \n 5. Decimal to Octal \n 6. Decimal to Hexadecimal \n 7. Binary to Octal \n 8. Hexadecimal to Octal \n 9. Octal to Binary \n10. Octal to Hexadecimal \n11. Hexadecimal to Binary \n12. Binary to Hexadecimal \n 0. Exit";
    String ENTER_OPERATION = "Select the operation type : ";
    String ENTER_BINARY = "Enter a binary number:";
    String INVALID_BINARY = "Invalid binary number. Please try again.";
    String OUTPUT = "Output : ";
    String INVALID_OPERATION = "Invalid operation";
    String ENTER_OCTAL = "Enter a octal number:";
    String INVALID_OCTAL = "Invalid octal number. Please try again.";
    String INVALID_HEXA = "Invalid hexadecimal number. Please enter (0-9 or A-F)";
    String ENTER_HEXA = "Enter a hexadecimal number";
    String INVALID_DECIMAL = "Invalid decimal number. Please try again.";
    String ENTER_DECIMAL = "Enter decimal number : ";
    String INVALID_OUTPUT_BASE = "Invalid output base";
    String INVALID_INPUT_BASE = "Invalid input base";
    String ENTER_COMMAND = "Enter the command \n For conversion (e.g.  convert binary 1010 decimal) \n For addition (e.g.  add binary 1000 in 1010) \n For subtraction (e.g.  sub binary 1000 from 11010) \nNote :: Use hexa for hexadecimal";
    String IN = "in";
    String FROM = "from";
    String INVALID_COMMAND = "Invalid command";
    String IS_BINARY = "[01]+";
    String IS_OCTAL = "[0-7]+";
    String IS_DECIMAL = "[0-9]+";
    String IS_HEXA = "[0-9a-fA-F]+";
    String EXIT = "exit";
    String EXITING_PROGRAM = "Exiting program";
}
