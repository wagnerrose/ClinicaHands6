package com.example.clinicahands6.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.clinicahands6.entity.PacienteEntity;
import com.example.clinicahands6.entity.RetornoEntity;
import com.example.clinicahands6.repository.PacienteRepository;

import java.util.List;

public class PacientesViewModel extends AndroidViewModel {


    private PacienteRepository mRepository;

    private MutableLiveData<List<PacienteEntity>> mlistaPacientes = new MutableLiveData<>();
    public LiveData<List<PacienteEntity>> listaPacientes = this.mlistaPacientes;

    private MutableLiveData<RetornoEntity> mRetorno = new MutableLiveData<>();
    public LiveData<RetornoEntity> retorno = this.mRetorno;

    public PacientesViewModel(@NonNull Application application) {
        super(application);
        this.mRepository = new PacienteRepository(application.getApplicationContext());
    }

    public void delete(int id) {
        if (this.mRepository.delete(id)) {
            this.mRetorno.setValue(new RetornoEntity("Paciente excluido com sucesso!"));
        } else {
            this.mRetorno.setValue(new RetornoEntity("Falha exclusão do Paciente.", false));
        }
    }
    public void getList() {

        this.mlistaPacientes.setValue(this.mRepository.getAll());

    }

//    public void bind(PacienteEntity) {
//
//    }
}