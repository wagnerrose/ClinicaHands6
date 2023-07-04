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
import com.example.clinicahands6.constantes.MedicoConstantes;
import com.example.clinicahands6.databinding.FragmentMedicosBinding;
import com.example.clinicahands6.entity.MedicoEntity;
import com.example.clinicahands6.entity.RetornoEntity;
import com.example.clinicahands6.view.adaptar.MedicoAdaptar;
import com.example.clinicahands6.view.listener.OnListClick;
import com.example.clinicahands6.viewmodel.MedicosViewModel;

import java.util.List;

public class MedicosFragment extends Fragment {

    private FragmentMedicosBinding binding;
    private MedicosViewModel mViewModel;
    private ViewHolder mViewHolder = new ViewHolder();
    private MedicoAdaptar mAdaptar = new MedicoAdaptar();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        this.mViewModel = new ViewModelProvider(this).get(MedicosViewModel.class);
        View root = inflater.inflate(R.layout.fragment_medicos, container, false);
//        instancia a RecyclerView
        this.mViewHolder.recyclerMedicos = root.findViewById(R.id.reclycler_list);
//        Define um Layout
        this.mViewHolder.recyclerMedicos.setLayoutManager(new LinearLayoutManager(getContext()));
//        define um adapter
        this.mViewHolder.recyclerMedicos.setAdapter(this.mAdaptar);
//      Monitora o click na posição da lista de médicos para ativar modo de edição
        OnListClick listener = new OnListClick() {
            @Override
            public void onClick(int id) {
//              passando parametros para a activity
                Bundle bundle = new Bundle();
                bundle.putInt(MedicoConstantes.MEDICOID, id);
                Intent intent = new Intent(getContext(), MedicoActivity.class);
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


//      Monitora a alteração dos dados
        this.observers();

        return root;
    }

    private void observers() {
        this.mViewModel.listaMedicos.observe(getViewLifecycleOwner(), new Observer<List<MedicoEntity>>() {
            @Override
            public void onChanged(List<MedicoEntity> medicoEntities) {
//                Atualiza a lista de médicos após alteração percebida pelo observer
                mAdaptar.preencheLista(medicoEntities);
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
        RecyclerView recyclerMedicos;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}