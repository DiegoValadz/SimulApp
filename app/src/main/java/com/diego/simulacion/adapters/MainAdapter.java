package com.diego.simulacion.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.diego.simulacion.R;
import com.diego.simulacion.activities.SecondActivity;
import com.diego.simulacion.models.Element;
import java.util.List;

/**
 * Created by diego on 18/02/2018.
 */

public class MainAdapter extends Adapter<MainAdapter.MainViewHolder> {

    private List<Element> elements;
    private Context context;

    public MainAdapter(List<Element> elements, Context context) {
        this.elements = elements;
        this.context = context;
    }

    @Override
    public MainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main_rv,parent,false);
        MainViewHolder vh = new MainViewHolder(v);

        return vh;
    }

    @Override
    public void onBindViewHolder(MainViewHolder holder, int position) {
        holder.title.setText(elements.get(position).getTitle());
        holder.desc.setText(elements.get(position).getDescription());

    }

    @Override
    public int getItemCount() {
        return elements.size();
    }

    public class MainViewHolder extends RecyclerView.ViewHolder {
        private TextView title,desc;

        public MainViewHolder(View itemView) {
            super(itemView);
            title= itemView.findViewById(R.id.titulo_item_rv);
            desc = itemView.findViewById(R.id.descp_item_rv);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, SecondActivity.class);
                    intent.putExtra("selector",getAdapterPosition());
                    context.startActivity(intent);
                }
            });

        }

    }
}
