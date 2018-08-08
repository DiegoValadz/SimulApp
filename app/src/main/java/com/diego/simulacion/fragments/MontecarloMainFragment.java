package com.diego.simulacion.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.diego.simulacion.R;
import com.diego.simulacion.adapters.MonteCarloMainAdapter;
import com.diego.simulacion.models.Element;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class MontecarloMainFragment extends Fragment {

    private List<Element> elements;
    private RecyclerView recyclerView;
    private MonteCarloMainAdapter adapter;


    public MontecarloMainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_montecarlo_main, container, false);
        recyclerView = v.findViewById(R.id.mont_main_rv);
        setRecyclerValues();
        instanciarRecyclerView();
        return v;
    }

    private void setRecyclerValues() {
        elements = new ArrayList<>();

        elements.add(new Element(R.drawable.integral1));
        elements.add(new Element(R.drawable.integral2));
        elements.add(new Element(R.drawable.integral3));
        elements.add(new Element(R.drawable.integral4));
        elements.add(new Element(R.drawable.integral5));
    }
    private void instanciarRecyclerView() {
            adapter = new MonteCarloMainAdapter(elements);
            LinearLayoutManager llm = new LinearLayoutManager(getContext());
            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager(llm);
    }
}
