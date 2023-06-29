package com.example.clinicahands6.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.clinicahands6.R;
import com.example.clinicahands6.entity.MedicoEntity;
import com.example.clinicahands6.viewmodel.MedicoViewModel;


public class MedicoActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewHolder mViewHolder = new ViewHolder();

    // define a ViewModel Medico
    private MedicoViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Carrega o layout formulário de médicos a Activity Medico
        setContentView(R.layout.activity_formulario_medico);
        this.mViewModel = new ViewModelProvider(this).get(MedicoViewModel.class);
        //mepeia os elementos do layout formulario paciente
        this.mViewHolder.editNome = findViewById(R.id.editNome);
        this.mViewHolder.editCrmUf = findViewById(R.id.editCrmUf);
        this.mViewHolder.editCrmCodigo = findViewById(R.id.editCrmCodigo);
        this.mViewHolder.btSalvar = findViewById(R.id.btSalvar);
        // escuta os eventos
        this.setListeners();
    }

    private void setListeners() {
        // executa ao ser clicado botão salvar
        this.mViewHolder.btSalvar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        // verifca qual botão foi clicado e executa algo
        // Verifica se botão Salvar foi clicado
        if (view.getId() == R.id.btSalvar) {
            // Encaminha os dados recebidos para a ViewModel Paciente tratar e validar
            this.HandleSalvar();
        }

    }

    private void HandleSalvar() {
        // obtem os valores dos campos do formulário
        String nome = this.mViewHolder.editNome.getText().toString();
        String crm_uf = this.mViewHolder.editCrmUf.getText().toString();
        int crm_codigo = Integer.parseInt(this.mViewHolder.editCrmCodigo.getText().toString());

        // instancia medico
        MedicoEntity medico = new MedicoEntity( nome, crm_uf,  crm_codigo);
        // encaminha os dados para ViewModel implementar as regras de negócio (validação dos dados,
        // adaptação e salvamento;
        this.mViewModel.salvar(medico);
    }

    public static class ViewHolder {

        EditText editNome;
        EditText editCrmUf;
        EditText editCrmCodigo;
        Button btSalvar;

    }
}