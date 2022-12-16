package com.andycode.tablayout.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.andycode.tablayout.R;
import com.andycode.tablayout.entidades.ComponenteVo;

public class FragmentDetalle extends Fragment {

    TextView nombreComponenteDetalle, infoComponenteDetalle;
    ImageView imagenComponenteDetalle;
    ComponenteVo componente = null; //Creo un objeto de la clase ComponenteVo
    NavController navController;

    public FragmentDetalle() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detalle, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View viewFragmentDetalle, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(viewFragmentDetalle, savedInstanceState);

        nombreComponenteDetalle = viewFragmentDetalle.findViewById(R.id.nombreComponenteDetalle);
        infoComponenteDetalle = viewFragmentDetalle.findViewById(R.id.infoComponenteDetalle);
        imagenComponenteDetalle = viewFragmentDetalle.findViewById(R.id.imagenComponenteDetalle);
        navController = Navigation.findNavController(viewFragmentDetalle); //creo el navegador entre fragments de tipo NavController

        componente = (ComponenteVo) getArguments().getSerializable("mi_dato");

        nombreComponenteDetalle.setText(componente.getNombreComponente());
        infoComponenteDetalle.setText(componente.getInfoComponente());
        imagenComponenteDetalle.setImageResource(componente.getImagenComponente());

/*        getParentFragmentManager().setFragmentResultListener("altavoz", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {

                componente = (ComponenteVo) result.getSerializable("mi_componente");

                nombreComponenteDetalle.setText(componente.getNombreComponente());
                infoComponenteDetalle.setText(componente.getInfoComponente());
                imagenComponenteDetalle.setImageResource(componente.getImagenComponente());
            }
        });*/
    }
}