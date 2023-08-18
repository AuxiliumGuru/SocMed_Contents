package tutorial;
//import tutorial.DecimalExpansion;

public class BinaryExpansion {
	
	DecimalExpansion dec;
	
	
	/**
	 *  Method to convert a octal number to its binary representation
	 * @param octal (Octal string value)
	 * @return binary equivalent (string)
	 */
	 public String oct_to_bi(String octal) {
		 // Create an instance of the DecimalExpansion class
			dec = new DecimalExpansion();
		 // returns binary representation of the given octal number
			return dec_to_bi(Integer.parseInt(dec.oct_to_dec(octal)));
		}
	
	/**
	 *  Method to convert a decimal number to its binary representation
	 * @param dec (Decimal value)
	 * @return binary equivalent (string)
	 */
    public String dec_to_bi(int dec) {
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
