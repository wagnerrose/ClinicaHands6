package com.example.clinicahands6.view.viewholder;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.example.clinicahands6.R;
import com.example.clinicahands6.entity.MedicoEntity;
import com.example.clinicahands6.view.listener.OnListClick;

public class MedicoViewHolder extends RecyclerView.ViewHolder {

    private TextView mTextNome;
    private ImageView mImgDelete;
    private Context mContext;

    public MedicoViewHolder(@NonNull View itemView) {

        super(itemView);
//        mapeio o nome da linha
        this.mTextNome = itemView.findViewById(R.id.txt_nome);
        this.mImgDelete = itemView.findViewById(R.id.img_delete);

        this.mContext = itemView.getContext();
    }

    public void bind(MedicoEntity medico, OnListClick listener) {
        this.mTextNome.setText(medico.getNome());
        this.mTextNome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                entra da edição do medico
                listener.onClick(medico.getId());
            }
        });

//        Apaga com um click longo
        this.mTextNome.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

//            cria uma caixa de dialogo para confirmação de remoção do medico
                new AlertDialog.Builder(mContext)
                        .setTitle("Apaga Médico")
                        .setMessage("Deseja apagar o Médico?")
                        .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                listener.onDelete(medico.getId());
                            }
                        })
                        .setNeutralButton("Não", null)
                        .show();

                return false;
            }
        });
//        OU apaga clicando da lixeira
        this.mImgDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//            cria uma caixa de dialogo para confirmação de remoção do medico
                new AlertDialog.Builder(mContext)
                        .setTitle("Apaga Médico")
                        .setMessage("Deseja apagar o Médico?")
                        .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                listener.onDelete(medico.getId());
                            }
                        })
                        .setNeutralButton("Não", null)
                        .show();
            }
        });
    }
}

