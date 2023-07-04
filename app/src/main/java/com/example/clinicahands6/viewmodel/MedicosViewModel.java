package com.example.clinicahands6.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.clinicahands6.entity.MedicoEntity;
import com.example.clinicahands6.entity.RetornoEntity;
import com.example.clinicahands6.repository.MedicoRepository;

import java.util.List;

public class MedicosViewModel extends AndroidViewModel {
    private MedicoRepository mRepository;
    private MutableLiveData<List<MedicoEntity>> mlistaMedicos = new MutableLiveData<>();
    public LiveData<List<MedicoEntity>> listaMedicos = this.mlistaMedicos;

    private MutableLiveData<RetornoEntity> mRetorno = new MutableLiveData<>();
    public LiveData<RetornoEntity> retorno = this.mRetorno;


    public MedicosViewModel(@NonNull Application application) {
        super(application);
//        instacia o repositório com o contexto obtido pelo metodo getApplicationContext
        this.mRepository = new MedicoRepository(application.getApplicationContext());
    }

    public void delete(int id) {
        if (this.mRepository.delete(id)) {
            this.mRetorno.setValue(new RetornoEntity("Médico excluido com sucesso!"));
        } else {
            this.mRetorno.setValue(new RetornoEntity("Falha exclusão do Médico.", false));
        }
    }

    public void getList() {
        this.mlistaMedicos.setValue(this.mRepository.getAll());
    }
}