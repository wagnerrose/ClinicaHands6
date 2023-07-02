package com.example.clinicahands6.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.clinicahands6.entity.MedicoEntity;
import com.example.clinicahands6.repository.MedicoRepository;

public class MedicoViewModel extends AndroidViewModel {
    private MedicoRepository mRepository;

    private MutableLiveData<MedicoEntity> mMedico = new MutableLiveData<>();
    public LiveData<MedicoEntity> medico = this.mMedico;

//    private MutableLiveData<Boolean> mFeedback = new MutableLiveData<>();
//    public LiveData<Boolean> feedback = this.mFeedback;

    public MedicoViewModel(@NonNull Application application) {
        super(application);
        this.mRepository = new MedicoRepository(application.getApplicationContext());
    }

    public void salvar(MedicoEntity medico) {
        // validação dos campos
        // Realiza a validação do campo nome
        if ("".equals(medico.getNome())) {
//            this.mFeedback.setValue(false);
            return;
        }

        if (medico.getId() == 0) {
            // Caso seja inserção
//            this.mFeedback.setValue(this.mRepository.insert(medico));
        } else {
            // Caso seja atualização
//            this.mFeedback.setValue(this.mRepository.update(medico));
        }
    }
}
