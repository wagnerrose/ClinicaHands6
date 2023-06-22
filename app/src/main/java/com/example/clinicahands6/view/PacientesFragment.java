package com.example.clinicahands6.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.clinicahands6.R;
import com.example.clinicahands6.databinding.FragmentPacientesBinding;
import com.example.clinicahands6.entity.PacienteEntity;
import com.example.clinicahands6.view.adaptar.PacienteAdaptar;
import com.example.clinicahands6.viewmodel.PacientesViewModel;

import java.util.List;

public class PacientesFragment extends Fragment {

    private FragmentPacientesBinding binding;

    private PacientesViewModel mViewModel;

    private ViewHolder mViewHolder = new ViewHolder();
    private PacienteAdaptar mAdaptar = new PacienteAdaptar();


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        this.mViewModel = new ViewModelProvider(this).get(PacientesViewModel.class);

        View root = inflater.inflate(R.layout.fragment_pacientes, container, false);
        //        instancia a RecyclerView
        this.mViewHolder.recyclerPacientes = root.findViewById(R.id.reclycler_list);
        //        Define um Layout
        this.mViewHolder.recyclerPacientes.setLayoutManager(new LinearLayoutManager(getContext()));
        //        define um adapter
        this.mViewHolder.recyclerPacientes.setAdapter(this.mAdaptar);
        //      Monitora a alteração dos dados
        this.observer();
//        carrega da lista de pacientes para a Fragment
        this.mViewModel.getList();
        return root;
    }
    private void observer() {
        this.mViewModel.listaPacientes.observe(getViewLifecycleOwner(), new Observer<List<PacienteEntity>>() {
            @Override
            public void onChanged(List<PacienteEntity> listaPacientes) {
                mAdaptar.preencheLista(listaPacientes);
            }
        });
    }

    private static class ViewHolder {
        RecyclerView recyclerPacientes;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}