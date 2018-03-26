package com.diego.simulacion.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.diego.simulacion.R;
import com.diego.simulacion.adapters.IntegrantesAdapter;
import com.diego.simulacion.models.Element;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class IntegrantesFragment extends Fragment {

    private RecyclerView recyclerView;
    private IntegrantesAdapter adapter;
    private List<Element> elements = new ArrayList<>();



    public IntegrantesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_integrantes, container, false);
        setElements();
        recyclerView = v.findViewById(R.id.integrantes_rv);
        adapter = new IntegrantesAdapter(elements);
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(llm);
        return v;

    }

    private void setElements() {
        //Diego
        elements.add(new Element("Alumno: Diego Valadez Olmos","Participación: Programación Android",R.drawable.diego));
        //Raygoza
        elements.add(new Element("Alumno: Héctor Eduardo Raygoza Aguirre","Participación: Programación Lógica",R.drawable.ray));
        //Mau
        elements.add(new Element("Alumno: Mauricio David Martínez Aguilar","Participación: Reporte y diseño",R.drawable.mau));
        //Ismael
        elements.add(new Element("Alumno: Ismael de Jesús Rocha Romero","Participación: Manual de usuario y diseño",R.drawable.ismael));
    }

}
