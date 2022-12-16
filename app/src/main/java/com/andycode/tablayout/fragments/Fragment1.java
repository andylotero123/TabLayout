package com.andycode.tablayout.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.andycode.tablayout.R;
import com.andycode.tablayout.adapter.AdapterLista;
import com.andycode.tablayout.entidades.ComponenteVo;

import java.util.ArrayList;


public class Fragment1 extends Fragment {

    RecyclerView recyclerViewComponente;
    ArrayList<ComponenteVo> listaComponente;
    NavController navController;

    public Fragment1() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_1, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerViewComponente = view.findViewById(R.id.idReclerViewComponente);
        recyclerViewComponente.setLayoutManager(new LinearLayoutManager(getContext()));

        listaRecyclerView();
    }

    private void listaRecyclerView() {

        listaComponente = new ArrayList<>();
        AdapterLista adapterLista = new AdapterLista(listaComponente);
        recyclerViewComponente.setAdapter(adapterLista);

        listaComponente.add(new ComponenteVo("Altavoz Bluettoth JBL", "Es un altavoz de muy potente, resistente al agua", R.drawable.jbl_1));
        listaComponente.add(new ComponenteVo("Altavoz Bluettoth SONY", "Es un altavoz de muy potente, con gran bateria", R.drawable.sony_2));
        listaComponente.add(new ComponenteVo("Altavoz Bluettoth XIAOMI", "Bluetooth 5.1, resistente a salpicaduras de agua", R.drawable.xiaomi_3));
        listaComponente.add(new ComponenteVo("Altavoz Bluettoth CREATIVE", "Bluetooth 5.2, resistente al agua, gran bateria", R.drawable.creative_4));

        adapterLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //navController = Navigation.findNavController(view);
                Bundle enviarComponente = new Bundle();
                String dato = "AMD";
                enviarComponente.putSerializable("mi_dato", listaComponente.get(recyclerViewComponente.getChildAdapterPosition(view)));
                Navigation.findNavController(view).navigate(R.id.fragmentDetalle, enviarComponente);
                //enviarComponente.putSerializable("mi_componente", listaComponente.get(recyclerViewComponente.getChildAdapterPosition(view)));
                //getParentFragmentManager().setFragmentResult("altavoz", enviarComponente);
                //navController.navigate(R.id.fragmentDetalle);
            }
        });

    }
}