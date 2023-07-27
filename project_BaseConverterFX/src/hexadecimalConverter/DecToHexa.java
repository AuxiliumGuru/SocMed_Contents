package hexadecimalConverter;

import java.util.HashMap;
import java.util.Map;

public class DecToHexa {
	public final Map<String, Character> DEC_TO_HEX_MAP = createDecToHexMap();

	private static Map<String, Character> createDecToHexMap() {
		Map <String, Character> map = new HashMap<>();
		map.put("0", '0');
		map.put("1", '1');
		map.put("2", '2');
		map.put("3", '3');
		map.put("4", '4');
		map.put("5", '5');
		map.put("6", '6');
		map.put("7", '7');
		map.put("8", '8');
		map.put("9", '9');
		map.put("10", 'A');
		map.put("11", 'B');
		map.put("12", 'C');
		map.put("13", 'D');
		map.put("14", 'E');
		map.put("15", 'F');
		return map;
	}
}
