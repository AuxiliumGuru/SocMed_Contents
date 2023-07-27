package baseOperator;


import decimalConverter.Decimal;
import binaryConverter.Binary;
import octalConverter.Octal;
import hexadecimalConverter.HexaDecimal;

public class Compute {

	private static Decimal decFunc = new Decimal();
	private static Integer result;


	public String getResult(String num1, String num2, String ops, String base)  {

		// Base 2
		if (base.equals("Base 2")) {
			if (ops.equals("Add")) {
				return getSumOfBinary(num1, num2);
			} else if (ops.equals("Subtract")) {
				return getDiffOfBinary(num1, num2);
			} else if (ops.equals("Multiply")){
				return getProdOfBinary(num1, num2);			
			} 
		} 

		// Base 8
		else if (base.equals("Base 8")) {
			if (ops.equals("Add")) {
				return getSumOfOctal(num1, num2);
			} else if (ops.equals("Subtract")) {
				return getDiffOfOctal(num1, num2);
			} else if (ops.equals("Multiply")){
				return getProdOfOctal(num1, num2);			
			}
		}
		
		// Base 10
		else if (base.equals("Base 10")) {
			if (ops.equals("Add")) {
				return getSumOfDec(num1, num2);
			} else if (ops.equals("Subtract")) {
				return getDiffOfDec(num1, num2);
			} else if (ops.equals("Multiply")){
				return getProdOfDec(num1, num2);			
			}
		}

		// Base 16
		else if (base.equals("Base 16")){
			if (ops.equals("Add")) {
				return getSumOfHexa(num1, num2);
			} else if (ops.equals("Subtract")) {
				return getDiffOfHexa(num1, num2);
			} else if (ops.equals("Multiply")){
				return getProdOfHexa(num1, num2);			
			}
		}

		return "Invalid Input";
	}


	// ADD
	private static String getSumOfBinary(String num1, String num2) {
		Binary biFunc = new Binary();
		result = Integer.parseInt(decFunc.getDecimal(num1, "bi")) + 
				Integer.parseInt(decFunc.getDecimal(num2, "bi"));

		return biFunc.getBinary(result.toString(), "dec");
	}

	private static String getSumOfOctal(String num1, String num2) {
		Octal octFunc = new Octal();
		result = Integer.parseInt(decFunc.getDecimal(num1, "octal")) +
				Integer.parseInt(decFunc.getDecimal(num2, "octal"));

		return octFunc.getOctal(result.toString(), "dec");
	}

	private static String getSumOfHexa(String num1, String num2) {
		HexaDecimal hexFunc = new HexaDecimal();
		result = Integer.parseInt(decFunc.getDecimal(num1, "hexa")) +
				Integer.parseInt(decFunc.getDecimal(num2, "hexa"));

		return hexFunc.getHex(result.toString(), "dec");

	}

	private static String getSumOfDec(String num1, String num2) {
		result = Integer.parseInt(num1) + Integer.parseInt(num2);

		return result.toString();
	}

	// Multiplication

	private static String getProdOfBinary(String num1, String num2) {
		Binary biFunc = new Binary();
		result = Integer.parseInt(decFunc.getDecimal(num1, "bi")) * 
				Integer.parseInt(decFunc.getDecimal(num2, "bi"));
		return biFunc.getBinary(result.toString(), "dec");
	}

	private static String getProdOfOctal(String num1, String num2) {
		Octal octFunc = new Octal();
		result = Integer.parseInt(decFunc.getDecimal(num1, "octal")) *
				Integer.parseInt(decFunc.getDecimal(num2, "octal"));

		return octFunc.getOctal(result.toString(), "dec");
	}

	private static String getProdOfHexa(String num1, String num2) {
		HexaDecimal hexFunc = new HexaDecimal();
		result = Integer.parseInt(decFunc.getDecimal(num1, "hexa")) *
				Integer.parseInt(decFunc.getDecimal(num2, "hexa"));

		return hexFunc.getHex(result.toString(), "dec");

	}

	private static String getProdOfDec(String num1, String num2) {
		result = Integer.parseInt(num1) * Integer.parseInt(num2);

		return result.toString();
	}


	// Subtraction
	private static String getDiffOfBinary(String num1, String num2) {
		Binary biFunc = new Binary();
		result = Integer.parseInt(decFunc.getDecimal(num1, "bi")) - 
				Integer.parseInt(decFunc.getDecimal(num2, "bi"));
		return biFunc.getBinary(result.toString(), "dec");
	}

	private static String getDiffOfOctal(String num1, String num2) {
		Octal octFunc = new Octal();
		result = Integer.parseInt(decFunc.getDecimal(num1, "octal")) -
				Integer.parseInt(decFunc.getDecimal(num2, "octal"));

		return octFunc.getOctal(result.toString(), "dec");
	}

	private static String getDiffOfHexa(String num1, String num2) {
		HexaDecimal hexFunc = new HexaDecimal();
		result = Integer.parseInt(decFunc.getDecimal(num1, "hexa")) -
				Integer.parseInt(decFunc.getDecimal(num2, "hexa"));

		return hexFunc.getHex(result.toString(), "dec");

	}

	private static String getDiffOfDec(String num1, String num2) {
		result = Integer.parseInt(num1) - Integer.parseInt(num2);

		return result.toString();
	}

	// Division


}
