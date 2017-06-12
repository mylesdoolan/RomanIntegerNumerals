package bbc.romintnumerals.presenters;

import bbc.romintnumerals.views.RomanView;
import bbc.romintnumerals.interactors.RomanInteractor;

/**
 * Created by Myles Doolan.
 *
 * Presenter class for the arabic to roman conversion
 */
public class RomanPresenterLogic implements RomanPresenter {

    private RomanInteractor interactor;
    private RomanView romanView;

    public RomanPresenterLogic(RomanView view, RomanInteractor interactor){
        this.romanView = view;
        this.interactor = interactor;
    }

    @Override public void onRotate(String roman, String integer) {
        interactor.addToTotal(roman);
        romanView.showInteger(integer);
        romanView.showRoman(roman);
    }

    @Override public void onRomanPressed(String value) {
        interactor.addToTotal(value);
        if (romanView != null) {
            romanView.showRoman(interactor.getRomanNumeral());
            romanView.showInteger(interactor.resetIntegerNumeral());
        }

    }

    @Override public void onEnterPressed() {
        if (romanView != null) {
            romanView.showInteger(interactor.getIntegerNumeral());
            romanView.showRoman(interactor.getRomanNumeral());
        }
    }

    @Override public void onClearPressed() {
        interactor.clearTotal();
        if (romanView != null) {
            romanView.showInteger(interactor.getIntegerNumeral());
            romanView.showRoman(interactor.getRomanNumeral());
        }
    }

}
