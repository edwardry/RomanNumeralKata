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

    @Test
    public void whenRomanNumeralToIntIsPassedAValueOfIItReturnsOne() {
        assertEquals(1, RomanNumeral.toInt("I"));
    }

    @Test
    public void whenRomanNumeralToIntIsPassedAValueOfVItReturnsFive() {
        assertEquals(5, RomanNumeral.toInt("V"));
    }

    @Test
    public void whenRomanNumeralToIntIsPassedAnInputWithMoreThanOneCharacterResultingInAValueLessThanTen() {
        assertEquals(3, RomanNumeral.toInt("III"));
        assertEquals(6, RomanNumeral.toInt("VI"));
    }

    @Test
    public void whenRomanNumeralToIntIsPassedAnInputThatInvolvesRomanNumeralSubtractionResultingInAValueLessThanTen() {
        assertEquals(4, RomanNumeral.toInt("IV"));
        assertEquals(9, RomanNumeral.toInt("IX"));
    }

    @Test
    public void whenRomanNumeralToIntIsPassedAnyInputResultingInAValueOfOneHundredOrLess() {
        assertEquals(14, RomanNumeral.toInt("XIV"));
        assertEquals(49, RomanNumeral.toInt("XLIX"));
        assertEquals(50, RomanNumeral.toInt("L"));
        assertEquals(66, RomanNumeral.toInt("LXVI"));
        assertEquals(94, RomanNumeral.toInt("XCIV"));
        assertEquals(100, RomanNumeral.toInt("C"));
    }

    @Test
    public void whenRomanNumeralToIntIsPassedAnyInputResultingInAValueOfMoreThanOneHundred() {
        assertEquals(500, RomanNumeral.toInt("D"));
        assertEquals(1000, RomanNumeral.toInt("M"));
        assertEquals(400, RomanNumeral.toInt("CD"));
        assertEquals(900, RomanNumeral.toInt("CM"));
        assertEquals(1066, RomanNumeral.toInt("MLXVI"));
        assertEquals(1989, RomanNumeral.toInt("MCMLXXXIX"));
        assertEquals(3444, RomanNumeral.toInt("MMMCDXLIV"));
        assertEquals(3999, RomanNumeral.toInt("MMMCMXCIX"));
    }

    @Test
    public void whenRomanNumeralToIntIsPassedAsInputToValueOfRomanNumeralAndViceVersa() {
        int arabicInput = RomanNumeral.toInt("MMMCMXCIX");
        String romanNumeralInput = RomanNumeral.valueOf(3999);

        assertEquals("MMMCMXCIX", RomanNumeral.valueOf(arabicInput));
        assertEquals(3999, RomanNumeral.toInt(romanNumeralInput));
    }

    @Test
    public void whenRomanNumeralToIntIsPassedAnEmptyString() {
        assertEquals(-1, RomanNumeral.toInt(""));
    }

    @Test
    public void whenRomanNumeralToIntIsPassedFourOfEitherIXCMInARow() {
        assertEquals(-1, RomanNumeral.toInt("IIII"));
        assertEquals(-1, RomanNumeral.toInt("XXXX"));
        assertEquals(-1, RomanNumeral.toInt("CCCC"));
        assertEquals(-1, RomanNumeral.toInt("MMMM"));
        assertEquals(-1, RomanNumeral.toInt("MMXXXIIII"));
    }

    @Test
    public void whenRomanNumeralToIntIsPassedTwoOfEitherVLDInARow() {
        assertEquals(-1, RomanNumeral.toInt("VV"));
        assertEquals(-1, RomanNumeral.toInt("LL"));
        assertEquals(-1, RomanNumeral.toInt("DD"));
        assertEquals(-1, RomanNumeral.toInt("LLXXV"));
        assertEquals(-1, RomanNumeral.toInt("XXVVII"));
    }

    @Test
    public void whenRomanNumeralToIntIsPassedInputWithInvalidSubtractions() {
        assertEquals(-1, RomanNumeral.toInt("IIV"));
        assertEquals(-1, RomanNumeral.toInt("XXC"));
        assertEquals(-1, RomanNumeral.toInt("IVX"));
        assertEquals(-1, RomanNumeral.toInt("CCDM"));
        assertEquals(-1, RomanNumeral.toInt("IVXLCDM"));
    }
}