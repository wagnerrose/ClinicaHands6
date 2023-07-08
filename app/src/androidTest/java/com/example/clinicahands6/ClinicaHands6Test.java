package com.example.clinicahands6;

import static org.junit.Assert.assertEquals;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.clinicahands6.helpers.ValidaCPF;

import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ClinicaHands6Test {
    @Test
    public void testaCPF() {

        String cpfValido = "53806786968";
        String cpfInvalido = "111111111";
        String cpfFormatado = "538.067.869-68";

        ValidaCPF cpf = new ValidaCPF();

        assertEquals(cpf.isCPF(cpfValido), true);
        assertEquals(cpf.isCPF(cpfInvalido), false);
        assertEquals(cpf.formataCPF(cpfValido), cpfFormatado);
        assertEquals(cpf.formataCPF(cpfValido), cpfFormatado);
        assertEquals(cpf.isCPF(cpfFormatado), true);

    }
}