import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class RomanNumeralTest {
    @Test
    public void whenConvertFromArabicToRomanNumeralIsPassedOneItReturnsI() {
       assertEquals("I", RomanNumeral.convertFromArabicToRomanNumeral(1));
    }

    @Test
    public void whenConvertFromArabicToRomanNumeralIsPassedThreeItReturnsIII() {
        assertEquals("III", RomanNumeral.convertFromArabicToRomanNumeral(3));
    }

    @Test
    public void whenConvertFromArabicToRomanNumeralIsPassedAValueUnderTenThatRequiresNumeralSubtraction() {
        assertEquals("IV", RomanNumeral.convertFromArabicToRomanNumeral(4));
        assertEquals("IX", RomanNumeral.convertFromArabicToRomanNumeral(9));
    }

    @Test
    public void whenConvertFromArabicToRomanNumeralIsPassedValuesOfOneHundredOrLess() {
        assertEquals("L", RomanNumeral.convertFromArabicToRomanNumeral(50));
        assertEquals("C", RomanNumeral.convertFromArabicToRomanNumeral(100));
        assertEquals("XLVI", RomanNumeral.convertFromArabicToRomanNumeral(46));
        assertEquals("LXXX", RomanNumeral.convertFromArabicToRomanNumeral(80));
        assertEquals("XCIX", RomanNumeral.convertFromArabicToRomanNumeral(99));
    }

    @Test
    public void whenConvertFromArabicToRomanNumeralIsPassedValuesOverOneHundred() {
        assertEquals("D", RomanNumeral.convertFromArabicToRomanNumeral(500));
        assertEquals("M", RomanNumeral.convertFromArabicToRomanNumeral(1000));
        assertEquals("CD", RomanNumeral.convertFromArabicToRomanNumeral(400));
        assertEquals("CM", RomanNumeral.convertFromArabicToRomanNumeral(900));
        assertEquals("MLXVI", RomanNumeral.convertFromArabicToRomanNumeral(1066));
        assertEquals("MCMLXXXIX", RomanNumeral.convertFromArabicToRomanNumeral(1989));
        assertEquals("MMMCDXLIV", RomanNumeral.convertFromArabicToRomanNumeral(3444));
        assertEquals("MMMCMXCIX", RomanNumeral.convertFromArabicToRomanNumeral(3999));
    }

    @Test
    public void whenConvertFromArabicToRomanNumeralIsPassedValuesThatAreInvalid() {
        assertEquals("I'm sorry. I don't know how to convert -1046. :(", RomanNumeral.convertFromArabicToRomanNumeral(-1046));
        assertEquals("I'm sorry. I don't know how to convert 0. :(", RomanNumeral.convertFromArabicToRomanNumeral(0));
        assertEquals("I'm sorry. I don't know how to convert 4000. :(", RomanNumeral.convertFromArabicToRomanNumeral(4000));
        assertEquals("I'm sorry. I don't know how to convert 12345. :(", RomanNumeral.convertFromArabicToRomanNumeral(12345));
    }
}
