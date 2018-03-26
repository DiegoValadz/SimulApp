package com.diego.simulacion.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.diego.simulacion.R;
import com.diego.simulacion.adapters.MainAdapter;
import com.diego.simulacion.models.Element;
import java.util.ArrayList;
import java.util.List;

public class MainFragment extends Fragment {

    private RecyclerView recyclerView;
    private MainAdapter adapter;
    private List<Element> elements = new ArrayList<>();

    public MainFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_main, container, false);
        setRecyclerValues();
        bindRecyvler(v);
        return v;

    }

    private void bindRecyvler(View view) {
        recyclerView = view.findViewById(R.id.main_rv);
        adapter = new MainAdapter(elements, getContext());
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(llm);
    }

    private void setRecyclerValues() {
        elements.add(new Element("Generación de números aleatorios ", "Método: Congruencial Mixto \nMétodo: Congruencial Multiplicativo "));
        elements.add(new Element("Conway","El juego de la vida"));
    }
}
