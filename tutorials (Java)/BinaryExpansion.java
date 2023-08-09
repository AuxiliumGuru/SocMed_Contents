public class BinaryExpansion {
	// Main function
	public static void main(String[] args) {
		System.out.println(binary_expansion(10));
	}
	/**
	 *  Method to convert a decimal number to its binary representation
	 * @param dec (Decimal value)
	 * @return binary equivalent (string)
	 */
    public static String binary_expansion(int dec) {
        // StringBuilder to store the binary representation
        StringBuilder binary = new StringBuilder();
     
        int remainder;
        // Loop to perform binary conversion
        while (dec > 0) {
            // Get the remainder when dividing the decimal number by 2
            remainder = dec % 2;
            
            // Insert the remainder at the beginning of the StringBuilder
            binary.insert(0, remainder);
            
            // Update the decimal number by dividing it by 2
            dec /= 2;
        }
        
        // Convert the StringBuilder to a String and return the binary representation
        return binary.toString();
    }
}
