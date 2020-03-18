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

import java.text.DecimalFormat;

import nl.jaarts.cleanconverter.R;
import nl.jaarts.cleanconverter.model.BmiCalculationResult;
import nl.jaarts.cleanconverter.util.EditTextUtil;
import nl.jaarts.cleanconverter.util.ResourceProvider;

public class BmiFragment extends Fragment {

    private BmiViewModel mViewModel;

    private Group grpMetric;
    private Group grpImperial;
    private TextView tvWeightUnit;

    private EditText etHeightCm;
    private EditText etHeightFt;
    private EditText etHeightIn;
    private EditText etWeight;
    private EditText etBmi;
    private EditText etCategory;

    private boolean showsMetric = true;
    private ResourceProvider resourceProvider;

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
        etBmi = view.findViewById(R.id.etBmi);
        etCategory = view.findViewById(R.id.etCategory);

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
        String empty = "";
        etHeightCm.setText(empty);
        etHeightFt.setText(empty);
        etHeightIn.setText(empty);
        etWeight.setText(empty);
        etBmi.setText(empty);
        etCategory.setText(empty);
    }

    private void calculateMetricBMI() {
        double cm = EditTextUtil.getDoubleValue(etHeightCm);
        double kg = EditTextUtil.getDoubleValue(etWeight);

        if (Double.isNaN(cm) || Double.isNaN(kg)) {
            return;
        }

        BmiCalculationResult result = mViewModel.calculateMetricBMI(cm, kg);
        displayBMIResult(result);
    }

    private void calculateImperialBMI() {
        double ft = EditTextUtil.getDoubleValue(etHeightFt);
        double in = EditTextUtil.getDoubleValue(etHeightIn);
        double lb = EditTextUtil.getDoubleValue(etWeight);

        if (Double.isNaN(lb) || Double.isNaN(ft)) {
            return;
        }

        // Inch field may be left empty -> set to 0
        if (Double.isNaN(in)) {
            in = 0d;
        }

        BmiCalculationResult result = mViewModel.calculateImperialBMI(ft, in, lb);
        displayBMIResult(result);
    }

    private void displayBMIResult(BmiCalculationResult result) {
        DecimalFormat format = new DecimalFormat("#.#");
        etBmi.setText(format.format(result.getBmi()));
        etCategory.setText(result.getCategory());
    }

    private void showMetricFields() {
        grpMetric.setVisibility(View.VISIBLE);
        grpImperial.setVisibility(View.GONE);
        tvWeightUnit.setText(R.string.lblUnitKg);
        showsMetric = true;
    }

    private void showImperialFields() {
        grpMetric.setVisibility(View.GONE);
        grpImperial.setVisibility(View.VISIBLE);
        tvWeightUnit.setText(R.string.lblUnitLb);
        showsMetric = false;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(BmiViewModel.class);
        mViewModel.setResourceProvider(getResourceProvider());
    }

    public ResourceProvider getResourceProvider() {
        if (resourceProvider == null) {
            resourceProvider = new ResourceProvider(this.getContext());
        }

        return resourceProvider;
    }
}
