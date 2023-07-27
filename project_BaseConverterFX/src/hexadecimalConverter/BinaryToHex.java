package hexadecimalConverter;

import java.util.HashMap;
import java.util.Map;

public class BinaryToHex {
	public final Map<String, Character> BI_TO_HEX_MAP = createBiToHexMap();

	private static Map<String, Character> createBiToHexMap() {
		Map <String, Character> map = new HashMap<>();
		map.put("0000", '0');
		map.put("0001", '1');
		map.put("0010", '2');
		map.put("0011", '3');
		map.put("0100", '4');
		map.put("0101", '5');
		map.put("0110", '6');
		map.put("0111", '7');
		map.put("1000", '8');
		map.put("1001", '9');
		map.put("1010", 'A');
		map.put("1011", 'B');
		map.put("1100", 'C');
		map.put("1101", 'D');
		map.put("1110", 'E');
		map.put("1111", 'F');
		return map;
	}
}
