package com.diego.simulacion.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.diego.simulacion.R;
import com.diego.simulacion.adapters.MonCarPunAdapter;
import com.diego.simulacion.adapters.MonCarResAdapter;
import com.diego.simulacion.controller.Montecarlo;
import com.diego.simulacion.models.ResultadoMontecarlo;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class MonteCarloFragment extends Fragment {

    private Montecarlo montecarlo;
    private List puntos,res;
    private RecyclerView rvRes,rvPuntos;
    private MonCarResAdapter adapterRes;
    private MonCarPunAdapter adapterPun;
    private Button button;
    private LinearLayout linearLayout;


    public MonteCarloFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_monte_carlo, container, false);
        rvRes = v.findViewById(R.id.mont_result_rv);
        rvPuntos = v.findViewById(R.id.mont_result_rv2);
        button = v.findViewById(R.id.button_mon);
        linearLayout = v.findViewById(R.id.second_linear);
        instanciarMonteCarlo();
        istanciarRecycler();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linearLayout.setVisibility(View.VISIBLE);
                adapterPun = new MonCarPunAdapter(puntos);
                rvPuntos.setAdapter(adapterPun);
                rvPuntos.setLayoutManager(new LinearLayoutManager(getContext()));
            }
        });


        return v;
    }

    public void istanciarRecycler() {
        //switch (i){
           // case 0:
                adapterRes = new MonCarResAdapter(res);
                rvRes.setAdapter(adapterRes);
                rvRes.setLayoutManager(new LinearLayoutManager(getContext()));
              //  break;
           // case 1:

                //break;
      //  }
    }

    private void instanciarMonteCarlo() {
        if(getArguments()!=null){
            int select = getArguments().getInt("pos");
            switch (select){
                case 0:
                    montecarlo = new Montecarlo(0,1,0,1,0,1);
                    break;
                case 1:
                    montecarlo = new Montecarlo(0,0,1,0,0,1);
                    break;
                case 2:
                    montecarlo = new Montecarlo(1,0,0,2,0,2);
                    break;
                case 3:
                    montecarlo = new Montecarlo(Montecarlo.SENO, 0, Math.PI);
                    break;
                case 4:
                    montecarlo = new Montecarlo(Montecarlo.E, 1, 2);
                    break;
            }
            puntos = montecarlo.getListaPuntosAleatorios();
            res = montecarlo.getListaResultados();
        }
    }

    public static MonteCarloFragment newInstance(Bundle arguments){
        MonteCarloFragment aux = new MonteCarloFragment();
        if(arguments != null){
            aux.setArguments(arguments);
        }
        return aux;
    }
}
