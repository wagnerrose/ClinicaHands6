package com.example.clinicahands6.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.clinicahands6.R;
import com.example.clinicahands6.constantes.PacienteConstantes;
import com.example.clinicahands6.databinding.FragmentPacientesBinding;
import com.example.clinicahands6.entity.PacienteEntity;
import com.example.clinicahands6.entity.RetornoEntity;
import com.example.clinicahands6.view.adaptar.PacienteAdaptar;
import com.example.clinicahands6.view.listener.OnListClick;
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
//        Monitora o click do nome do paciente para edição
        OnListClick listener = new OnListClick() {
            @Override
            public void onClick(int id) {
//              passando parametros para a activity
                Bundle bundle = new Bundle();
                bundle.putInt(PacienteConstantes.PACIENTEID, id);
                Intent intent = new Intent(getContext(), PacienteActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }

            @Override
            public void onDelete(int id) {
                mViewModel.delete(id);
                mViewModel.getList();
            }
        };

        this.mAdaptar.attachListener(listener);
        //      Monitora a observa a alteração dos dados
        this.observers();
//        carrega da lista de pacientes para a Fragment

        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
        this.mViewModel.getList();
    }

    private void observers() {
        this.mViewModel.listaPacientes.observe(getViewLifecycleOwner(), new Observer<List<PacienteEntity>>() {
            @Override
            public void onChanged(List<PacienteEntity> listaPacientes) {
//              qdo a lista for alterada será enviada ao adaptar
                mAdaptar.preencheLista(listaPacientes);
            }
        });
        this.mViewModel.retorno.observe(getViewLifecycleOwner(), new Observer<RetornoEntity>() {
            @Override
            public void onChanged(RetornoEntity retorno) {
//                informa o salvamento dos dados
                Toast.makeText(getContext(), retorno.mMensagem, Toast.LENGTH_SHORT).show();
//                caso tenha dado certo, encerra a activity senão continua na nela
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