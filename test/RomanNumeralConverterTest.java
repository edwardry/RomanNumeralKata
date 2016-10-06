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
    public void whenConvertFromArabicToRomanNumeralIsPassedAValueOfOneHundredOrLess() {
        assertEquals("L", converter.convertFromArabicToRomanNumeral(50));
        assertEquals("C", converter.convertFromArabicToRomanNumeral(100));
        assertEquals("LXXX", converter.convertFromArabicToRomanNumeral(80));
        assertEquals("XCIX", converter.convertFromArabicToRomanNumeral(99));
    }
}
