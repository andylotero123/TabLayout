package com.andycode.tablayout.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.andycode.tablayout.R;
import com.andycode.tablayout.entidades.ComponenteVo;

import java.util.ArrayList;

public class AdapterLista extends RecyclerView.Adapter<AdapterLista.ViewHolderComponente> implements View.OnClickListener {

    ArrayList<ComponenteVo> listaComponentes;
    private View.OnClickListener listener;//Escuchador onClickListener para recyclerView

    //Constructor con parametro tipo ArrayList
    public AdapterLista(ArrayList<ComponenteVo> listaComponentes){
        this.listaComponentes = listaComponentes; //Inicializo atributo listaComponentes (ArrayList<ComponenteVo> listaComponentes;)
    }

    @NonNull
    @Override
    public AdapterLista.ViewHolderComponente onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        int layout = 0;
        layout = R.layout.lista_componentes;
        View vista = LayoutInflater.from(parent.getContext()).inflate(layout,null, false);
        vista.setOnClickListener(this); //Escuchador del onClickListener para recyclerView
        return new ViewHolderComponente(vista); //Retorno nueva vista
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterLista.ViewHolderComponente holder, int position) {

        holder.nombreComponente.setText(listaComponentes.get(position).getNombreComponente());
        holder.infoComponente.setText(listaComponentes.get(position).getInfoComponente());
        holder.imagenComponente.setImageResource(listaComponentes.get(position).getImagenComponente());
    }

    @Override
    public int getItemCount() {
        return listaComponentes.size();
    }

    //TODO: metodo para evento onClickListener
    public void setOnClickListener(View.OnClickListener listener){
        this.listener = listener; //inicializo el atributo listiner
    }

    @Override
    public void onClick(View view) {
        if(listener != null){
            listener.onClick(view);
        }
    }

    public class ViewHolderComponente extends RecyclerView.ViewHolder {

        //Creo los componentes para la lista_procesador_amd
        TextView nombreComponente, infoComponente;
        ImageView imagenComponente;

        public ViewHolderComponente(@NonNull View itemView) {
            super(itemView);

            //Referencio los componentes de la lista_procesador_amd
            nombreComponente = itemView.findViewById(R.id.nombreComponente);
            infoComponente = itemView.findViewById(R.id.infoComponente);
            imagenComponente = itemView.findViewById(R.id.imageComponente);
        }
    }
}
