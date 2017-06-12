package bbc.romintnumerals.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import bbc.romintnumerals.R;
import bbc.romintnumerals.interactors.IntegerInteractorLogic;
import bbc.romintnumerals.presenters.IntegerPresenter;
import bbc.romintnumerals.presenters.IntegerPresenterLogic;
import bbc.romintnumerals.views.IntegerView;

/**
 * Created by Myles Doolan.
 * <p>
 * Integer fragment for displaying the page the user can convert an arabic numberal into a roman number.
 */
public class IntegerFragment extends Fragment implements IntegerView {

    private final String ROMAN = "roman";
    private final String NUMERAL = "numeral";
    private IntegerPresenter presenter;
    private TextView roman;
    private TextView numeral;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        presenter = new IntegerPresenterLogic(this, new IntegerInteractorLogic());
        View view = inflater.inflate(R.layout.integer_fragment, container, false);
        roman = (TextView) view.findViewById(R.id.integer_converted_value);
        numeral = (TextView) view.findViewById(R.id.integer_value);

        view.findViewById(R.id.integer_one).setOnClickListener(onKeyPressed);
        view.findViewById(R.id.integer_two).setOnClickListener(onKeyPressed);
        view.findViewById(R.id.integer_three).setOnClickListener(onKeyPressed);
        view.findViewById(R.id.integer_four).setOnClickListener(onKeyPressed);
        view.findViewById(R.id.integer_five).setOnClickListener(onKeyPressed);
        view.findViewById(R.id.integer_six).setOnClickListener(onKeyPressed);
        view.findViewById(R.id.integer_seven).setOnClickListener(onKeyPressed);
        view.findViewById(R.id.integer_eight).setOnClickListener(onKeyPressed);
        view.findViewById(R.id.integer_nine).setOnClickListener(onKeyPressed);
        view.findViewById(R.id.integer_zero).setOnClickListener(onKeyPressed);
        view.findViewById(R.id.integer_enter).setOnClickListener(onEnterPressed);
        view.findViewById(R.id.integer_clear).setOnClickListener(onClearPressed);

        if (savedInstanceState != null) {
            //Restore the fragment's state
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

    @Override
    public void showInteger(String value) {
        numeral.setText(value);
    }

    @Override
    public void showRoman(String value) {
        roman.setText(value);
    }

    View.OnClickListener onKeyPressed = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Button key = (Button) view;
            String integerValue = (String) key.getText();
            presenter.onIntegerPressed(integerValue);
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
