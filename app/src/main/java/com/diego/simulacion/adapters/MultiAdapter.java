package com.diego.simulacion.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.diego.simulacion.R;
import com.diego.simulacion.controller.Multiplicativo;

/**
 * Created by diego on 26/02/2018.
 */

public class MultiAdapter extends RecyclerView.Adapter<MultiAdapter.MultiViewHolder> {
    private Multiplicativo multiplicativo;

    public MultiAdapter(Multiplicativo multiplicativo) {
        this.multiplicativo = multiplicativo;
    }



    @Override
    public MultiViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rv_fragment,parent,false);
        return new MultiViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MultiViewHolder holder, int position) {
        int [] i = multiplicativo.toArray();
        holder.numTxt.setText(String.valueOf(i[position]));
        holder.iterTxt.setText(String.valueOf(position));
    }

    @Override
    public int getItemCount() {
        return multiplicativo.toArray().length;
    }

    public class MultiViewHolder extends RecyclerView.ViewHolder {
        private TextView iterTxt,numTxt;
        public MultiViewHolder(View itemView) {
            super(itemView);
            iterTxt = itemView.findViewById(R.id.iteracion_text);
            numTxt = itemView.findViewById(R.id.number_txt);
        }
    }
}
