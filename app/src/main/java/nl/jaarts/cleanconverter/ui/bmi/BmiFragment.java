package nl.jaarts.cleanconverter.ui.bmi;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.Group;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import nl.jaarts.cleanconverter.R;
import nl.jaarts.cleanconverter.model.BmiCalculationResult;
import nl.jaarts.cleanconverter.util.EditTextUtil;

public class BmiFragment extends Fragment {

    private BmiViewModel mViewModel;

    private Group grpMetric;
    private Group grpImperial;
    private TextView tvWeightUnit;

    private EditText etHeightCm;
    private EditText etHeightFt;
    private EditText etHeightIn;
    private EditText etWeight;
    private TextView tvBmi;

    private boolean showsMetric = true;

    public static BmiFragment newInstance() {
        return new BmiFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bmi, container, false);

        grpMetric = view.findViewById(R.id.grpMetric);
        grpImperial = view.findViewById(R.id.grpImperial);
        tvWeightUnit = view.findViewById(R.id.tvWeightUnit);
        etHeightCm = view.findViewById(R.id.etHeightCm);
        etHeightFt = view.findViewById(R.id.etHeightFt);
        etHeightIn = view.findViewById(R.id.etHeightIn);
        etWeight = view.findViewById(R.id.etWeight);
        tvBmi = view.findViewById(R.id.tvBmi);

        RadioGroup radioGroup = view.findViewById(R.id.rgSystem);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rbMetric:
                        showMetricFields();
                        break;
                    case R.id.rbImperial:
                        showImperialFields();
                        break;
                }
            }
        });

        Button btnCalculate = view.findViewById(R.id.btnCalculate);
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (showsMetric) {
                    calculateMetricBMI();
                } else {
                    calculateImperialBMI();
                }
            }
        });

        return view;
    }

    private void calculateMetricBMI() {
        double cm = EditTextUtil.getDoubleValue(etHeightCm);
        double kg = EditTextUtil.getDoubleValue(etWeight);
        BmiCalculationResult result = mViewModel.calculateMetricBMI(cm, kg);
        displayBMIResult(result);
    }

    private void calculateImperialBMI() {
        double ft = EditTextUtil.getDoubleValue(etHeightFt);
        double in = EditTextUtil.getDoubleValue(etHeightIn);
        double lb = EditTextUtil.getDoubleValue(etWeight);
        BmiCalculationResult result = mViewModel.calculateImperialBMI(ft, in, lb);
        displayBMIResult(result);
    }

    private void displayBMIResult(BmiCalculationResult result) {

        tvBmi.setText(String.format("%s", result.getBmi()));
    }

    private void showMetricFields() {
        grpMetric.setVisibility(View.VISIBLE);
        grpImperial.setVisibility(View.GONE);
        tvWeightUnit.setText("kg");
        showsMetric = true;
    }

    private void showImperialFields() {
        grpMetric.setVisibility(View.GONE);
        grpImperial.setVisibility(View.VISIBLE);
        tvWeightUnit.setText("lb");
        showsMetric = false;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(BmiViewModel.class);
    }
}
