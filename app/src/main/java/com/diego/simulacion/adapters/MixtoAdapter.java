package com.diego.simulacion.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.diego.simulacion.R;
import com.diego.simulacion.controller.Mixto;


/**
 * Created by diego on 22/02/2018.
 */

public class MixtoAdapter extends RecyclerView.Adapter<MixtoAdapter.MixtoViewHolder> {
    private Mixto mixto;


    public MixtoAdapter(Mixto mixto) {
        this.mixto = mixto;
    }

    @Override
    public MixtoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rv_fragment,parent,false);
        return new MixtoViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MixtoViewHolder holder, int position) {
        int i [] = mixto.toArray();
        holder.iterTxt.setText(String.valueOf((position+1)));
        holder.numTxt.setText(String.valueOf(i[position]));
    }

    @Override
    public int getItemCount() {

        return mixto.getI();
    }

    public class MixtoViewHolder extends RecyclerView.ViewHolder {
        private TextView iterTxt,numTxt;
        public MixtoViewHolder(View itemView) {
            super(itemView);
            iterTxt = itemView.findViewById(R.id.iteracion_text);
            numTxt = itemView.findViewById(R.id.number_txt);

        }
    }
}
