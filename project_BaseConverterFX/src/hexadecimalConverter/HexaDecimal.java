package hexadecimalConverter;

import binaryConverter.Binary;

public class HexaDecimal{
	
	static Binary biFunction = new Binary();
	
	public static void main(String[] args) {
		
		System.out.println(getHex_Bi("-1101111110101"));
		System.out.println(getHex_Octal("-7"));
		System.out.println(getHex_Dec("10"));
		
	}
	
	public String getHex(String value, String type) {
		
		if (value.equals("")) {
			 throw new IllegalArgumentException("Empty Argument!");
		}
		
		if (type.equals("bi")) { return getHex_Bi(value); }
		else if (type.equals("octa	l")) { return getHex_Octal(value); }
		else if (type.equals("dec")) { return getHex_Dec(value); }
		else { throw new IllegalArgumentException("Invalid Type"); }
	}
	
	// -- Binary to Hexadecimal
	private static String getHex_Bi(String binary) {
		
		if (binary.charAt(0) == '-') {
			return "-" + expandHex_Bi(binary, 1);
		}
		
		return expandHex_Bi(binary, 0);
	}
	
	private static String expandHex_Bi(String binary, int limit) {
		BinaryToHex map = new BinaryToHex();
		StringBuilder hex = new StringBuilder();
		
		
		binary = repeatZero(binary, limit);
		
		StringBuilder temp = new StringBuilder();
		for (int i = binary.length() - 1; i >= 0; i--) {
			temp.insert(0, binary.charAt(i));
			if (temp.length() == 4) {
				Character hexEquivalent = map.BI_TO_HEX_MAP.get(temp.toString());
				if (hexEquivalent != null) {
					hex.insert(0, hexEquivalent);
					temp.setLength(0);
				} else {
					throw new IllegalArgumentException("Invalid Input " + temp.toString());
				}
				
			}
		}
		
		return hex.toString();
	}
	
	private static String repeatZero(String binary, int limit) {
		if ((binary.length() - limit) % 4 != 0 ) {
	        int remainder = 4 - ((binary.length() - limit) % 4);
	        String zeroes = "0".repeat(remainder);
	        binary = zeroes + binary.substring(limit);
	    }
	    
	    return binary;
			
	}
	
	// -- Octal to Hexadecimal
	private static String getHex_Octal(String oct) {
		String octToBinary = biFunction.getBinary(oct, "octal");
		return getHex_Bi(octToBinary);
		
	}
	
	
	// -- Decimal to Hexadecimal
	private static String getHex_Dec(String dec) {
		int value = Integer.parseInt(dec);
		
		if (value > 0) {
			return expandHex_Dec(value);
		}
		
		return "-" + expandHex_Dec(Math.abs(value));
	}
	
	public static String expandHex_Dec(int value) {
		StringBuilder hex = new StringBuilder();
		DecToHexa map = new DecToHexa();
		Integer remainder;

		while(value > 0) {
			remainder = value % 16;
			Character hexEquivalent = map.DEC_TO_HEX_MAP.get(remainder.toString());
			if (hexEquivalent != null) {
				hex.insert(0, hexEquivalent);
				value /= 16;
			}
		}

		return hex.toString();
	}
}
