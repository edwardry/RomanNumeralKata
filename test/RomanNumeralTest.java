import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class RomanNumeralTest {
    @Test
    public void whenValueOfRomanNumeralIsPassedOneItReturnsI() {
       assertEquals("I", RomanNumeral.valueOf(1));
    }

    @Test
    public void whenValueOfRomanNumeralIsPassedThreeItReturnsIII() {
        assertEquals("III", RomanNumeral.valueOf(3));
    }

    @Test
    public void whenValueOfRomanNumeralIsPassedAValueUnderTenThatRequiresNumeralSubtraction() {
        assertEquals("IV", RomanNumeral.valueOf(4));
        assertEquals("IX", RomanNumeral.valueOf(9));
    }

    @Test
    public void whenValueOfRomanNumeralIsPassedValuesOfOneHundredOrLess() {
        assertEquals("L", RomanNumeral.valueOf(50));
        assertEquals("C", RomanNumeral.valueOf(100));
        assertEquals("XLVI", RomanNumeral.valueOf(46));
        assertEquals("LXXX", RomanNumeral.valueOf(80));
        assertEquals("XCIX", RomanNumeral.valueOf(99));
    }

    @Test
    public void whenValueOfRomanNumeralIsPassedValuesOverOneHundred() {
        assertEquals("D", RomanNumeral.valueOf(500));
        assertEquals("M", RomanNumeral.valueOf(1000));
        assertEquals("CD", RomanNumeral.valueOf(400));
        assertEquals("CM", RomanNumeral.valueOf(900));
        assertEquals("MLXVI", RomanNumeral.valueOf(1066));
        assertEquals("MCMLXXXIX", RomanNumeral.valueOf(1989));
        assertEquals("MMMCDXLIV", RomanNumeral.valueOf(3444));
        assertEquals("MMMCMXCIX", RomanNumeral.valueOf(3999));
    }

    @Test
    public void whenValueOfRomanNumeralIsPassedValuesThatAreInvalid() {
        assertEquals("I'm sorry. I don't know how to convert -1046. :(", RomanNumeral.valueOf(-1046));
        assertEquals("I'm sorry. I don't know how to convert 0. :(", RomanNumeral.valueOf(0));
        assertEquals("I'm sorry. I don't know how to convert 4000. :(", RomanNumeral.valueOf(4000));
        assertEquals("I'm sorry. I don't know how to convert 12345. :(", RomanNumeral.valueOf(12345));
    }
}
