package com.example.clinicahands6.view.viewholder;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.example.clinicahands6.R;
import com.example.clinicahands6.entity.PacienteEntity;
import com.example.clinicahands6.view.listener.OnListClick;

public class PacienteViewHolder extends RecyclerView.ViewHolder {

    private TextView mTextNome;
    private Context mContext;

    public PacienteViewHolder(@NonNull View itemView) {

        super(itemView);
//        mapeio o nome da linha
        this.mTextNome = itemView.findViewById(R.id.txt_nome);
        this.mContext = itemView.getContext();
    }

    public void bind(PacienteEntity paciente, OnListClick listener) {
        this.mTextNome.setText(paciente.getNome());
        this.mTextNome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                entra da edição do paciente
                listener.onClick(paciente.getId());
            }
        });
    this.mTextNome.setOnLongClickListener(new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {

//            cria uma caixa de dialogo para confirmação de remoção do paciente
            new AlertDialog.Builder(mContext)
                    .setTitle("Apaga Paciente")
                    .setMessage("Deseja apagar o Paciente?")
                    .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            listener.onDelete(paciente.getId());
                        }
                    })
                    .setNeutralButton("Não", null)
                    .show();

            return false;
        }
    });
    }
}
