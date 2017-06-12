package bbc.romintnumerals.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import bbc.romintnumerals.R;
import bbc.romintnumerals.interactors.RomanInteractorLogic;
import bbc.romintnumerals.presenters.RomanPresenter;
import bbc.romintnumerals.presenters.RomanPresenterLogic;
import bbc.romintnumerals.views.RomanView;

/**
 * Created by Myles Doolan.
 *
 * Roman fragment for displaying the page the user can convert roman numerals into a roman arabic numbers.
 */
public class RomanFragment extends Fragment implements RomanView {

    private final String ROMAN = "roman";
    private final String NUMERAL = "numeral";

    private RomanPresenter presenter;
    private TextView roman;
    private TextView numeral;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        presenter = new RomanPresenterLogic(this, new RomanInteractorLogic());
        View view = inflater.inflate(R.layout.roman_fragment, container, false);
        numeral = (TextView) view.findViewById(R.id.roman_converted_value);
        roman = (TextView) view.findViewById(R.id.roman_value);

        view.findViewById(R.id.roman_one).setOnClickListener(onKeyPressed);
        view.findViewById(R.id.roman_five).setOnClickListener(onKeyPressed);
        view.findViewById(R.id.roman_ten).setOnClickListener(onKeyPressed);
        view.findViewById(R.id.roman_fifty).setOnClickListener(onKeyPressed);
        view.findViewById(R.id.roman_hundred).setOnClickListener(onKeyPressed);
        view.findViewById(R.id.roman_five_hundred).setOnClickListener(onKeyPressed);
        view.findViewById(R.id.roman_thousand).setOnClickListener(onKeyPressed);
        view.findViewById(R.id.roman_enter).setOnClickListener(onEnterPressed);
        view.findViewById(R.id.roman_clear).setOnClickListener(onClearPressed);

        if (savedInstanceState != null) {
            presenter.onRotate(savedInstanceState.getString(ROMAN), savedInstanceState.getString(NUMERAL));
        }

        return view;
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putString(ROMAN, roman.getText().toString());
        savedInstanceState.putString(NUMERAL, numeral.getText().toString());
        super.onSaveInstanceState(savedInstanceState);
    }

    @Override public void showInteger(String value) {
        numeral.setText(value);
    }

    @Override public void showRoman(String value) {
        roman.setText(value);
    }

    View.OnClickListener onKeyPressed = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Button key = (Button) view;
            String romanValue = (String) key.getText();
            presenter.onRomanPressed(romanValue);
        }
    };

    View.OnClickListener onClearPressed = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            presenter.onClearPressed();
        }
    };

    View.OnClickListener onEnterPressed = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            presenter.onEnterPressed();
        }
    };
}
