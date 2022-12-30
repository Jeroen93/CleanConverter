package nl.jaarts.cleanconverter.util;

import android.text.Editable;
import android.widget.EditText;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EditTextUtilTest {

    @Mock
    private EditText editText;

    @Mock
    private Editable editable;

    @BeforeEach
    void setUp() {
        Mockito.lenient().when(editText.getText()).thenReturn(editable);
    }

    @Test
    void getDoubleValue_NullEditText_ThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> EditTextUtil.getDoubleValue(null));
    }

    @Test
    void getDoubleValue_EmptyEditText_ReturnsDoubleNaN() {
        when(editable.toString()).thenReturn("");

        double result = EditTextUtil.getDoubleValue(editText);

        assertTrue(Double.isNaN(result));
    }

    @Test
    void getDoubleValue_EditTextContainsNoDouble_ReturnsDoubleNaN() {
        when(editable.toString()).thenReturn("invalid");

        double result = EditTextUtil.getDoubleValue(editText);

        assertTrue(Double.isNaN(result));
    }

    @Test
    void getDoubleValue_EditTextWithDoubleValue_ReturnsDoubleValue() {
        when(editable.toString()).thenReturn("24.5");

        double result = EditTextUtil.getDoubleValue(editText);

        assertEquals(24.5d, result);
    }

}