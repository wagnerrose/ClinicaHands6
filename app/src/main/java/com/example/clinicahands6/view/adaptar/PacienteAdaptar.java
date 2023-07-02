package com.example.clinicahands6.view.adaptar;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.clinicahands6.R;
import com.example.clinicahands6.entity.PacienteEntity;
import com.example.clinicahands6.view.listener.OnListClick;
import com.example.clinicahands6.view.viewholder.PacienteViewHolder;

import java.util.ArrayList;
import java.util.List;

public class PacienteAdaptar extends RecyclerView.Adapter<PacienteViewHolder> {

    private List<PacienteEntity> mList = new ArrayList<>();
    private OnListClick mListener;
    @NonNull
    @Override
    public PacienteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        cria linha de apresentação de um paciente
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
//        associa o layout da linha a ser preechida
        View view = inflater.inflate(R.layout.linha_paciente,parent, false);
        return new PacienteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PacienteViewHolder holder, int position) {
//       atribui valores a linha
        holder.bind(this.mList.get(position), this.mListener);

    }

    @Override
    public int getItemCount() {
        return this.mList.size();
    }

    public void preencheLista(List<PacienteEntity> lista) {
        this.mList = lista;
        // notifica o adaptar qdo os dados foram alterados
        // assim ele refaz a view com os novos dados
        notifyDataSetChanged();
    }

    public void attachListener(OnListClick listener) {
        this.mListener = listener;

    }
}
