package bbc.romintnumerals.interactors;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import bbc.romintnumerals.presenters.IntegerPresenterLogic;
import bbc.romintnumerals.views.IntegerView;

import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Created by Myles Doolan.
 *
 * Test the code inside the IntegerInteractorLogic class
 */
@RunWith(MockitoJUnitRunner.class)
public class IntegerInteractorTests extends TestCase {

    private final String CLEARED = "";
    final String ONE = "1";
    private IntegerInteractorLogic interactorLogic;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        interactorLogic = new IntegerInteractorLogic();
    }

    @Test
    public void addToTotalTest() {
        final String TOO_LOW_VALUE = "0";
        final String TOO_HIGH_VALUE = "4000";

        interactorLogic.addToTotal(TOO_LOW_VALUE);
        assertEquals(CLEARED, interactorLogic.getIntegerNumeral());
        interactorLogic.addToTotal(TOO_HIGH_VALUE);
        assertEquals(CLEARED, interactorLogic.getIntegerNumeral());
        interactorLogic.addToTotal(ONE);
        assertEquals(ONE, interactorLogic.getIntegerNumeral());

    }

    @Test
    public void clearTotal() {
        interactorLogic.addToTotal(ONE);
        assertEquals(ONE, interactorLogic.getIntegerNumeral());
        interactorLogic.clearTotal();
        assertEquals(CLEARED, interactorLogic.getIntegerNumeral());
    }

    @Test
    public void resetTest() {
        assertEquals(CLEARED, interactorLogic.resetRomanNumeral());
    }

    @Test
    public void getRomanNumeralTest() {
        final String TWENTY = "20";
        final String TWENTY_ROMAN = "XX";
        assertEquals(CLEARED, interactorLogic.getRomanNumeral());
        interactorLogic.addToTotal(TWENTY);
        assertEquals(TWENTY_ROMAN, interactorLogic.getRomanNumeral());
    }

    @Test
    public void toRomanTest() {
        final int TEN = 10;
        final String TEN_ROMAN = "X";
        assertEquals(TEN_ROMAN, interactorLogic.toRoman(TEN));
        final int NINETEEN_TEN = 1910;
        final String NINETEEN_TEN_ROMAN = "MCMX";
        assertEquals(NINETEEN_TEN_ROMAN, interactorLogic.toRoman(NINETEEN_TEN));
    }
}