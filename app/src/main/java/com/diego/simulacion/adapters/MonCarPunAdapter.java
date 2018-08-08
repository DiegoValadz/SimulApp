package com.diego.simulacion.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.diego.simulacion.R;
import com.diego.simulacion.models.ResultadoMontecarlo;

import java.text.DecimalFormat;
import java.util.List;

public class MonCarPunAdapter extends RecyclerView.Adapter<MonCarPunAdapter.MCPViewHolder> {
    private List puntos;
    private ResultadoMontecarlo r;

    public MonCarPunAdapter(List puntos) {
        this.puntos = puntos;
    }

    @Override
    public MCPViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_mont_puntos,parent,false);
        return new MonCarPunAdapter.MCPViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MCPViewHolder holder, int position) {
        r = (ResultadoMontecarlo) puntos.get(position);
        DecimalFormat fmt = new DecimalFormat("#.000000");
        holder.i.setText(String.valueOf(position+1));
        holder.x.setText(String.valueOf(fmt.format(r.getX())));
        holder.y.setText(String.valueOf(fmt.format(r.getY())));
        holder.r.setText(String.valueOf(fmt.format(r.getR())));
    }

    @Override
    public int getItemCount() {
        return puntos.size();
    }

    public class MCPViewHolder extends RecyclerView.ViewHolder {
        private TextView i,x,y,r;
        public MCPViewHolder(View itemView) {
            super(itemView);
            i = itemView.findViewById(R.id.itemi);
            x = itemView.findViewById(R.id.item_x);
            y = itemView.findViewById(R.id.item_y);
            r = itemView.findViewById(R.id.item_r);
        }
    }
}
