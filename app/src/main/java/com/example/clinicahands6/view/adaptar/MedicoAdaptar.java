package com.example.clinicahands6.view.adaptar;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.clinicahands6.entity.MedicoEntity;
import com.example.clinicahands6.view.viewholder.MedicoViewHolder;

import java.util.ArrayList;
import java.util.List;

public class MedicoAdaptar extends RecyclerView.Adapter<MedicoViewHolder> {

    private List<MedicoEntity> mList = new ArrayList<>();

    @NonNull
    @Override
    public MedicoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull MedicoViewHolder holder, int position) {

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
}
