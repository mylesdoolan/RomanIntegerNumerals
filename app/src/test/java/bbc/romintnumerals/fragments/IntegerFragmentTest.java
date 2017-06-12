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
 * Test the code inside the IntegerFragment class
 */
@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, packageName = "bbc.romintnumerals")
public class IntegerFragmentTest extends TestCase {


    private IntegerFragment fragment;

    @Before
    public void setUp() throws Exception {
        super.setUp();
        fragment =  new IntegerFragment();
        startFragment(fragment);
    }

    @Test
    public void fragmentShouldNotBeNull(){
        assertNotNull(fragment);
    }


    @Test
    public void validateShowInteger() {
        final String NINE = "9";
        TextView numeral = (TextView) fragment.getView().findViewById(R.id.integer_value);
        fragment.showInteger(NINE);
        assertEquals(NINE, numeral.getText());
    }

    @Test
    public void validateShowRoman() {
        final String NINE = "9";
        TextView roman = (TextView) fragment.getView().findViewById(R.id.integer_converted_value);
        fragment.showRoman(NINE);
        assertEquals(NINE, roman.getText());
    }

    @Test
    public void validateOnKeyPressed() {
        final String THREE = "3";
        Button threeButton = (Button) fragment.getView().findViewById(R.id.integer_three);
        TextView numeral = (TextView) fragment.getView().findViewById(R.id.integer_value);
        threeButton.performClick();
        assertEquals(THREE, numeral.getText());
    }

    @Test
    public void validateOnClearPressed() {
        final String CLEAR = "";
        final String THREE = "3";
        Button threeButton = (Button) fragment.getView().findViewById(R.id.integer_three);
        Button clearButton = (Button) fragment.getView().findViewById(R.id.integer_clear);
        TextView numeral = (TextView) fragment.getView().findViewById(R.id.integer_value);
        threeButton.performClick();
        assertEquals(THREE, numeral.getText());
        clearButton.performClick();
        assertEquals(CLEAR, numeral.getText());
    }

    @Test
    public void validateOnEnterPressed() {
        final String THREE = "3";
        final String THREE_ROMAN = "III";
        Button threeButton = (Button) fragment.getView().findViewById(R.id.integer_three);
        Button enterButton = (Button) fragment.getView().findViewById(R.id.integer_enter);
        TextView numeral = (TextView) fragment.getView().findViewById(R.id.integer_value);
        TextView roman = (TextView) fragment.getView().findViewById(R.id.integer_converted_value);
        threeButton.performClick();
        assertEquals(THREE, numeral.getText());
        enterButton.performClick();
        assertEquals(THREE_ROMAN, roman.getText());
    }
}
