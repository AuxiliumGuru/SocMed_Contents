public class DecimalExpansion {
	

	public static void main(String[] args) {
		System.out.println(bi_to_dec("101"));
		System.out.println(oct_to_dec("303237"));
		System.out.println(hex_to_dec("FACED"));
	}
	
	// - Hexadecimal to Decimal
	
	/**
	 * Converts hexadecimal number to decimal number
	 * @param hex ; The hexadecimal number to be converted
	 * @return the equivalent decimal representation as a string
	 */
	public static String hex_to_dec(String hex) {
		Integer decimal = 0;
		char[] decimalArray = hex.toCharArray();
		
		for (int i = hex.length() -1; i >= 0; i--) {
			int hexDigit = getDecEquivalent(decimalArray[i]);
			int decDigit = (int) (hexDigit * Math.pow(16, hex.length()- i-1));
			decimal += decDigit;
		}
		
		return decimal.toString();
	}
	
	
	/**
	 * Gets the equivalent Decimal representation of a hex char
	 * @param hex
	 * @return the equivalent Decimal representation as integer
	 * @throws IllegalStateException - for invalid hex char
	 */
	public static int getDecEquivalent(char hex) {
		switch(hex) {
		case '1':
			return 1;
		case '2':
			return 2;
		case '3':
			return 3;
		case '4':
			return 4;
		case '5':
			return 5;
		case '6':
			return 6;
		case '7':
			return 7;
		case '8':
			return 8;
		case '9':
			return 9;	
		case 'A':
			return 10;
		case 'B':
			return 11;
		case 'C':
			return 12;
		case 'D':
			return 13;
		case 'E':
			return 14;
		case 'F':
			return 15;
		default:
			throw new IllegalStateException("Invalid Hexadecimal Digit");	
		}
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
