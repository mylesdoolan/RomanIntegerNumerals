package bbc.romintnumerals.fragments;

import android.widget.Button;
import android.widget.TextView;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import bbc.romintnumerals.BuildConfig;
import bbc.romintnumerals.R;

import static org.robolectric.shadows.support.v4.SupportFragmentTestUtil.startFragment;

/**
 * Created by Myles Doolan.
 *
 * Test the code inside the RomanFragment class
 */
@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, packageName = "bbc.romintnumerals")
public class RomanFragmentTest extends TestCase {

    private RomanFragment fragment;

    @Before
    public void setUp() throws Exception {
        super.setUp();
        fragment =  new RomanFragment();
        startFragment(fragment);
    }

    @Test
    public void fragmentShouldNotBeNull(){
        assertNotNull(fragment);
    }

    @Test
    public void validateShowRoman() {
        final String SEVEN_ROMAN = "VII";
        TextView numeral = (TextView) fragment.getView().findViewById(R.id.roman_value);
        fragment.showRoman(SEVEN_ROMAN);
        assertEquals(SEVEN_ROMAN, numeral.getText());
    }

    @Test
    public void validateShowInteger() {
        final String SEVEN_ROMAN = "VII";
        TextView roman = (TextView) fragment.getView().findViewById(R.id.roman_converted_value);
        fragment.showInteger(SEVEN_ROMAN);
        assertEquals(SEVEN_ROMAN, roman.getText());
    }

    @Test
    public void validateOnKeyPressed() {
        final String SIX = "VI";
        Button fiveButton = (Button) fragment.getView().findViewById(R.id.roman_five);
        Button oneButton = (Button) fragment.getView().findViewById(R.id.roman_one);
        TextView numeral = (TextView) fragment.getView().findViewById(R.id.roman_value);
        fiveButton.performClick();
        oneButton.performClick();
        assertEquals(SIX, numeral.getText());
    }

    @Test
    public void validateOnClearPressed() {
        final String CLEAR = "";
        final String FIFTY_ROMAN = "L";
        Button fiftyButton = (Button) fragment.getView().findViewById(R.id.roman_fifty);
        Button clearButton = (Button) fragment.getView().findViewById(R.id.roman_clear);
        TextView numeral = (TextView) fragment.getView().findViewById(R.id.roman_value);
        fiftyButton.performClick();
        assertEquals(FIFTY_ROMAN, numeral.getText());
        clearButton.performClick();
        assertEquals(CLEAR, numeral.getText());
    }

    @Test
    public void validateOnEnterPressed() {
        final String ONE_THOUSAND = "1000";
        final String ONE_THOUSAND_ROMAN = "M";
        Button oneThousandButton = (Button) fragment.getView().findViewById(R.id.roman_thousand);
        Button enterButton = (Button) fragment.getView().findViewById(R.id.roman_enter);
        TextView numeral = (TextView) fragment.getView().findViewById(R.id.roman_value);
        TextView roman = (TextView) fragment.getView().findViewById(R.id.roman_converted_value);
        oneThousandButton.performClick();
        assertEquals(ONE_THOUSAND_ROMAN, numeral.getText());
        enterButton.performClick();
        assertEquals(ONE_THOUSAND, roman.getText());
    }

}
