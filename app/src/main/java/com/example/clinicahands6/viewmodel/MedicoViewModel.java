package com.example.clinicahands6.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.clinicahands6.entity.Feedback;
import com.example.clinicahands6.entity.MedicoEntity;
import com.example.clinicahands6.repository.MedicoRepository;

public class MedicoViewModel extends ViewModel {
    private MedicoRepository mMedicoRepository;

    private MutableLiveData<MedicoEntity> mMedico = new MutableLiveData<>();
    public LiveData<MedicoEntity> medico = this.mMedico;

    private MutableLiveData<Feedback> mFeedback = new MutableLiveData<>();
    public LiveData<Feedback> feedback = this.mFeedback;

    public void salvar(MedicoEntity medico) {
        // validação dos campos
        // Realiza a validação do campo nome
        if ("".equals(medico.getNome())) {
            this.mFeedback.setValue(new Feedback("Nome obrigatório!", false));
            return;
        }

        if (medico.getId() == 0) {
            // Caso seja inserção
            if (this.mMedicoRepository.insert(medico)) {
                this.mFeedback.setValue(new Feedback("Médico salvo  com sucesso!"));
            } else {
                this.mFeedback.setValue(new Feedback("Falha ao salvar Médico", false));
            }
        } else {
            // Caso seja atualização
//            if (this.mMedicoRepository.update(medico)) {
            if (this.mMedicoRepository.update(medico) == 1) {
                this.mFeedback.setValue(new Feedback("Médico  atualizado com sucesso!"));
            } else {
                this.mFeedback.setValue(new Feedback("Falha ao atualizar Médico", false));
            }
        }
    }

}
