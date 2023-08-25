public class HexaDecimalExpansion {
	
	
	DecimalExpansion dec;
	
	
	/**
	 *  Method to convert a binary number to its hexadecimal representation
	 * @param binary (String)
	 * @return hexadecimal equivalent (string)
	 */
	
	public String bi_to_hex(String binary) {
		// Creates an instance of the DecimalExpansion Class
		dec = new DecimalExpansion();
		
		// returns the hexadecimal representation of the given binary number
		// by converting first the binary number to decimal number using the function
		// oct_to_dec() from the dec object (DecimalExpansion class)
		// then using that converted decimal number that is then parsed to Integer
		// as the argument for the dec_to_hex() function
		return dec_to_hex(Integer.parseInt(dec.bi_to_dec(binary)));
	}
	
	
	
	
	/**
	 *  Method to convert an octal number to its hexadecimal representation
	 * @param octal (String)
	 * @return hexadecimal equivalent (string)
	 */
	
	public String oct_to_hex(String octal) {
		// Creates an instance of the DecimalExpansion Class
		dec = new DecimalExpansion();
		
		// returns the hexadecimal representation of the given octal number
		// by converting first the octal number to decimal number using the function
		// oct_to_dec() from the dec object (DecimalExpansion class)
		// then using that converted decimal number that is then parsed to Integer
		// as the argument for the dec_to_hex() function
		return dec_to_hex(Integer.parseInt(dec.oct_to_dec(octal)));
	}
	
	
	

	/**
	 *  Method to convert a decimal number to its hexadecimal representation
	 * @param dec (integer)
	 * @return hexadecimal equivalent (string)
	 */
    public String dec_to_hex(int decimal) {
        // StringBuilder to store the hexadecimal representation
        StringBuilder hex = new StringBuilder();

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
