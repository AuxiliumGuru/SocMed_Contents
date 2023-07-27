package octalConverter;

import java.util.HashMap;
import java.util.Map;

public class DecToOctal {
	
	public final Map<String, Character> DECIMAL_TO_OCTAL_MAP = createDecToOctalMap();

	private static Map<String, Character> createDecToOctalMap() {
		Map <String, Character> map = new HashMap<>();
		map.put("0", '0');
		map.put("1", '1');
		map.put("2", '2');
		map.put("3", '3');
		map.put("4", '4');
		map.put("5", '5');
		map.put("6", '6');
		map.put("7", '7');
		
		return map;
	}
}
