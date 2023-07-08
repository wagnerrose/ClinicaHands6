package com.example.clinicahands6.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.clinicahands6.entity.PacienteEntity;
import com.example.clinicahands6.entity.RetornoEntity;
import com.example.clinicahands6.helpers.ValidaCPF;
import com.example.clinicahands6.repository.PacienteRepository;

public class PacienteViewModel extends AndroidViewModel {

    private PacienteRepository mRepository;

    //    usado para acompanhar as alterações na
    private MutableLiveData<PacienteEntity> mPaciente = new MutableLiveData<>();
    public LiveData<PacienteEntity> paciente = this.mPaciente;

    private MutableLiveData<RetornoEntity> mRetorno = new MutableLiveData<>();
    public LiveData<RetornoEntity> retorno = this.mRetorno;

    public PacienteViewModel(@NonNull Application application) {
        super(application);
        this.mRepository = new PacienteRepository(application.getApplicationContext());
    }

    public void salvar(PacienteEntity paciente) {
        ValidaCPF cpf = new ValidaCPF();

        // Realiza a validação do campo nome não nulo
        if ("".equals(paciente.getNome())) {
            this.mRetorno.setValue(new RetornoEntity("Nome não pode ser vazio", false));
            return;
        }
//        Realiza a validação e formataçao do CPF
        if(cpf.isCPF(paciente.getCpf()) == false) {
            this.mRetorno.setValue(new RetornoEntity("CPF Inválido. Digite apenas os números.", false));
            return;
        } else {
            paciente.setCpf(cpf.formataCPF(paciente.getCpf()));
        }


//      Para um id de paciente nulo, estaremos em um ambiente de inclusão
//      caso contrário será de edição
        if (paciente.getId() == 0) {
            // Caso seja inserção
            if (this.mRepository.insert(paciente)) {
                this.mRetorno.setValue(new RetornoEntity("Paciente incluido com sucesso!"));
            } else {
                this.mRetorno.setValue(new RetornoEntity("Falha na inclusão do Paciente.", false));
            }
        } else {
            // Caso seja atualização
            if (this.mRepository.update(paciente)) {
                this.mRetorno.setValue(new RetornoEntity("Paciente atualizado com sucesso!"));
            } else {
                this.mRetorno.setValue(new RetornoEntity("Falha na atualização do Paciente.", false));
            }
        }
    }

    public void lePaciente(int id) {
        this.mPaciente.setValue(this.mRepository.getById(id));
    }
}
