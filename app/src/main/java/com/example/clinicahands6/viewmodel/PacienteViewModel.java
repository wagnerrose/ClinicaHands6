package com.example.clinicahands6.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.clinicahands6.entity.PacienteEntity;
import com.example.clinicahands6.repository.PacienteRepository;

public class PacienteViewModel extends AndroidViewModel {

    private PacienteRepository mRepository;

    //    usado para acompanhar as alterações na
    private MutableLiveData<PacienteEntity> mPaciente = new MutableLiveData<>();
    public LiveData<PacienteEntity> paciente = this.mPaciente;

    private MutableLiveData<Boolean> mFeedback = new MutableLiveData<>();
    public LiveData<Boolean> feedback = this.mFeedback;

    public PacienteViewModel(@NonNull Application application) {
        super(application);
        this.mRepository = new PacienteRepository(application.getApplicationContext());
    }

    public void salvar(PacienteEntity paciente) {
        // Realiza a validação do campo nome não nulo
        if ("".equals(paciente.getNome())) {
            this.mFeedback.setValue(false);
            return;
        }

//      Para um id de paciente nulo, estaremos em um ambiente de inclusão
//      caso contrário será de edição
        if (paciente.getId() == 0) {
            // Caso seja inserção
            this.mFeedback.setValue(this.mRepository.insert(paciente));
        } else {
            // Caso seja atualização
            this.mFeedback.setValue(this.mRepository.update(paciente));
        }
    }

    public void lePaciente(int id) {
        this.mPaciente.setValue(this.mRepository.getById(id));
    }
}
