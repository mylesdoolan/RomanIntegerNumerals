package bbc.romintnumerals.interactors;

/**
 * Created by Myles Doolan.
 */
public interface RomanInteractor {

    String getIntegerNumeral();

    String getRomanNumeral();

    String resetIntegerNumeral();

    void addToTotal(String value);

    void clearTotal();
}
