import java.util.LinkedHashMap;
import java.util.Map;

public class RomanNumeral {
    private static final Map<Integer, String> numeralMap = new LinkedHashMap<>();
    private static final int MINIMUM = 0;
    private static final int MAXIMUM = 4000;

    static {
        numeralMap.put(1000, "M");
        numeralMap.put(900, "CM");
        numeralMap.put(500, "D");
        numeralMap.put(400, "CD");
        numeralMap.put(100, "C");
        numeralMap.put(90, "XC");
        numeralMap.put(50, "L");
        numeralMap.put(40, "XL");
        numeralMap.put(10, "X");
        numeralMap.put(9, "IX");
        numeralMap.put(5, "V");
        numeralMap.put(4, "IV");
        numeralMap.put(1, "I");
    }

    public static String valueOf(int input) {
        StringBuilder romanNumeral = new StringBuilder();

        if(input <= MINIMUM || input >= MAXIMUM) {
            return "I'm sorry. I don't know how to convert " + input + ". :(";
        }

        while(input > MINIMUM) {
            for(Map.Entry<Integer, String> numeralMapEntry : numeralMap.entrySet()) {
                Integer numeralSegmentArabicValue = numeralMapEntry.getKey();
                String numeralSegment = numeralMapEntry.getValue();

                if(input >= numeralSegmentArabicValue) {
                    input -= numeralSegmentArabicValue;
                    romanNumeral.append(numeralSegment);
                    break;
                }
            }
        }

        return romanNumeral.toString();
    }
}
