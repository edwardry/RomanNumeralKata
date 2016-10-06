import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class RomanNumeralConverterTest {
    RomanNumeralConverter converter;

    @Before
    public void setUp() {
        converter = new RomanNumeralConverter();
    }

    @Test
    public void whenConvertFromArabicToRomanNumeralIsPassedOneItReturnsI() {
       assertEquals("I", converter.convertFromArabicToRomanNumeral(1));
    }

    @Test
    public void whenConvertFromArabicToRomanNumeralIsPassedThreeItReturnsIII() {
        assertEquals("III", converter.convertFromArabicToRomanNumeral(3));
    }

    @Test
    public void whenConvertFromArabicToRomanNumeralIsPassedAValueUnderTenThatRequiresNumeralSubtraction() {
        assertEquals("IV", converter.convertFromArabicToRomanNumeral(4));
        assertEquals("IX", converter.convertFromArabicToRomanNumeral(9));
    }

    @Test
    public void whenConvertFromArabicToRomanNumeralIsPassedValuesOfOneHundredOrLess() {
        assertEquals("L", converter.convertFromArabicToRomanNumeral(50));
        assertEquals("C", converter.convertFromArabicToRomanNumeral(100));
        assertEquals("XLVI", converter.convertFromArabicToRomanNumeral(46));
        assertEquals("LXXX", converter.convertFromArabicToRomanNumeral(80));
        assertEquals("XCIX", converter.convertFromArabicToRomanNumeral(99));
    }

    @Test
    public void whenConvertFromArabicToRomanNumeralIsPassedValuesOverOneHundred() {
        assertEquals("D", converter.convertFromArabicToRomanNumeral(500));
        assertEquals("M", converter.convertFromArabicToRomanNumeral(1000));
        assertEquals("CD", converter.convertFromArabicToRomanNumeral(400));
        assertEquals("CM", converter.convertFromArabicToRomanNumeral(900));
        assertEquals("MLXVI", converter.convertFromArabicToRomanNumeral(1066));
        assertEquals("MCMLXXXIX", converter.convertFromArabicToRomanNumeral(1989));
        assertEquals("MMMCDXLIV", converter.convertFromArabicToRomanNumeral(3444));
        assertEquals("MMMCMXCIX", converter.convertFromArabicToRomanNumeral(3999));
    }

    @Test
    public void whenConvertFromArabicToRomanNumeralIsPassedValuesThatAreInvalid() {
        assertEquals("I'm sorry. I don't know how to convert -1046. :(", converter.convertFromArabicToRomanNumeral(-1046));
        assertEquals("I'm sorry. I don't know how to convert 0. :(", converter.convertFromArabicToRomanNumeral(0));
        assertEquals("I'm sorry. I don't know how to convert 4000. :(", converter.convertFromArabicToRomanNumeral(4000));
        assertEquals("I'm sorry. I don't know how to convert 12345. :(", converter.convertFromArabicToRomanNumeral(12345));
    }
}
