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
import com.example.clinicahands6.constantes.MedicoConstantes;
import com.example.clinicahands6.entity.MedicoEntity;
import com.example.clinicahands6.entity.RetornoEntity;
import com.example.clinicahands6.viewmodel.MedicoViewModel;


public class MedicoActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewHolder mViewHolder = new ViewHolder();

    // define a ViewModel Medico
    private MedicoViewModel mViewModel;
    private int mMedicoId = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Carrega o layout formulário de médicos a Activity Medico
        setContentView(R.layout.activity_medico);
        this.mViewModel = new ViewModelProvider(this).get(MedicoViewModel.class);

        //mepeia os elementos do layout formulario paciente
        this.mViewHolder.editNome = findViewById(R.id.edit_nome);
        this.mViewHolder.editCrmUf = findViewById(R.id.edit_crm_uf);
        this.mViewHolder.editCrmCodigo = findViewById(R.id.edit_crm_codigo);
        this.mViewHolder.btSalvar = findViewById(R.id.btSalvar);

        // escuta os eventos de click
        this.setListeners();
//        acompanha médico
        this.setObservers();

//        verifica se foram passados parâmetros extras para a activity
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
//          como houve passagem de parâmetros na intent estamos em no modo de edição de médico
//          assim buscamos o Id do médico
            this.mMedicoId = bundle.getInt(MedicoConstantes.MEDICOID);
            this.mViewModel.leMedico(this.mMedicoId);
        }
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

    private void setListeners() {
        // executa ao ser clicado botão salvar
        this.mViewHolder.btSalvar.setOnClickListener(this);
    }

    private void setObservers() {
        this.mViewModel.medico.observe(this, new Observer<MedicoEntity>() {
            @Override
            public void onChanged(MedicoEntity medico) {
                mViewHolder.editNome.setText(medico.getNome());
                mViewHolder.editCrmUf.setText(medico.getCrm_uf());
                mViewHolder.editCrmCodigo.setText(Integer.toString(medico.getCrm_codigo()));
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
        // obtem os valores dos campos do formulário
        String nome = this.mViewHolder.editNome.getText().toString();
        String crm_uf = this.mViewHolder.editCrmUf.getText().toString();
        int crm_codigo = Integer.parseInt(this.mViewHolder.editCrmCodigo.getText().toString());

        // instancia medico
        MedicoEntity medico = new MedicoEntity(this.mMedicoId, nome, crm_uf, crm_codigo);
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