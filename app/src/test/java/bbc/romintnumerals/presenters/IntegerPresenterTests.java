package bbc.romintnumerals.presenters;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import bbc.romintnumerals.interactors.IntegerInteractor;
import bbc.romintnumerals.views.IntegerView;

import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Created by Myles Doolan.
 *
 * Test the code inside the IntegerPresenterLogic class
 */
@RunWith(MockitoJUnitRunner.class)
public class IntegerPresenterTests {

    @Mock
    IntegerInteractor integerInteractor;
    @Mock
    IntegerView integerView;

    private IntegerPresenterLogic presenter;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        presenter = new IntegerPresenterLogic(integerView, integerInteractor);
    }

    @Test
    public void checkIfIntegerButtonTapped() {
        presenter.onIntegerPressed("1");
        verify(integerInteractor, times(1)).addToTotal(anyString());
    }

    @Test
    public void checkIntegerCorrectValue() {
        presenter.onIntegerPressed("2");
        verify(integerInteractor, times(1)).addToTotal("2");
    }

    @Test
    public void checkClearButtonTapped() {
        presenter.onClearPressed();
        verify(integerInteractor, times(1)).clearTotal();
    }

    @Test
    public void checkEnterButtonTapped() {
        presenter.onEnterPressed();
        verify(integerInteractor, times(1)).clearTotal();
    }

}