package com.diego.simulacion.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.diego.simulacion.R;
import com.diego.simulacion.models.ResultadoMontecarlo;

import java.util.List;

public class MonCarResAdapter extends RecyclerView.Adapter<MonCarResAdapter.MCAViewHolder> {
    private List montecarloList;
    private final int[] values ={100,200,500,1000};

    public MonCarResAdapter(List<ResultadoMontecarlo> montecarloList) {
        this.montecarloList = montecarloList;
    }

    @Override
    public MCAViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_mont_results,parent,false);
        return new MCAViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MCAViewHolder holder, int position) {
        holder.cant.setText(String.valueOf(values[position]));
        holder.res.setText(String.valueOf(montecarloList.get(position)));
    }

    @Override
    public int getItemCount() {
        return montecarloList.size();
    }

    public class MCAViewHolder extends RecyclerView.ViewHolder {
        private TextView cant,res;
        public MCAViewHolder(View itemView) {
            super(itemView);
            cant = itemView.findViewById(R.id.cant_txt);
            res = itemView.findViewById(R.id.res_txt);
        }
    }
}
