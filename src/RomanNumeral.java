import java.util.Map;

public class RomanNumeral {

    public static String valueOf(int input) {
        StringBuilder romanNumeral = new StringBuilder();

        if(input <= Constants.MINIMUM || input >= Constants.MAXIMUM) {
            return "I'm sorry. I don't know how to convert " + input + ". :(";
        }

        while(input > Constants.MINIMUM) {
            for(Map.Entry<Integer, String> numeralMapEntry : Constants.numeralMap.entrySet()) {
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

    public static int toInt(String input) {
        int result = 0;

        while(!input.isEmpty()) {
            for(Map.Entry<Integer, String> numeralMapEntry : Constants.numeralMap.entrySet()) {
                Integer numeralSegmentArabicValue = numeralMapEntry.getKey();
                String numeralSegment = numeralMapEntry.getValue();

                if(input.substring(0, 1).equalsIgnoreCase(numeralSegment)) {
                    result += numeralSegmentArabicValue;
                    input = input.replaceFirst(numeralSegment, "");
                    break;
                }
            }
        }

        return result;
    }
}
