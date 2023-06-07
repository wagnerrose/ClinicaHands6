package com.example.clinicahands6.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.example.clinicahands6.R;
import com.example.clinicahands6.databinding.FragmentPacientesBinding;
import com.example.clinicahands6.viewmodel.PacienteViewModel;
import com.example.clinicahands6.viewmodel.PacientesViewModel;

public class PacientesFragment extends Fragment {

 //   private FragmentPacientesBinding binding;

    private PacienteViewModel mViewModel;

    private ViewHolder mViewHolder = new VieHolder();


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        PacientesViewModel pacientesViewModel =
                new ViewModelProvider(this).get(PacientesViewModel.class);


        View root = inflater.inflate(R.layout.fragment_medicos, container, false);

        //        instancia a RecyclerView

        //        Define um Layout

        //        define um adapter

        //      Monitora a alteração dos dados


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}