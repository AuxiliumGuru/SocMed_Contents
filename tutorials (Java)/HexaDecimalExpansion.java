public class HexaDecimalExpansion {
	
	public static void main(String[] args) {
		System.out.println(hex_expansion(200));
	}
	
	/**
	 *  Method to convert a decimal number to its hexadecimal representation
	 * @param dec (integer)
	 * @return hexadecimal equivalent (string)
	 */
    public static String hex_expansion(int decimal) {
        // StringBuilder to store the hexadecimal representation
        StringBuilder hex = new StringBuilder();
        // remainder var to stor remainders of each modulo operation
        int remainder;
        // Loop to perform hexadecimal conversion
        while (decimal > 0) {
            // Get the remainder when dividing the decimal number by 16
            remainder = decimal % 16;
            
            if (remainder > 9) {
            	hex.insert(0, getHexEquivalent(remainder));
            } else {
            	// Insert the remainder at the beginning of the StringBuilder
                hex.insert(0, remainder);
            }
     
            // Update the decimal number by dividing it by 16
            decimal /= 16;
        }
        
        // Convert the StringBuilder to a String and return the binary representation
        return hex.toString();
    }
    
    
    /**
     * Method to convert the remainder > 9 to its hexadecimal representation
     * @param num (remainder)
     * @return HexaDecimal Char Equivalent 
     */
    public static char getHexEquivalent(int num) {
    	
    	switch (num) {
    	case 10:
    		return 'A';
    	case 11:
    		return 'B';
    	case 12:
    		return 'C';
    	case 13:
    		return 'D';
    	case 14:
    		return 'E';
    	case 15:
    		return 'F';
		default:
			throw new IllegalStateException("Invalid Number");
    	}
    	
    }
}
