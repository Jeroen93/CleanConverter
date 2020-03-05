package nl.jaarts.cleanconverter.ui.temperature;

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
import nl.jaarts.cleanconverter.enums.TemperatureUnit;
import nl.jaarts.cleanconverter.model.TemperatureValuesContainer;
import nl.jaarts.cleanconverter.util.EditTextUtil;

public class TemperatureFragment extends Fragment {

    private TemperatureViewModel mViewModel;

    private EditText etCelsius;
    private EditText etFahrenheit;
    private EditText etKelvin;

    public static TemperatureFragment newInstance() {
        return new TemperatureFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_temperature, container, false);

        getEditTextsFromView(view);

        Button btnConvertC = view.findViewById(R.id.btnConvertC);
        btnConvertC.setOnClickListener(createClickListener(etCelsius, TemperatureUnit.CELSIUS));

        Button btnConvertF = view.findViewById(R.id.btnConvertF);
        btnConvertF.setOnClickListener(createClickListener(etFahrenheit, TemperatureUnit.FAHRENHEIT));

        Button btnConvertK = view.findViewById(R.id.btnConvertK);
        btnConvertK.setOnClickListener(createClickListener(etKelvin, TemperatureUnit.KELVIN));

        Button btnReset = view.findViewById(R.id.btnReset);
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayTemperatureValues(new TemperatureValuesContainer());
            }
        });

        return view;
    }

    private void displayTemperatureValues(final TemperatureValuesContainer container) {
        DecimalFormat format = new DecimalFormat("#.###");
        etCelsius.setText(format.format(container.getCelsius()));
        etFahrenheit.setText(format.format(container.getFahrenheit()));
        etKelvin.setText(format.format(container.getKelvin()));
    }

    private void getEditTextsFromView(final View view) {
        etCelsius = view.findViewById(R.id.etCelsius);
        etFahrenheit = view.findViewById(R.id.etFahrenheit);
        etKelvin = view.findViewById(R.id.etKelvin);
    }

    private View.OnClickListener createClickListener(final EditText editText, final TemperatureUnit unit) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double value = EditTextUtil.getDoubleValue(editText);

                if (Double.isNaN(value)) {
                    return;
                }

                TemperatureValuesContainer valuesContainer = mViewModel.convertTemperatureValues(value, unit);
                displayTemperatureValues(valuesContainer);
            }
        };
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(TemperatureViewModel.class);
    }
}
