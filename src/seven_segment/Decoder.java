package seven_segment;

import java.util.HashMap;
import java.util.Map;

public class Decoder {

    public static String decode(String encrypteLetter) {
        Map<String, String> map = new HashMap<>();
        map.put(" _ | ||_|", "0");
        map.put("     |  |", "1");
        map.put(" _  _||_ ", "2");
        map.put(" _  _| _|", "3");
        map.put("   |_|  |", "4");
        map.put(" _ |_  _|", "5");
        map.put(" _ |_ |_|", "6");
        map.put(" _   |  |", "7");
        map.put(" _ |_||_|", "8");
        map.put(" _ |_| _|", "9");
        map.put("   ___   ", "-");
        map.put("       . ", ".");
        map.put("         ", " ");
        return map.get(encrypteLetter);
    }
}
