package binaryConverter;

public class Binary {
	static Binary biFunction = new Binary();

	public static void main(String[] args) {
		System.out.println(biFunction.getBinary("-5", "dec"));
		System.out.println(biFunction.getBinary("-AF", "hexa"));
		System.out.println(biFunction.getBinary("-127", "octal"));
	}

	public String getBinary(String value, String type) {

		if (value.equals("")) {
			throw new IllegalArgumentException("Empty Argument");
		}

		if(type.equals("hexa")) { return getBinary_Hex(value);} 
		else if (type.equals("dec")) { return getBinary_Dec(value); } 
		else if (type.equals("octal")) { return getBinary_Octal(value); } 
		else { throw new IllegalArgumentException("Invalid Type"); }

	}

	// -- Decimal to Binary --
	private static String getBinary_Dec(String dec) {
		int value = Integer.parseInt(dec);

		if (value > 0) {
			return expandBi_Dec(value);
		}
	
		return "-" + expandBi_Dec(Math.abs(value));


	}
	private static String expandBi_Dec(int value) {
		StringBuilder binary = new StringBuilder();
		int remainder;
		while(value > 0) {
			remainder = value % 2;
			binary.insert(0, remainder);
			value /= 2;
		}
		return binary.toString();
	}

	// -- Hexadecimal to Binary --

	private static String getBinary_Hex(String hex) {
		if (hex.charAt(0) == '-') {
			return "-" + expandBi_Hex(hex, 1);
		} 

		return expandBi_Hex(hex, 0);

	}

	private static String expandBi_Hex(String hex, int i) {
		StringBuilder binary = new StringBuilder();
		HexToBinary map = new HexToBinary();
		for (; i < hex.length(); i++) {
			char hexDigit = hex.charAt(i);
			String binaryEquivalent = map.HEX_TO_BINARY_MAP.get(Character.toUpperCase(hexDigit));
			if (binaryEquivalent != null) {
				binary.append(binaryEquivalent);
			} else {
				// Handle invalid hex digit
				throw new IllegalArgumentException("Invalid hexadecimal digit: " + hexDigit);
			}
		}

		return binary.toString();
	}

	// -- Octal to Binary --

	private static String getBinary_Octal(String octal) {

		if (octal.charAt(0) == '-') {
			return "-" + expandBi_Oct(octal, 1);
		} 

		return expandBi_Oct(octal, 0);


	}

	private static String expandBi_Oct(String octal, int i) {
		StringBuilder binary = new StringBuilder();
		OctalToBinary map = new OctalToBinary();
		for (; i < octal.length(); i++) {
			char octalDigit = octal.charAt(i);
			String binaryEquivalent = map.OCTAL_TO_BINARY_MAP.get(Character.toUpperCase(octalDigit));
			if (binaryEquivalent != null) {
				binary.append(binaryEquivalent);
			} else {
				// Handle invalid octal digit
				throw new IllegalArgumentException("Invalid octal digit: " + octalDigit);
			}
		}

		return binary.toString();
	}

}
