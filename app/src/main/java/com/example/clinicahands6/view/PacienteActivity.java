package com.example.clinicahands6.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.clinicahands6.R;
import com.example.clinicahands6.constantes.PacienteConstantes;
import com.example.clinicahands6.entity.PacienteEntity;
import com.example.clinicahands6.entity.RetornoEntity;
import com.example.clinicahands6.viewmodel.PacienteViewModel;

public class PacienteActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewHolder mViewHolder = new ViewHolder();
    private PacienteViewModel mViewModel;
    //    usado para determinas se é uma inclusão ou alteração
//    caso mPacienteId seja nulo estamos em uma inclusão de paciente
//    caso contrário será uma edição
    private int mPacienteId = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fomulario_paciente);
        this.mViewModel = new ViewModelProvider(this).get(PacienteViewModel.class);

        //mepeia os elementos do layout formulario paciente
        this.mViewHolder.editNome = findViewById(R.id.editNome);
        this.mViewHolder.editCpf = findViewById(R.id.editCpf);
        this.mViewHolder.editEmail = findViewById(R.id.editEmail);
        this.mViewHolder.editDataNascimento = findViewById(R.id.editDataNascimento);
        this.mViewHolder.editEndereco = findViewById(R.id.editEndereco);
        this.mViewHolder.editTelefone = findViewById((R.id.editTelefone));
        this.mViewHolder.btSalvar = findViewById(R.id.btSalvar);

        // escuta os eventos
        this.setListeners();
        // acompanha paciente
        this.setObservers();

//        verifica se foram passados parâmetros extras para a activity
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
//          como houve passagem de parâmetros na intent estamos em no modo de edição de paciente
//          assim buscamos o Id do paciente
            this.mPacienteId = bundle.getInt(PacienteConstantes.PACIENTEID);
            this.mViewModel.lePaciente(this.mPacienteId);
        }
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

    private void setObservers() {
        this.mViewModel.paciente.observe(this, new Observer<PacienteEntity>() {
            @Override
            public void onChanged(PacienteEntity paciente) {
                mViewHolder.editNome.setText(paciente.getNome());
                mViewHolder.editCpf.setText(paciente.getCpf());
                mViewHolder.editEndereco.setText(paciente.getEndereco());
                mViewHolder.editEmail.setText(paciente.getEmail());
                mViewHolder.editDataNascimento.setText(paciente.getDataNascimento());
                mViewHolder.editTelefone.setText(paciente.getTelefone());
            }
        });
        this.mViewModel.retorno.observe(this, new Observer<RetornoEntity>() {

            @Override
            public void onChanged(RetornoEntity retorno) {
//                informa o salvamento dos dados
                Toast.makeText(getApplicationContext(), retorno.mMensagem, Toast.LENGTH_SHORT).show();
//                caso tenha dado certo, encerra a activity senão continua na nela
                if (retorno.deuCerto()) {
                    finish();
                }
            }
        });
    }

    private void HandleSalvar() {
//        obtem dados do formulário, faz as conversões
        String nome = this.mViewHolder.editNome.getText().toString();
        String cpf = this.mViewHolder.editCpf.getText().toString();
        String data_nascimento = this.mViewHolder.editDataNascimento.getText().toString();
        String email = this.mViewHolder.editEmail.getText().toString();
        String endereco = this.mViewHolder.editEndereco.getText().toString();
        String telefone = this.mViewHolder.editTelefone.getText().toString();

        PacienteEntity paciente = new PacienteEntity(this.mPacienteId, nome, cpf, data_nascimento, email, endereco, telefone);
        // encaminha os dados para ViewModel implementar as regras de negócio (validação dos dados,
        // adaptação e salvamento;
        this.mViewModel.salvar(paciente);
    }

    // cria a classe e e elementos da ViewHolder
    public static class ViewHolder {
        EditText editNome;
        EditText editCpf;
        EditText editDataNascimento;
        EditText editEmail;
        EditText editEndereco;
        EditText editTelefone;
        Button btSalvar;
    }
}