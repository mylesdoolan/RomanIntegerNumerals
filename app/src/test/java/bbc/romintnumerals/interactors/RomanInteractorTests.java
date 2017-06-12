package bbc.romintnumerals.interactors;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Created by Myles Doolan.
 *
 * Test the code inside the RomanInteractorLogic class
 */
@RunWith(MockitoJUnitRunner.class)
public class RomanInteractorTests extends TestCase {

    private final String CLEARED = "";
    private final String ONE = "I";
    private final String INVALID = "invalid";
    private final String TWENTY = "20";
    private RomanInteractorLogic interactorLogic;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        interactorLogic = new RomanInteractorLogic();
    }

    @Test
    public void addToTotalTest() {
        final String TOO_HIGH_VALUE = "MMMM";
        interactorLogic.addToTotal(INVALID);
        assertEquals(CLEARED, interactorLogic.getRomanNumeral());
        interactorLogic.addToTotal(TOO_HIGH_VALUE);
        assertEquals(CLEARED, interactorLogic.getRomanNumeral());
        interactorLogic.addToTotal(ONE);
        assertEquals(ONE, interactorLogic.getRomanNumeral());

    }

    @Test
    public void clearTotal() {
        interactorLogic.addToTotal(ONE);
        assertEquals(ONE, interactorLogic.getRomanNumeral());
        interactorLogic.clearTotal();
        assertEquals(CLEARED, interactorLogic.getRomanNumeral());
    }

    @Test
    public void resetTest() {
        assertEquals(CLEARED, interactorLogic.resetIntegerNumeral());
    }

    @Test
    public void getRomanNumeralTest() {
        final String TWENTY_ROMAN = "XX";
        assertEquals(CLEARED, interactorLogic.getIntegerNumeral());
        interactorLogic.addToTotal(TWENTY_ROMAN);
        assertEquals(TWENTY, interactorLogic.getIntegerNumeral());
    }

    @Test
    public void toRomanTest() {
        final int FIVE = 5;
        final int ONE_HUNDRED_AND_FIFTY_FOUR = 154;
        final int FOUR_HUNDRED_AND_NINETY_NINE = 499;
        final int FIVE_HUNDRED_AND_FORTY_ONE = 541;
        final int NINETEEN_TEN = 1910;
        final String FIVE_ROMAN = "V";
        final String ONE_HUNDRED_AND_FIFTY_FOUR_ROMAN = "CLIV";
        final String FOUR_HUNDRED_AND_NINETY_NINE_ROMAN = "CDXCIX";
        final String FIVE_HUNDRED_AND_FORTY_ONE_ROMAN = "DXLI";
        final String NINETEEN_TEN_ROMAN = "MCMX";
        assertEquals(FIVE, interactorLogic.toInteger(FIVE_ROMAN));
        assertEquals(ONE_HUNDRED_AND_FIFTY_FOUR, interactorLogic.toInteger(ONE_HUNDRED_AND_FIFTY_FOUR_ROMAN));
        assertEquals(FOUR_HUNDRED_AND_NINETY_NINE, interactorLogic.toInteger(FOUR_HUNDRED_AND_NINETY_NINE_ROMAN));
        assertEquals(FIVE_HUNDRED_AND_FORTY_ONE, interactorLogic.toInteger(FIVE_HUNDRED_AND_FORTY_ONE_ROMAN));
        assertEquals(NINETEEN_TEN, interactorLogic.toInteger(NINETEEN_TEN_ROMAN));

    }

    @Test
    public void isRoman() {
        final String TEN_ROMAN = "X";
        assertEquals(false, interactorLogic.isRoman(INVALID));
        assertEquals(false, interactorLogic.isRoman(TWENTY));
        assertEquals(true, interactorLogic.isRoman(TEN_ROMAN));
    }
}