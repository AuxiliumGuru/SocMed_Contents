public class OctalExpansion {
	
	public static void main(String[] args) {
		System.out.println(dec_to_oct(9));
	}
	
	/**
     * Converts a decimal number to its octal representation.
     *
     * @param decimal The decimal number to be converted to octal.
     * @return The octal representation of the input decimal number as a string.
     */
    public static String dec_to_oct(int decimal) {
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
