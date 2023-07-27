package decimalConverter;

import java.util.HashMap;
import java.util.Map;

public class OctalToDecimal {
public final Map<Character, String> OCTAL_TO_DECIMAL_MAP = createOctalToDecimalMap();
	
	private static Map<Character, String> createOctalToDecimalMap() {
		Map <Character, String> map = new HashMap<>();
		map.put('0', "0");
		map.put('1', "1");
		map.put('2', "2");
		map.put('3', "3");
		map.put('4', "4");
		map.put('5', "5");
		map.put('6', "6");
		map.put('7', "7");
		return map;
	}
}
