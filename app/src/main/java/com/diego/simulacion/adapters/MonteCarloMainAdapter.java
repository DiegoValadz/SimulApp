package com.diego.simulacion.adapters;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.diego.simulacion.R;
import com.diego.simulacion.fragments.MonteCarloFragment;
import com.diego.simulacion.models.Element;
import com.diego.simulacion.utilities.Utilities;

import java.util.List;

public class MonteCarloMainAdapter extends RecyclerView.Adapter<MonteCarloMainAdapter.MMAdapter> {
    private List<Element> elements;

    public MonteCarloMainAdapter(List<Element> elements) {
        this.elements = elements;
    }

    @Override
    public MMAdapter onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_mont_main,parent,false);
        return new MonteCarloMainAdapter.MMAdapter(v);
    }

    @Override
    public void onBindViewHolder(MMAdapter holder, int position) {
        holder.integral.setImageResource(elements.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return elements.size();
    }

    public class MMAdapter extends RecyclerView.ViewHolder {
        private ImageView integral;
        public MMAdapter(View itemView) {
            super(itemView);
            integral = itemView.findViewById(R.id.integral_img);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Bundle bundle = new Bundle();
                    bundle.putInt("pos",getAdapterPosition());
                    MonteCarloFragment fragment = MonteCarloFragment.newInstance(bundle);
                    Utilities.changeFragment(R.id.containe_scnd,fragment,v.getContext(),Utilities.REPLACE,"Second_Fragment");

                }
            });
        }
    }
}
