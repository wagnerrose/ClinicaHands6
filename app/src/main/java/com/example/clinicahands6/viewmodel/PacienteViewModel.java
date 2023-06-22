package com.example.clinicahands6.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.clinicahands6.entity.Feedback;
import com.example.clinicahands6.entity.PacienteEntity;
import com.example.clinicahands6.repository.PacienteRepository;

public class PacienteViewModel extends AndroidViewModel {

    private PacienteRepository mRepository;

    private MutableLiveData<PacienteEntity> mPaciente = new MutableLiveData<>();
    public LiveData<PacienteEntity> paciente = this.mPaciente;

    private MutableLiveData<Feedback> mFeedback = new MutableLiveData<>();
    public LiveData<Feedback> feedback = this.mFeedback;

    public PacienteViewModel(@NonNull Application application) {
        super(application);
        this.mRepository = new PacienteRepository(application.getApplicationContext());
    }

    public void salvar(PacienteEntity paciente) {
        // Realiza a validação do campo nome
        if ("".equals(paciente.getNome())) {
            this.mFeedback.setValue(new Feedback("Nome obrigatório!", false));
            return;
        }

        if (paciente.getId() == 0) {
            // Caso seja inserção
            if (this.mRepository.insert(paciente)) {
                this.mFeedback.setValue(new Feedback("Convidado inserido com sucesso!"));
            } else {
                this.mFeedback.setValue(new Feedback("Erro inesperado", false));
            }
        } else {
            // Caso seja atualização
            if (this.mRepository.update(paciente)==1) {
                this.mFeedback.setValue(new Feedback("Convidado atualizado com sucesso!"));
            } else {
                this.mFeedback.setValue(new Feedback("Erro inesperado", false));
            }
        }
    }
}
