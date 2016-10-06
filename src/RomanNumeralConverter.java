import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class RomanNumeralConverter {

    private static final Map<Integer, String> numeralMap = new LinkedHashMap<Integer, String>();

    static {
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
                }
            }
        }

        return romanNumeral.toString();
    }
}
