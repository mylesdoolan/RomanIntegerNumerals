package bbc.romintnumerals.presenters;

import bbc.romintnumerals.interactors.IntegerInteractor;
import bbc.romintnumerals.views.IntegerView;

/**
 * Created by Myles Doolan.
 *
 * Presenter class for the arabic to roman conversion
 */
public class IntegerPresenterLogic implements IntegerPresenter {

    private IntegerView integerView;
    private IntegerInteractor interactor;

    public IntegerPresenterLogic(IntegerView integerView, IntegerInteractor interactor) {
        this.integerView = integerView;
        this.interactor = interactor;
    }

    @Override public void onRotate(String roman, String integer) {
        interactor.addToTotal(integer);
        integerView.showInteger(integer);
        integerView.showRoman(roman);
    }

    @Override public void onIntegerPressed(String value) {
        interactor.addToTotal(value);
        if (integerView != null) {
            integerView.showInteger(interactor.getIntegerNumeral());
            integerView.showRoman(interactor.resetRomanNumeral());
        }
    }

    @Override public void onEnterPressed() {
        if (integerView != null) {
            integerView.showInteger(interactor.getIntegerNumeral());
            integerView.showRoman(interactor.getRomanNumeral());
        }
    }

    @Override public void onClearPressed() {
        interactor.clearTotal();
        if (integerView != null) {
            integerView.showInteger(interactor.getIntegerNumeral());
            integerView.showRoman(interactor.getRomanNumeral());
        }
    }
}
