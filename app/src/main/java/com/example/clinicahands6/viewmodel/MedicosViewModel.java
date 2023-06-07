package com.example.clinicahands6.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.clinicahands6.entity.MedicoEntity;
import com.example.clinicahands6.repository.MedicoRepository;

import java.util.List;

public class MedicosViewModel extends AndroidViewModel {
private MedicoRepository mRepository;
private MutableLiveData<List<MedicoEntity>> mlistaMedicos = new MutableLiveData<>();
public LiveData<List<MedicoEntity>> listaMedicos = this.mlistaMedicos;


    public MedicosViewModel(@NonNull Application application) {
        super(application);
        this.mRepository = new MedicoRepository(application.getApplicationContext());
    }

    public void getList() {
        List<MedicoEntity> lista = this.mRepository.getAll();
    }
}