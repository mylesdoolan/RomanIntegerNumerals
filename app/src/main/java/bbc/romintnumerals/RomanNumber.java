package bbc.romintnumerals;

/**
 * Created by Myles Doolan
 * static strings and tree map for converions
 */

import java.util.TreeMap;

public class RomanNumber {

    public static final String ONE = "I";
    public static final String FOUR = "IV";
    public static final String FIVE = "V";
    public static final String NINE = "IX";
    public static final String TEN = "X";
    public static final String FORTY = "XL";
    public static final String FIFTY = "L";
    public static final String NINETY = "XC";
    public static final String HUNDRED = "C";
    public static final String FOUR_HUNDRED = "CD";
    public static final String FIVE_HUNDRED = "D";
    public static final String NINE_HUNDRED = "CM";
    public static final String THOUSAND = "M";

    public final static TreeMap<Integer, String> MAP = new TreeMap<>();

    static {
        MAP.put(1000, THOUSAND);
        MAP.put(900, NINE_HUNDRED);
        MAP.put(500, FIVE_HUNDRED);
        MAP.put(400, FOUR_HUNDRED);
        MAP.put(100, HUNDRED);
        MAP.put(90, NINETY);
        MAP.put(50, FIFTY);
        MAP.put(40, FORTY);
        MAP.put(10, TEN);
        MAP.put(9, NINE);
        MAP.put(5, FIVE);
        MAP.put(4, FOUR);
        MAP.put(1, ONE);
    }
}