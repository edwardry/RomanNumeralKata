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
        input = input.toUpperCase();
        String actual = input;

        if(!AllCharactersAreValid(input)) {
            return -1;
        }

        while(!input.isEmpty()) {
            for(Map.Entry<Integer, String> numeralMapEntry : Constants.numeralMap.entrySet()) {
                Integer numeralSegmentArabicValue = numeralMapEntry.getKey();
                String numeralSegment = numeralMapEntry.getValue();
                int numeralSegmentLength = numeralSegment.length();

                if(input.length() < numeralSegmentLength)
                    continue;

                String inputSegment = input.substring(0, numeralSegmentLength);

                if(inputSegment.equals(numeralSegment)) {
                    result += numeralSegmentArabicValue;
                    input = input.replaceFirst(numeralSegment, "");
                    break;
                }
            }
        }

        result = checkIfInputWasValid(actual, result);

        return result;
    }

    // This method checks for RomanNumeral inputs that contain characters outside the allowed characters
    // Returns true if there are invalid characters. Otherwise, returns false
    private static boolean AllCharactersAreValid(String input) {
        Pattern pattern = Pattern.compile("[I|V|X|L|C|D|M]+");
        Matcher matcher = pattern.matcher(input);

        return matcher.matches();
    }

    // This method uses RomanNumeral.valueOf to verify that the Roman Numeral input was valid
    // Returns -1 if the input was invalid. Otherwise, returns result
    private static int checkIfInputWasValid(String actual, int result) {
        String expected = RomanNumeral.valueOf(result);
        if(!actual.equalsIgnoreCase(expected)) {
            result = -1;
        }

        return result;
    }
}
