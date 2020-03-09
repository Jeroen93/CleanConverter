package nl.jaarts.cleanconverter.ui.length;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import java.text.DecimalFormat;

import nl.jaarts.cleanconverter.R;
import nl.jaarts.cleanconverter.enums.LengthUnit;
import nl.jaarts.cleanconverter.model.LengthValuesContainer;
import nl.jaarts.cleanconverter.util.EditTextUtil;

public class LengthFragment extends Fragment {

    private static final DecimalFormat FORMAT = new DecimalFormat("#.#####");
    private LengthViewModel mViewModel;

    private EditText etCentimeters;
    private EditText etFeet;
    private EditText etInches;
    private EditText etKilometers;
    private EditText etMeters;
    private EditText etMiles;
    private EditText etYards;
    private EditText etCombiFt;
    private EditText etCombiIn;

    public static LengthFragment newInstance() {
        return new LengthFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_length, container, false);

        getEditTextsFromView(view);
        resetEditTexts();

        Button btnConvertCm = view.findViewById(R.id.btnConvertCm);
        btnConvertCm.setOnClickListener(createClickListener(etCentimeters, LengthUnit.CENTIMETERS));

        Button btnConvertFt = view.findViewById(R.id.btnConvertFt);
        btnConvertFt.setOnClickListener(createClickListener(etFeet, LengthUnit.FEET));

        Button btnConvertIn = view.findViewById(R.id.btnConvertIn);
        btnConvertIn.setOnClickListener(createClickListener(etInches, LengthUnit.INCHES));

        Button btnConvertFtIn = view.findViewById(R.id.btnConvertFtIn);
        btnConvertFtIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double ft = EditTextUtil.getDoubleValue(etCombiFt);
                double in = EditTextUtil.getDoubleValue(etCombiIn);

                if (Double.isNaN(ft) || Double.isNaN(in)) {
                    return;
                }

                double totalInch = ft * 12 + in;
                LengthValuesContainer valuesContainer = mViewModel.convertLengthValues(totalInch, LengthUnit.INCHES);
                displayLengthValues(valuesContainer);
            }
        });

        Button btnConvertKm = view.findViewById(R.id.btnConvertKm);
        btnConvertKm.setOnClickListener(createClickListener(etKilometers, LengthUnit.KILOMETERS));

        Button btnConvertM = view.findViewById(R.id.btnConvertM);
        btnConvertM.setOnClickListener(createClickListener(etMeters, LengthUnit.METERS));

        Button btnConvertMi = view.findViewById(R.id.btnConvertMi);
        btnConvertMi.setOnClickListener(createClickListener(etMiles, LengthUnit.MILES));

        Button btnConvertYd = view.findViewById(R.id.btnConvertYd);
        btnConvertYd.setOnClickListener(createClickListener(etYards, LengthUnit.YARDS));

        Button btnReset = view.findViewById(R.id.btnReset);
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetEditTexts();
            }
        });

        return view;
    }

    private void resetEditTexts() {
        displayLengthValues(new LengthValuesContainer());
    }

    private void displayLengthValues(final LengthValuesContainer container) {
        etCentimeters.setText(FORMAT.format(container.getCentimeters()));
        etFeet.setText(FORMAT.format(container.getFeet()));
        etInches.setText(FORMAT.format(container.getInches()));
        displayCombiLengthValues(container.getInches());
        etKilometers.setText(FORMAT.format(container.getKilometers()));
        etMeters.setText(FORMAT.format(container.getMeters()));
        etMiles.setText(FORMAT.format(container.getMiles()));
        etYards.setText(FORMAT.format(container.getYards()));
    }

    private void displayCombiLengthValues(double inches) {
        int ft = (int) (inches / 12);
        double in = inches % 12;

        etCombiFt.setText(String.format("%s", ft));
        etCombiIn.setText(FORMAT.format(in));
    }

    private void getEditTextsFromView(final View view) {
        etCentimeters = view.findViewById(R.id.etCentimeters);
        etFeet = view.findViewById(R.id.etFeet);
        etInches = view.findViewById(R.id.etInches);
        etCombiFt = view.findViewById(R.id.etCombiFt);
        etCombiIn = view.findViewById(R.id.etCombiIn);
        etKilometers = view.findViewById(R.id.etKilometers);
        etMeters = view.findViewById(R.id.etMeters);
        etMiles = view.findViewById(R.id.etMiles);
        etYards = view.findViewById(R.id.etYards);
    }

    private View.OnClickListener createClickListener(final EditText editText, final LengthUnit unit) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double value = EditTextUtil.getDoubleValue(editText);

                if (Double.isNaN(value)) {
                    return;
                }

                LengthValuesContainer valuesContainer = mViewModel.convertLengthValues(value, unit);
                displayLengthValues(valuesContainer);
            }
        };
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(LengthViewModel.class);
    }
}
