package nl.jaarts.cleanconverter.util;

import android.util.Log;
import android.widget.EditText;

public class EditTextUtil {

    private static final String TAG = "EditTextUtil";

    public static double getDoubleValue(EditText editText) {

        if (editText == null) {
            throw new IllegalArgumentException("editText");
        }

        String text = editText.getText().toString();

        if (text.isEmpty()) {
            return Double.NaN;
        }

        try {
            return Double.parseDouble(text);
        } catch (NumberFormatException e) {
            Log.e(TAG, "Exception during converting text to double", e);

            return Double.NaN;
        }
    }

    private EditTextUtil() {
        // Don't instantiate me
    }
}
