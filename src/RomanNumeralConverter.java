import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class RomanNumeralConverter {

    private static final Map<Integer, String> numeralMap = new LinkedHashMap<Integer, String>();

    static {
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

    public String convertFromArabicToRomanNumeral(Integer inputNumber) {
        StringBuilder romanNumeral = new StringBuilder();

        while(inputNumber != 0) {
            for(Map.Entry<Integer, String> numeralMapEntry : numeralMap.entrySet()) {
                Integer numeralSegmentArabicValue = numeralMapEntry.getKey();
                String numeralSegment = numeralMapEntry.getValue();

                if(inputNumber >= numeralSegmentArabicValue) {
                    inputNumber -= numeralSegmentArabicValue;
                    romanNumeral.append(numeralSegment);
                    break;
                }
            }
        }

        return romanNumeral.toString();
    }
}
