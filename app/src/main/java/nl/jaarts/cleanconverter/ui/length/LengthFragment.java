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

    private LengthViewModel mViewModel;

    private EditText etCentimeters;
    private EditText etFeet;
    private EditText etInches;
    private EditText etKilometers;
    private EditText etMeters;
    private EditText etMiles;
    private EditText etYards;

    public static LengthFragment newInstance() {
        return new LengthFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_length, container, false);

        getEditTextsFromView(view);

        Button btnConvertCm = view.findViewById(R.id.btnConvertCm);
        btnConvertCm.setOnClickListener(createClickListener(etCentimeters, LengthUnit.CENTIMETERS));

        Button btnConvertFt = view.findViewById(R.id.btnConvertFt);
        btnConvertFt.setOnClickListener(createClickListener(etFeet, LengthUnit.FEET));

        Button btnConvertIn = view.findViewById(R.id.btnConvertIn);
        btnConvertIn.setOnClickListener(createClickListener(etInches, LengthUnit.INCHES));

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
                displayLengthValues(new LengthValuesContainer());
            }
        });

        return view;
    }

    private void displayLengthValues(final LengthValuesContainer container) {
        DecimalFormat format = new DecimalFormat("#.#####");
        etCentimeters.setText(format.format(container.getCentimeters()));
        etFeet.setText(format.format(container.getFeet()));
        etInches.setText(format.format(container.getInches()));
        etKilometers.setText(format.format(container.getKilometers()));
        etMeters.setText(format.format(container.getMeters()));
        etMiles.setText(format.format(container.getMiles()));
        etYards.setText(format.format(container.getYards()));
    }

    private void getEditTextsFromView(final View view) {
        etCentimeters = view.findViewById(R.id.etCentimeters);
        etFeet = view.findViewById(R.id.etFeet);
        etInches = view.findViewById(R.id.etInches);
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
