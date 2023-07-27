package decimalConverter;

public class Decimal {
	
	private static Decimal decFunc = new Decimal();
	public static void main(String[] args) {
		System.out.println(decFunc.getDecimal("-100001", "bi"));
		System.out.println(decFunc.getDecimal("-2765", "octal"));
		System.out.println(decFunc.getDecimal("-AF56", "hexa"));
	}
	
	public String getDecimal(String value, String type) {

		if (value.equals("")) {
			 throw new IllegalArgumentException("Empty Argument!");
		}
		
		if (type.equals("bi")) { return getDecimal_Bi(value); }
		else if (type.equals("octal")) { return getDecimal_Oct(value); }
		else if (type.equals("hexa")) { return getDecimal_Hex(value); }
		else { throw new IllegalArgumentException("Invalid Type"); }
		
	}
	
	
	// -- Binary to Decimal --
	private static String getDecimal_Bi(String binary) {
		
		if (binary.charAt(0) == '-') {
			return "-" + expandDec_Bi(binary, 1);
		}
		
		return expandDec_Bi(binary, 0);
		

	}
	
	private static String expandDec_Bi(String binary, int limit) {
		Integer decimal = 0;
		char[] decimalArray = binary.toCharArray();
		
		for (int i = binary.length() - 1; i >= limit; i--) {
			int biDigit = decimalArray[i] - '0';
			int decDigit = (int) (biDigit * Math.pow(2, binary.length() - i -1));
			decimal += decDigit;
		}

		return decimal.toString();
	}
	
	// -- Octal to Decimal --
	private static String getDecimal_Oct(String octal) {
		
		if (octal.charAt(0) == '-') {
			return "-" + expandDec_Octal(octal, 1);
		}
		
		return expandDec_Octal(octal, 0);

	}
	
	
	private static String expandDec_Octal(String octal, int limit) {
		OctalToDecimal map = new OctalToDecimal();
		Integer decimal = 0;
		char[] decimalArray = octal.toCharArray();
		
		for (int i = octal.length() - 1; i >= limit; i--) {
			String decEquivalent = map.OCTAL_TO_DECIMAL_MAP.get(Character.toUpperCase(decimalArray[i]));
			if (decEquivalent != null) {
				int octDigit = Integer.parseInt(decEquivalent);
				int decDigit = (int) (octDigit * Math.pow(8, octal.length() - i - 1));
				decimal += decDigit;
			} else {
                // Handle invalid hex digit
                throw new IllegalArgumentException("Invalid hexadecimal digit: " + decimalArray[i]);
            }
			
		}
		return decimal.toString();
	}
	
	// -- Hexadecimal to Decimal --
	private static String getDecimal_Hex(String hex) {
		
		if (hex.charAt(0) == '-') {
			return "-" + expandDec_Hex(hex, 1);
		}
		
		return expandDec_Hex(hex, 0);

	}
	
	private static String expandDec_Hex(String hex, int limit) {
		HexToDecimal map = new HexToDecimal();
		Integer decimal = 0;
		char[] decimalArray = hex.toCharArray();
		
		for (int i = hex.length() - 1; i >= limit; i--) {
			String decEquivalent = map.HEX_TO_DECIMAL_MAP.get(Character.toUpperCase(decimalArray[i]));
			if (decEquivalent != null) {
				int biDigit = Integer.parseInt(decEquivalent);
				int decDigit = (int) (biDigit * Math.pow(16, hex.length() - i - 1));
				decimal += decDigit;
			} else {
                // Handle invalid hex digit
                throw new IllegalArgumentException("Invalid hexadecimal digit: " + decimalArray[i]);
            }
			
		}


		return decimal.toString();
	}
}
