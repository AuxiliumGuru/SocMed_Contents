package binaryConverter;

import java.util.HashMap;
import java.util.Map;

public class OctalToBinary {
	
	public final Map<Character, String> OCTAL_TO_BINARY_MAP = createOctalToBinaryMap();

	private static Map<Character, String> createOctalToBinaryMap() {
		Map <Character, String> map = new HashMap<>();
		map.put('0', "000");
		map.put('1', "001");
		map.put('2', "010");
		map.put('3', "011");
		map.put('4', "100");
		map.put('5', "101");
		map.put('6', "110");
		map.put('7', "111");
		return map;
	}
}
