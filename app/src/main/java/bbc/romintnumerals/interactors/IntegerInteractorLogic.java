package bbc.romintnumerals.interactors;

import static bbc.romintnumerals.RomanNumber.MAP;

/**
 * Created by Myles Doolan
 *
 * Arabic conversion to roman logic
 */
public class IntegerInteractorLogic implements IntegerInteractor {

    private String integerInput = "";

    @Override
    public String getIntegerNumeral() {
        return integerInput;
    }

    @Override
    public String getRomanNumeral() {
        if (integerInput.equals("")) {
            return integerInput;
        }
        return toRoman(Integer.parseInt(integerInput));
    }

    @Override
    public String resetRomanNumeral() {
        return "";
    }

    @Override
    public void addToTotal(String value) {
        if (!value.equals("")) {
            if (Integer.parseInt(integerInput.concat(value)) > 0 && Integer.parseInt(integerInput.concat(value)) < 4000) {
                integerInput = integerInput.concat(value);
            }
        }
    }

    @Override
    public void clearTotal() {
        integerInput = "";
    }

    /**
     * A recursive method converts the integer value to its roman numeral.
     * The tree maps compare function will find the numbers nearest value in the map if not equal, and  then make a recursive call.
     * If the number is an exact match then the roman value is returned.
     * @param number - the input to be converted
     * @return the roman value of the number
     **/
    String toRoman(int number) {
        int key = MAP.floorKey(number);
        if (number == key) {
            return MAP.get(key);
        }
        return MAP.get(key) + toRoman(number - key);
    }
}