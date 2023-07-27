package ansConvert;
import binaryConverter.Binary;
import decimalConverter.Decimal;
import hexadecimalConverter.HexaDecimal;
import octalConverter.Octal;


public class Convert {
	private Binary bi = new Binary();
	private Octal oct = new Octal();
	private Decimal dec = new Decimal();
	private HexaDecimal hexa = new HexaDecimal();
	
	
	public String convert(String num, String toB, String fromB) {
		
		
		// -- Binary Converter --
		if (toB.equals("Base 2") && fromB.equals("Base 8")) {
			return bi.getBinary(num, "octal");
		} else if (toB.equals("Base 2") && fromB.equals("Base 10")) {
			return bi.getBinary(num, "dec");
		} else if (toB.equals("Base 2") && fromB.equals("Base 16")) {
			return bi.getBinary(num, "hexa");
		} 
		
		// -- Octal Converter --
		
		else if (toB.equals("Base 8") && fromB.equals("Base 2")) {
			return oct.getOctal(num, "bi");
		} else if (toB.equals("Base 8") && fromB.equals("Base 10")) {
			return oct.getOctal(num, "dec");
		} else if (toB.equals("Base 8") && fromB.equals("Base 16")) {
			return oct.getOctal(num, "hexa");
		} 
		
		// -- Decimal Converter --
		
		else if (toB.equals("Base 10") && fromB.equals("Base 2")) {
			return dec.getDecimal(num, "bi");
		} else if (toB.equals("Base 10") && fromB.equals("Base 8")) {
			return dec.getDecimal(num, "octal");
		} else if (toB.equals("Base 10") && fromB.equals("Base 16")) {
			return dec.getDecimal(num, "hexa");
		} 
		
		// -- HexaDecimal Converter --
		
		else if (toB.equals("Base 16") && fromB.equals("Base 2")) {
			return hexa.getHex(num, "bi");
		} else if (toB.equals("Base 16") && fromB.equals("Base 8")) {
			return hexa.getHex(num, "octal");
		} else if (toB.equals("Base 16") && fromB.equals("Base 10")) {
			return hexa.getHex(num, "dec");
		} 
		
		else {
			return "Invalid Input";
		}
		
	}
}
