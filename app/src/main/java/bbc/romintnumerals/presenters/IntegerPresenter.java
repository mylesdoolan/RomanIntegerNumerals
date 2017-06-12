package bbc.romintnumerals.presenters;

/**
 * Created by Myles Doolan.
 */

public interface IntegerPresenter {

    void onRotate(String roman, String integer);

    void onIntegerPressed(String value);

    void onEnterPressed();

    void onClearPressed();

}
