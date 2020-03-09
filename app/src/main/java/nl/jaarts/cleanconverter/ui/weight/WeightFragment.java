package nl.jaarts.cleanconverter.ui.weight;

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
import nl.jaarts.cleanconverter.enums.WeightUnit;
import nl.jaarts.cleanconverter.model.WeightValuesContainer;
import nl.jaarts.cleanconverter.util.EditTextUtil;

public class WeightFragment extends Fragment {

    private WeightViewModel mViewModel;

    private EditText etGram;
    private EditText etKilos;
    private EditText etStones;
    private EditText etPounds;
    private EditText etOunces;

    public static WeightFragment newInstance() {
        return new WeightFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_weight, container, false);

        getEditTextsFromView(view);
        resetEditTexts();

        Button btnConvertG = view.findViewById(R.id.btnConvertG);
        btnConvertG.setOnClickListener(createClickListener(etGram, WeightUnit.GRAM));

        Button btnConvertKg = view.findViewById(R.id.btnConvertKg);
        btnConvertKg.setOnClickListener(createClickListener(etKilos, WeightUnit.KILOGRAM));

        Button btnConvertSt = view.findViewById(R.id.btnConvertSt);
        btnConvertSt.setOnClickListener(createClickListener(etStones, WeightUnit.STONES));

        Button btnConvertLb = view.findViewById(R.id.btnConvertLb);
        btnConvertLb.setOnClickListener(createClickListener(etPounds, WeightUnit.POUNDS));

        Button btnConvertOz = view.findViewById(R.id.btnConvertOz);
        btnConvertOz.setOnClickListener(createClickListener(etOunces, WeightUnit.OUNCES));

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
        displayWeightValues(new WeightValuesContainer());
    }

    private void displayWeightValues(final WeightValuesContainer valuesContainer) {
        DecimalFormat formatter = new DecimalFormat("#.####");
        etGram.setText(formatter.format(valuesContainer.getGrams()));
        etKilos.setText(formatter.format(valuesContainer.getKilograms()));
        etStones.setText(formatter.format(valuesContainer.getStones()));
        etPounds.setText(formatter.format(valuesContainer.getPounds()));
        etOunces.setText(formatter.format(valuesContainer.getOunces()));
    }

    private void getEditTextsFromView(final View view) {
        etGram = view.findViewById(R.id.etGrams);
        etKilos = view.findViewById(R.id.etKilos);
        etStones = view.findViewById(R.id.etStones);
        etPounds = view.findViewById(R.id.etPounds);
        etOunces = view.findViewById(R.id.etOunces);
    }

    private View.OnClickListener createClickListener(final EditText editText, final WeightUnit unit) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double value = EditTextUtil.getDoubleValue(editText);

                if (Double.isNaN(value)) {
                    return;
                }

                WeightValuesContainer valuesContainer = mViewModel.convertWeightValues(value, unit);
                displayWeightValues(valuesContainer);
            }
        };
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(WeightViewModel.class);
    }
}
