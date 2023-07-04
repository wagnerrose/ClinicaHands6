package com.example.clinicahands6.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.clinicahands6.entity.MedicoEntity;
import com.example.clinicahands6.entity.RetornoEntity;
import com.example.clinicahands6.repository.MedicoRepository;

public class MedicoViewModel extends AndroidViewModel {
    private MedicoRepository mRepository;

    private MutableLiveData<MedicoEntity> mMedico = new MutableLiveData<>();
    public LiveData<MedicoEntity> medico = this.mMedico;

    private MutableLiveData<RetornoEntity> mRetorno = new MutableLiveData<>();
    public LiveData<RetornoEntity> retorno = this.mRetorno;

    public MedicoViewModel(@NonNull Application application) {
        super(application);
        this.mRepository = new MedicoRepository(application.getApplicationContext());
    }

    public void salvar(MedicoEntity medico) {
           // Realiza a validação do campo nome não nulo
        if ("".equals(medico.getNome())) {
            this.mRetorno.setValue(new RetornoEntity("Nome não pode ser vazio", false));
            return;
        }

        if (medico.getId() == 0) {
            // Caso seja inserção
            if (this.mRepository.insert(medico)) {
                this.mRetorno.setValue(new RetornoEntity("Médico incluido com sucesso!"));
            } else {
                this.mRetorno.setValue(new RetornoEntity("Falha na inclusão do Médico.", false));
            }
        } else {
            // Caso seja atualização
            if (this.mRepository.update(medico)) {
                this.mRetorno.setValue(new RetornoEntity("Médico atualizado com sucesso!"));
            } else {
                this.mRetorno.setValue(new RetornoEntity("Falha na atualização do Médico.", false));
            }
        }
    }
//    Carrega a Entity médico
    public void leMedico(int id) {
        this.mMedico.setValue(this.mRepository.getById(id));
    }
}
