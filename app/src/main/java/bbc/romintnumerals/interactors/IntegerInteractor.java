package bbc.romintnumerals.interactors;

/**
 * Created by Myles Doolan.
 */
public interface IntegerInteractor {

    String getIntegerNumeral();

    String getRomanNumeral();

    String resetRomanNumeral();

    void addToTotal(String value);

    void clearTotal();

}
