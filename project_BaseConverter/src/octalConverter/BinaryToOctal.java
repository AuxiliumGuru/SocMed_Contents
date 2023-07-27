package octalConverter;

import java.util.HashMap;
import java.util.Map;

public class BinaryToOctal {
	
	public final Map<String, Character> BINARY_TO_OCTAL_MAP = createBinaryToOctalMap();

	private static Map<String, Character> createBinaryToOctalMap() {
		Map <String, Character> map = new HashMap<>();
		map.put("000", '0');
		map.put("001", '1');
		map.put("010", '2');
		map.put("011", '3');
		map.put("100", '4');
		map.put("101", '5');
		map.put("110", '6');
		map.put("111", '7');
		return map;
	}
}
