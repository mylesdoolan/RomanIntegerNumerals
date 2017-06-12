package bbc.romintnumerals.interactors;


import static bbc.romintnumerals.RomanNumber.FIFTY;
import static bbc.romintnumerals.RomanNumber.FIVE;
import static bbc.romintnumerals.RomanNumber.FIVE_HUNDRED;
import static bbc.romintnumerals.RomanNumber.FORTY;
import static bbc.romintnumerals.RomanNumber.FOUR;
import static bbc.romintnumerals.RomanNumber.FOUR_HUNDRED;
import static bbc.romintnumerals.RomanNumber.HUNDRED;
import static bbc.romintnumerals.RomanNumber.NINE;
import static bbc.romintnumerals.RomanNumber.NINETY;
import static bbc.romintnumerals.RomanNumber.NINE_HUNDRED;
import static bbc.romintnumerals.RomanNumber.ONE;
import static bbc.romintnumerals.RomanNumber.TEN;
import static bbc.romintnumerals.RomanNumber.THOUSAND;

/**
 * Created by Myles Doolan.
 *
 * Roman conversion to arabic logic
 **/
public class RomanInteractorLogic implements RomanInteractor {
    private String romanInput = "";

    @Override
    public void addToTotal(String value) {
        if (isRoman(romanInput.concat(value)) && toInteger(romanInput.concat(value)) < 4000) {
            romanInput = romanInput.concat(value);
        }
    }

    @Override
    public String getRomanNumeral() {
        return romanInput;
    }

    @Override
    public String getIntegerNumeral() {
        if (romanInput.equals("")) {
            return "";
        }
        return Integer.toString(toInteger(romanInput));
    }

    @Override
    public void clearTotal() {
        romanInput = "";
    }

    @Override
    public String resetIntegerNumeral() {
        return "";
    }

    /**
     * A recursive method converts the roman numeral to its arabic value.
     * It removes the characters representing the number in each condition and adds its arabic value to the int that is returned
     * @param number - the input to be converted
     * @return the arabic value of the number
     **/
    int toInteger(String number) {
        if (number.startsWith(THOUSAND)) {
            return 1000 + toInteger(number.substring(1, number.length()));
        }
        if (number.startsWith(NINE_HUNDRED)) {
            return 900 + toInteger(number.substring(2, number.length()));
        }
        if (number.startsWith(FIVE_HUNDRED)) {
            return 500 + toInteger(number.substring(1, number.length()));
        }
        if (number.startsWith(FOUR_HUNDRED)) {
            return 400 + toInteger(number.substring(2, number.length()));
        }
        if (number.startsWith(HUNDRED)) {
            return 100 + toInteger(number.substring(1, number.length()));
        }
        if (number.startsWith(NINETY)) {
            return 90 + toInteger(number.substring(2, number.length()));
        }
        if (number.startsWith(FIFTY)) {
            return 50 + toInteger(number.substring(1, number.length()));
        }
        if (number.startsWith(FORTY)) {
            return 40 + toInteger(number.substring(2, number.length()));
        }
        if (number.startsWith(TEN)) {
            return 10 + toInteger(number.substring(1, number.length()));
        }
        if (number.startsWith(NINE)) {
            return 9 + toInteger(number.substring(2, number.length()));
        }
        if (number.startsWith(FIVE)) {
            return 5 + toInteger(number.substring(1, number.length()));
        }
        if (number.startsWith(FOUR)) {
            return 4 + toInteger(number.substring(2, number.length()));
        }
        if (number.startsWith(ONE)) {
            return 1 + toInteger(number.substring(1, number.length()));
        } else {
            return 0;
        }
    }

    /**
     * Using a regular expression, each inputted value in the Roman numeral converter tab
     * is checked to see if it the next letter added will be a valid roman numeral.
     **/
    boolean isRoman(String number) {
        String romanRegex = "^M{0,4}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$";
        return number.matches(romanRegex);
    }
}