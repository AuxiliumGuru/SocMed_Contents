package decimalConverter;

import java.util.HashMap;
import java.util.Map;

public class HexToDecimal {
	public final Map<Character, String> HEX_TO_DECIMAL_MAP = createHexToDecimalMap();
	
	private static Map<Character, String> createHexToDecimalMap() {
		Map <Character, String> map = new HashMap<>();
		map.put('0', "0");
		map.put('1', "1");
		map.put('2', "2");
		map.put('3', "3");
		map.put('4', "4");
		map.put('5', "5");
		map.put('6', "6");
		map.put('7', "7");
		map.put('8', "8");
		map.put('9', "9");
		map.put('A', "10");
		map.put('B', "11");
		map.put('C', "12");
		map.put('D', "13");
		map.put('E', "14");
		map.put('F', "15");
		return map;
	}
}
