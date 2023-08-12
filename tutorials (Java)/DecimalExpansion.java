public class DecimalExpansion {
	

	public static void main(String[] args) {
		System.out.println(bi_to_dec("101"));
		System.out.println(oct_to_dec("303237"));
	}
// - Octal to Decimal -
 /**
     * Converts an octal number to a decimal number.
     *
     * @param octal The octal number to be converted (as a string).
     * @return The equivalent decimal representation as a string.
     */
    public static String oct_to_dec(String octal) {
        // Initialize the decimal value to 0
        Integer decimal = 0;
        
        // Convert the octal string to a character array
        char[] octalArray = octal.toCharArray();
        
        // Iterate over the octal digits from right to left
        for (int i = octal.length() - 1; i >= 0; i--) {
            // Convert the octal digit to an integer value
            int octDigit = octalArray[i] - '0';
            
            //calculates 8 raised to the power of the position difference 
            //between the current position i and the rightmost position of 
            //the octal string (which is octal.length() - 1)
            int decDigit = (int) (octDigit * Math.pow(8, octal.length() - i - 1));
            
         // Add decDigit to decimal and assign it back to the decimal variable
            decimal += decDigit;
        }
        
        // Convert the decimal result to a string and return it
        return decimal.toString();
    }

	
	// - Binary to Decimal -
	 /**
	 * Converts a binary number to its decimal representation.
	 *
	 * @param binary A string containing the binary representation.
	 * @return The decimal representation of the provided binary number.
	 */
    public static String bi_to_dec(String binary) {
    	// I used an Integer wrapper class in this 'decimal' variable declaration
    	// to make it an object rather than primitive int, so that we can call
    	// the .toString()
        Integer decimal = 0; 
        
        // Convert the String binary to an array of characters using .toCharArray()
        char[] binaryArray = binary.toCharArray();
        
        // Converts the binary to decimal using weighted positional notation
        for (int i = binary.length() - 1; i >= 0; i--) {
        	// Converts a character to its corresponding integer value
            int biDigit = binaryArray[i] - '0';
            
            //calculates 2 raised to the power of the position difference 
            //between the current position i and the rightmost position of 
            //the binary string (which is binary.length() - 1)
            int decDigit = (int) (biDigit * Math.pow(2, binary.length() - i - 1));
            
            // Add decDigit to decimal and assign it back to the decimal variable
            decimal += decDigit;
        }
        
        return decimal.toString();
    }

}
