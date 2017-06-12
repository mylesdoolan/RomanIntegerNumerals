package bbc.romintnumerals.presenters;

/**
 * Created by Myles Doolan.
 */

public interface RomanPresenter {

    void onRotate(String roman, String integer);

    void onRomanPressed(String value);

    void onEnterPressed();

    void onClearPressed();

}
