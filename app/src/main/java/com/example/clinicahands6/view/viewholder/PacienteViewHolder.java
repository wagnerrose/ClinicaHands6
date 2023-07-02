package com.example.clinicahands6.view.viewholder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.clinicahands6.R;
import com.example.clinicahands6.entity.PacienteEntity;
import com.example.clinicahands6.view.listener.OnListClick;

public class PacienteViewHolder extends RecyclerView.ViewHolder {

    private TextView mTextNome;

    public PacienteViewHolder(@NonNull View itemView) {

        super(itemView);
//        mapeio o nome da linha
        this.mTextNome = itemView.findViewById(R.id.txt_nome);

    }

    public void bind(PacienteEntity paciente, OnListClick listener) {
        this.mTextNome.setText(paciente.getNome());
        this.mTextNome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(paciente.getId());
            }
        });

    }
}
