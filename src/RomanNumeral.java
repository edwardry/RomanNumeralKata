import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        String actual = input;

        while(!input.isEmpty()) {
            for(Map.Entry<Integer, String> numeralMapEntry : Constants.numeralMap.entrySet()) {
                Integer numeralSegmentArabicValue = numeralMapEntry.getKey();
                String numeralSegment = numeralMapEntry.getValue();
                int numeralSegmentLength = numeralSegment.length();

                if(input.length() < numeralSegmentLength)
                    continue;

                String inputSegment = input.substring(0, numeralSegmentLength);

                if(inputSegment.equalsIgnoreCase(numeralSegment)) {
                    result += numeralSegmentArabicValue;
                    input = input.replaceFirst(numeralSegment, "");
                    break;
                }
            }
        }

        // The below logic uses RomanNumeral.valueOf to verify that the Roman Numeral input is valid
        String expectedResult = RomanNumeral.valueOf(result);
        if(!actual.equalsIgnoreCase(expectedResult)) {
            result = -1;
        }

        return result;
    }

    private static boolean isRomanNumeralInvalid(String input) {
        boolean invalid = false;

        if(input.isEmpty()) {
            invalid = true;
        } else if(input.contains("IIII") || input.contains("XXXX") || input.contains("CCCC") || input.contains("MMMM")) {
            invalid = true;
        } else if(input.contains("VV") || input.contains("LL") || input.contains("DD")) {
            invalid = true;
        }

        return invalid;
    }
}
