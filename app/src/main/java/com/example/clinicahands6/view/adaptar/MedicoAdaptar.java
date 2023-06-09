package com.example.clinicahands6.view.adaptar;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.clinicahands6.R;
import com.example.clinicahands6.entity.MedicoEntity;
import com.example.clinicahands6.view.listener.OnListClick;
import com.example.clinicahands6.view.viewholder.MedicoViewHolder;

import java.util.ArrayList;
import java.util.List;

public class MedicoAdaptar extends RecyclerView.Adapter<MedicoViewHolder> {

    private List<MedicoEntity> mList = new ArrayList<>();
    private OnListClick mListener;

    @NonNull
    @Override
    public MedicoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //        cria linha de apresentação de um paciente
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
//        associa o layout da linha a ser preechida
        View view = inflater.inflate(R.layout.linha_medico,parent, false);
        return new MedicoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MedicoViewHolder holder, int position) {
        //       atribui valores a linha
        holder.bind(this.mList.get(position), this.mListener);
    }

    @Override
    public int getItemCount() {
        return this.mList.size();
    }

    public void preencheLista(List<MedicoEntity> lista) {
        this.mList = lista;
//        notifica qdo os dados foram alterados
        notifyDataSetChanged();
    }

    public void attachListener(OnListClick listener) {
        this.mListener = listener;

    }
}
