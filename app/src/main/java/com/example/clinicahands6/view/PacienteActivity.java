package com.example.clinicahands6.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.clinicahands6.R;
import com.example.clinicahands6.entity.PacienteEntity;
import com.example.clinicahands6.viewmodel.PacienteViewModel;

public class PacienteActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewHolder mViewHolder = new ViewHolder();
    private PacienteViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fomulario_paciente);
        this.mViewModel = new ViewModelProvider(this).get(PacienteViewModel.class);

        //mepeia os elementos do layout formulario paciente
        this.mViewHolder.editNome = findViewById(R.id.editNome);
        this.mViewHolder.editCpf = findViewById(R.id.editCpf);
        this.mViewHolder.editEmail = findViewById(R.id.editEmail);
        this.mViewHolder.editData_nascimento = findViewById(R.id.editData_nascimento);
        this.mViewHolder.editEndereco = findViewById(R.id.editEndereco);
        this.mViewHolder.editTelefone = findViewById((R.id.editTelefone));
        this.mViewHolder.btSalvar = findViewById(R.id.btSalvar);

        // escuta os eventos
        this.setListeners();
    }

    // es
    @Override
    public void onClick(View view) {
        // Verifica se botão Salvar foi clicado
        if (view.getId() == R.id.btSalvar) {
            // Encaminha os dados recebidos para a ViewModel Paciente tratar e validar
            this.HandleSalvar();
        }
    }
    private void setListeners() {
        // executa ao ser clicado botão salvar
        this.mViewHolder.btSalvar.setOnClickListener(this);
    }

    private void HandleSalvar() {
        String nome = this.mViewHolder.editNome.getText().toString();
        String cpf = this.mViewHolder.editCpf.getText().toString();
        String data_nascimento = this.mViewHolder.editData_nascimento.getText().toString();
        String email = this.mViewHolder.editEmail.getText().toString();
        String endereco = this.mViewHolder.editEndereco.getText().toString();
        String telefone = this.mViewHolder.editTelefone.getText().toString();

        PacienteEntity paciente = new PacienteEntity( nome, cpf,  data_nascimento,  email,  endereco,  telefone);
        // encaminha os dados para ViewModel implementar as regras de negócio (validação dos dados,
        // adaptação e salvamento;
        this.mViewModel.salvar(paciente);
    }

    // cria a classe e e elementos da ViewHolder
    public static class ViewHolder {
        EditText editNome;
        EditText editCpf;
        EditText editData_nascimento;
        EditText editEmail;
        EditText editEndereco;
        EditText editTelefone;
        Button btSalvar;
    }
}