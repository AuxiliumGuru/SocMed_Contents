package baseOperator;
import decimalConverter.Decimal;
import binaryConverter.Binary;
import octalConverter.Octal;
import hexadecimalConverter.HexaDecimal;

public class Compute {
	
	private static Decimal decFunc = new Decimal();
	private static Integer sum;

	
	public String getResult(String num1, String num2, String ops, String base)  {

		if (base.equals("base 2")) {
			if (ops.equals("+")) {
				return getSumOfBinary(num1, num2);
			} else if (ops.equals("-")) {
				return getDiffOfBinary(num1, num2);
			} else {
				return getProdOfBinary(num1, num2);			
			} 
		}
		else if (base.equals("base 8")) {
			if (ops.equals("+")) {
				return getSumOfOctal(num1, num2);
			} else if (ops.equals("-")) {
				return getDiffOfOctal(num1, num2);
			} else {
				return getProdOfOctal(num1, num2);			
			}
		}
		//	else if (base.equals("base 10")) }{
		//			if (ops.equals("+")) {
		//				return getSumOfOctal(num1, num2);
		//			} else if (ops.equals("-")) {
		//				return getDiffOfOctal(num1, num2);
		//			} else {
		//				return getProdOfOctal(num1, num2);			
		//			}
		//}
		else {
			if (ops.equals("+")) {
				return getSumOfHexa(num1, num2);
			} else if (ops.equals("-")) {
				return getDiffOfHexa(num1, num2);
			} else {
				return getProdOfHexa(num1, num2);			
			}
		}
	}


	// ADD
	private static String getSumOfBinary(String num1, String num2) {
		Binary biFunc = new Binary();
		sum = Integer.parseInt(decFunc.getDecimal(num1, "bi")) + 
				Integer.parseInt(decFunc.getDecimal(num2, "bi"));

		return biFunc.getBinary(sum.toString(), "dec");
	}

	private static String getSumOfOctal(String num1, String num2) {
		Octal octFunc = new Octal();
		sum = Integer.parseInt(decFunc.getDecimal(num1, "octal")) +
				Integer.parseInt(decFunc.getDecimal(num2, "octal"));

		return octFunc.getOctal(sum.toString(), "dec");
	}

	private static String getSumOfHexa(String num1, String num2) {
		HexaDecimal hexFunc = new HexaDecimal();
		sum = Integer.parseInt(decFunc.getDecimal(num1, "hexa")) +
				Integer.parseInt(decFunc.getDecimal(num2, "hexa"));

		return hexFunc.getHex(sum.toString(), "dec");

	}

	// Multiplication

	private static String getProdOfBinary(String num1, String num2) {
		Binary biFunc = new Binary();
		sum = Integer.parseInt(decFunc.getDecimal(num1, "bi")) * 
				Integer.parseInt(decFunc.getDecimal(num2, "bi"));
		return biFunc.getBinary(sum.toString(), "dec");
	}

	private static String getProdOfOctal(String num1, String num2) {
		Octal octFunc = new Octal();
		sum = Integer.parseInt(decFunc.getDecimal(num1, "octal")) *
				Integer.parseInt(decFunc.getDecimal(num2, "octal"));

		return octFunc.getOctal(sum.toString(), "dec");
	}

	private static String getProdOfHexa(String num1, String num2) {
		HexaDecimal hexFunc = new HexaDecimal();
		sum = Integer.parseInt(decFunc.getDecimal(num1, "hexa")) *
				Integer.parseInt(decFunc.getDecimal(num2, "hexa"));

		return hexFunc.getHex(sum.toString(), "dec");

	}


	// Subtraction
	private static String getDiffOfBinary(String num1, String num2) {
		Binary biFunc = new Binary();
		sum = Integer.parseInt(decFunc.getDecimal(num1, "bi")) - 
				Integer.parseInt(decFunc.getDecimal(num2, "bi"));
		return biFunc.getBinary(sum.toString(), "dec");
	}

	private static String getDiffOfOctal(String num1, String num2) {
		Octal octFunc = new Octal();
		sum = Integer.parseInt(decFunc.getDecimal(num1, "octal")) -
				Integer.parseInt(decFunc.getDecimal(num2, "octal"));

		return octFunc.getOctal(sum.toString(), "dec");
	}

	private static String getDiffOfHexa(String num1, String num2) {
		HexaDecimal hexFunc = new HexaDecimal();
		sum = Integer.parseInt(decFunc.getDecimal(num1, "hexa")) -
				Integer.parseInt(decFunc.getDecimal(num2, "hexa"));

		return hexFunc.getHex(sum.toString(), "dec");

	}


}
