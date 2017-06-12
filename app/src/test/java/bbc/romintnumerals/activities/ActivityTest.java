package bbc.romintnumerals.activities;

import android.widget.Button;
import android.widget.TextView;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import bbc.romintnumerals.BuildConfig;
import bbc.romintnumerals.R;

/**
 * Created by Myles Doolan.
 * Tests for the activity
 */
@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, packageName = "bbc.romintnumerals")
public class ActivityTest extends TestCase {

    private MainActivity activity;
    private Button integerClear;
    private Button romanClear;

    @Before
    public void setUp() throws Exception {
        super.setUp();
        activity =  Robolectric.buildActivity(MainActivity.class).create().start().visible().get();
        integerClear = (Button) activity.findViewById(R.id.integer_clear);
        romanClear = (Button) activity.findViewById(R.id.roman_clear);
    }

    @Test
    public void activityShouldNotBeNull(){
        assertNotNull(activity);
    }

    @Test
    public void validateArabicConversionTabText() {
        final String ARABIC_TO_ROMAN_HEADER_TEXT = "Int > Rom";
        String title = activity.viewPager.getAdapter().getPageTitle(0).toString();
        assertEquals(ARABIC_TO_ROMAN_HEADER_TEXT, title);
    }

    @Test
    public void validateRomanConversionTabText() {
        final String ARABIC_TO_ROMAN_HEADER_TEXT = "Rom > Int";
        String title = activity.viewPager.getAdapter().getPageTitle(1).toString();
        assertEquals(ARABIC_TO_ROMAN_HEADER_TEXT, title);
    }

    @Test
    public void validateRomanConversionHeaderTextView() {
        final String ROMAN_TO_ARABIC_HEADER_TEXT = "Convert roman numerals into arabic numbers";
        TextView header = (TextView) activity.findViewById(R.id.roman_header);
        assertEquals(ROMAN_TO_ARABIC_HEADER_TEXT, header.getText());
    }

    @Test
    public void validateArabicConversionHeaderTextView() {
        final String ARABIC_TO_ROMAN_HEADER_TEXT = "Convert arabic numbers into roman numerals";
        TextView header = (TextView) activity.findViewById(R.id.integer_header);
        assertEquals(ARABIC_TO_ROMAN_HEADER_TEXT, header.getText());
    }

    @Test
    public void validateIntegerFragment() {
        final String VALUE = "1";
        TextView numeral = (TextView) activity.findViewById(R.id.integer_value);
        Button one = (Button) activity.findViewById(R.id.integer_one);
        one.performClick();
        assertEquals(VALUE, numeral.getText());
        integerClear.performClick();
    }

    @Test
    public void validateAdditionIntegerFragment() {
        final String VALUE = "12";
        TextView numeral = (TextView) activity.findViewById(R.id.integer_value);
        Button one = (Button) activity.findViewById(R.id.integer_one);
        Button two = (Button) activity.findViewById(R.id.integer_two);
        one.performClick();
        two.performClick();
        assertEquals(VALUE, numeral.getText());
        integerClear.performClick();
    }

    @Test
    public void validateConvertArabicToRoman() {
        final String VALUE = "XII";
        TextView value = (TextView) activity.findViewById(R.id.integer_converted_value);
        Button enter = (Button) activity.findViewById(R.id.integer_enter);
        Button one = (Button) activity.findViewById(R.id.integer_one);
        Button two = (Button) activity.findViewById(R.id.integer_two);
        one.performClick();
        two.performClick();
        enter.performClick();
        assertEquals(VALUE, value.getText());
        integerClear.performClick();
    }

    @Test
    public void validateArabicClear() {
        final String VALUE = "";
        TextView value = (TextView) activity.findViewById(R.id.integer_converted_value);
        Button enter = (Button) activity.findViewById(R.id.integer_enter);
        Button one = (Button) activity.findViewById(R.id.integer_one);
        Button two = (Button) activity.findViewById(R.id.integer_two);
        one.performClick();
        two.performClick();
        enter.performClick();
        integerClear.performClick();
        assertEquals(VALUE, value.getText());
    }

    @Test
    public void validateRomanButton() {
        final String VALUE = "X";
        TextView numeral = (TextView) activity.findViewById(R.id.roman_value);
        Button one = (Button) activity.findViewById(R.id.roman_ten);
        one.performClick();
        assertEquals(VALUE, numeral.getText());
        romanClear.performClick();
    }

    @Test
    public void validateAdditionRomanFragment() {
        final String VALUE = "II";
        TextView numeral = (TextView) activity.findViewById(R.id.roman_value);
        Button one = (Button) activity.findViewById(R.id.roman_one);
        one.performClick();
        one.performClick();
        assertEquals(VALUE, numeral.getText());
        romanClear.performClick();
    }

    @Test
    public void validateConvertRomanToArabic() {
        final String VALUE = "12";
        TextView value = (TextView) activity.findViewById(R.id.roman_converted_value);
        Button enter = (Button) activity.findViewById(R.id.roman_enter);
        Button ten = (Button) activity.findViewById(R.id.roman_ten);
        Button one = (Button) activity.findViewById(R.id.roman_one);
        ten.performClick();
        one.performClick();
        one.performClick();
        enter.performClick();
        assertEquals(VALUE, value.getText());
        romanClear.performClick();
    }

    @Test
    public void validateRomanClear() {
        final String VALUE = "";
        TextView value = (TextView) activity.findViewById(R.id.roman_converted_value);
        Button enter = (Button) activity.findViewById(R.id.roman_enter);
        Button ten = (Button) activity.findViewById(R.id.roman_ten);
        Button one = (Button) activity.findViewById(R.id.roman_one);
        ten.performClick();
        one.performClick();
        one.performClick();
        enter.performClick();
        romanClear.performClick();
        assertEquals(VALUE, value.getText());
    }
}
