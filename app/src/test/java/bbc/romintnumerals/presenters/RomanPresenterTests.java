package bbc.romintnumerals.presenters;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import bbc.romintnumerals.interactors.RomanInteractor;
import bbc.romintnumerals.presenters.RomanPresenterLogic;
import bbc.romintnumerals.views.RomanView;

import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentCaptor.forClass;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Created by Myles Doolan on 11/06/2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class RomanPresenterTests {


    @Mock
    RomanInteractor romanInteractor;
    @Mock
    RomanView romanView;

    private RomanPresenterLogic presenter;

    @Before
    public void setUp() throws Exception {
        presenter = new RomanPresenterLogic(romanView, romanInteractor);
    }

    @Test
    public void checkIfRomanButtonTapped() {
        presenter.onRomanPressed("X");
        verify(romanInteractor, times(1)).addToTotal(anyString());
    }

    @Test
    public void checkRomanCorrectValue() {
        ArgumentCaptor<String> captor = forClass(String.class);
        presenter.onRomanPressed("V");
        verify(romanInteractor, times(1)).addToTotal(captor.capture());
    }

    @Test
    public void checkClearButtonTapped() {
        presenter.onClearPressed();
        verify(romanInteractor, times(1)).clearTotal();
    }

    @Test
    public void checkEnterButtonTapped() {
        presenter.onEnterPressed();
        verify(romanInteractor, times(1)).clearTotal();
    }

}
