package octalConverter;
import binaryConverter.Binary;

public class Octal {
	
	static Binary biFunction = new Binary();
	
	public static void main(String[] args) {
		System.out.println(getOctal_Bi("-10101111"));
		System.out.println(getOctal_Dec("-999"));
		System.out.println(getOctal_Hex("AF"));
	}
	public String getOctal(String value, String type) {
		if (value.equals("")) {
			 throw new IllegalArgumentException("Empty Argument!");
		}
		if (type.equals("bi")) { return getOctal_Bi(value); }
		else if (type.equals("dec")) { return getOctal_Dec(value); }
		else if (type.equals("hexa")) { return getOctal_Hex(value); }
		else { throw new IllegalArgumentException("Invalid Type"); }
	}
	
	
	// -- Binary to Octal
	private static String getOctal_Bi(String binary) {
		if (binary.charAt(0) == '-') {
			return "-" + expandOct_Bi(binary, 1);
		}
		
		return expandOct_Bi(binary, 0);
	}
	
	
	private static String expandOct_Bi(String binary, int limit) {
		BinaryToOctal map = new BinaryToOctal();
		StringBuilder oct = new StringBuilder();
		
		binary = repeatZero(binary, limit);
		System.out.println(binary);

		StringBuilder temp = new StringBuilder();
		for (int i = binary.length() - 1; i >= 0; i--) {
			temp.insert(0, binary.charAt(i));
			if (temp.length() == 3) {
				Character hexEquivalent = map.BINARY_TO_OCTAL_MAP.get(temp.toString());
				if (hexEquivalent != null) {
					oct.insert(0, hexEquivalent);
					temp.setLength(0);
				} else {
					throw new IllegalArgumentException("Invalid Input " + temp.toString());
				}
				
			}
		}
		
		return oct.toString();
	}
	
	private static String repeatZero(String binary, int limit) {
		if ((binary.length() - limit) % 3 != 0 ) {
	        int remainder = 3 - ((binary.length() - limit) % 3);
	        String zeroes = "0".repeat(remainder);
	        binary = zeroes + binary.substring(limit);
	    } 
	    
	    return binary;
			
	}
	
	
	// -- Decimal to Octal --
	
	private static String getOctal_Dec(String dec) {
		int value = Integer.parseInt(dec);
		
		if (value > 0) {
			return expandOct_Dec(value);
		}
		
		return "-" + expandOct_Dec(Math.abs(value));
		
	}
	
	private static String expandOct_Dec(int value) {
		StringBuilder oct = new StringBuilder();
		DecToOctal map = new DecToOctal();
		Integer remainder;

		while(value > 0) {
			remainder = value % 8;
			Character hexEquivalent = map.DECIMAL_TO_OCTAL_MAP.get(remainder.toString());
			if (hexEquivalent != null) {
				oct.insert(0, hexEquivalent);
				value /= 8;
			}
		}

		return oct.toString();
	}
	
	// -- HexaDecimal to Octal
	private static String getOctal_Hex(String hex) {
		String hexToBinary = biFunction.getBinary(hex, "hexa");
		return getOctal_Bi(hexToBinary);
	}
}