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
import com.example.clinicahands6.databinding.FragmentMedicosBinding;
import com.example.clinicahands6.entity.MedicoEntity;
import com.example.clinicahands6.view.adaptar.MedicoAdaptar;
import com.example.clinicahands6.viewmodel.MedicosViewModel;

import java.util.List;

public class MedicosFragment extends Fragment {

    private FragmentMedicosBinding binding;
    private MedicosViewModel mViewModel;
    private ViewHolder mViewHolder = new ViewHolder();
    private MedicoAdaptar mAdaptar = new MedicoAdaptar();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        MedicosViewModel medicosViewModel =
                new ViewModelProvider(this).get(MedicosViewModel.class);

        View root = inflater.inflate(R.layout.fragment_medicos, container, false);
//        instancia a RecyclerView
        this.mViewHolder.recyclerMedicos = root.findViewById(R.id.reclycler_list);
//        Define um Layout
        this.mViewHolder.recyclerMedicos.setLayoutManager(new LinearLayoutManager(getContext()));
//        define um adapter
        this.mViewHolder.recyclerMedicos.setAdapter(this.mAdaptar);
//      Monitora a alteração dos dados
        this.observer();

        return root;
    }

    private void observer() {
        this.mViewModel.listaMedicos.observe(getViewLifecycleOwner(), new Observer<List<MedicoEntity>>() {
            @Override
            public void onChanged(List<MedicoEntity> medicoEntities) {
                mAdaptar.preencheLista(medicoEntities);
            }
        });
    }

    private static class ViewHolder {
        RecyclerView recyclerMedicos;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}