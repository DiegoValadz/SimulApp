package com.diego.simulacion.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

import com.diego.simulacion.R;
import com.diego.simulacion.models.Element;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by diego on 26/02/2018.
 */

public class IntegrantesAdapter extends RecyclerView.Adapter<IntegrantesAdapter.MyIntegrantesViewHolder> {
    private List<Element> elements;

    public IntegrantesAdapter(List<Element> elements) {
        this.elements = elements;
    }

    @Override
    public MyIntegrantesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_integrantes_rv,parent,false);
        return new MyIntegrantesViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyIntegrantesViewHolder holder, int position) {
        holder.foto.setImageResource(elements.get(position).getImage());
        holder.nombre.setText(elements.get(position).getTitle());
        holder.puesto.setText(elements.get(position).getSubtitle());

    }

    @Override
    public int getItemCount() {
        return elements.size();
    }

    public class MyIntegrantesViewHolder extends RecyclerView.ViewHolder {
        private CircleImageView foto;
        private TextView nombre,puesto;

        public MyIntegrantesViewHolder(View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.nombre);
            puesto = itemView.findViewById(R.id.funcion);
            foto = itemView.findViewById(R.id.prof_pic);
        }
    }
}
