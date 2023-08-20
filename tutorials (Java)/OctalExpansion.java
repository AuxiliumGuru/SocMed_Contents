package tutorial;

public class OctalExpansion {
	
	
	DecimalExpansion dec;
	
	/**
	 *  Method to convert a binary number to its octal representation
	 * @param binarry (Binary value)
	 * @return octal equivalent (string)
	 */
	public String bi_to_oct(String binary) {
		// Creates an instance of the DecimalExpansion Class
		dec = new DecimalExpansion();
		
		// returns the octal representation of the given binary number
		// by converting first the binary number to decimal number using the function
		// bi_to_dec() from the dec (DecimalExpansion class)
		// then using that converted decimal number as the argument for
		// the dec_to_bi() function
		return dec_to_oct(Integer.parseInt(dec.bi_to_dec(binary)));
	}
	
	
	
	/**
     * Converts a decimal number to its octal representation.
     *
     * @param decimal The decimal number to be converted to octal.
     * @return The octal representation of the input decimal number as a string.
     */
    public String dec_to_oct(int decimal) {
    	// Creates an instance of the StringBuilder class
        StringBuilder octal = new StringBuilder();
        
        // Stores the remainder of each successive division
        int remainder;

        // Convert the decimal number to octal representation
        while (decimal > 0) {
        	// Get the remainder when dividing the decimal number by 8
            remainder = decimal % 8;
            
            // Insert the remainder at the beginning of the StringBuilder
            octal.insert(0, remainder);
            
            // Update the decimal number by dividing it by 8
            decimal /= 8;
        }
        
        // Convert the StringBuilder to a String and return the octal representation
        return octal.toString();
    }
    
    /* Note:
     * 		This code is somehow similar to the dec_to_binary we did. 
     *	We just changed the base to 8, instead of 2
     */
	
}
