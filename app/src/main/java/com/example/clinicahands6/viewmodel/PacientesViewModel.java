package com.example.clinicahands6.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PacientesViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public PacientesViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Fragmento Pacientes");
    }

    public LiveData<String> getText() {
        return mText;
    }
}