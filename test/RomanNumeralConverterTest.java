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
    public void whenRomanNumeralConverterIsPassedOneItReturnsI() {
       assertEquals("I", converter.convertFromArabicToRomanNumeral(1));
    }
}
