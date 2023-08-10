public class DecimalExapansion {
	
	// Binary to Decimal 
	
	public static void main(String[] args) {
		System.out.println(bi_to_dec("101"));
	}
	
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
