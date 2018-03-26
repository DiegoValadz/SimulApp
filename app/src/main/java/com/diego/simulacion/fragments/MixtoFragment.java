package com.diego.simulacion.fragments;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.diego.simulacion.R;
import com.diego.simulacion.adapters.MixtoAdapter;
import com.diego.simulacion.controller.Mixto;


public class MixtoFragment extends SecondFragment {

    private FloatingActionButton fab;
    private Mixto mixto;
    private RecyclerView recyclerView;
    private MixtoAdapter adapter;


    public void setMixto(Mixto mixto) {
        this.mixto = mixto;
    }

    public MixtoFragment() {


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_mixto, container, false);
        recyclerView = v.findViewById(R.id.mixto_rv);
        fab = v.findViewById(R.id.fab_mixto);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crearAlertDialog();
            }

        });


        return v;

    }

    private void crearAlertDialog() {
        View v = LayoutInflater.from(getContext()).inflate(R.layout.alert_dialog_mixto, null);
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setView(v);
        builder.setTitle("Generar Nuevos Números");
        builder.setMessage("Introduce los valores necesarios: ");

        final EditText xo = v.findViewById(R.id.xo_edt);
        final EditText a = v.findViewById(R.id.a_edt);
        final EditText c = v.findViewById(R.id.c_edt);
        final EditText m = v.findViewById(R.id.m_edt);
        final EditText i = v.findViewById(R.id.i_edt);

        builder.setPositiveButton("Crear", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {


            }
        });
        final AlertDialog alertDialog = builder.create();
        alertDialog.show();

        alertDialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //valor en int de edit text
                int xo_v, a_v, c_v, m_v, i_v;
                boolean cerrarDialog = false;
                try {
                    xo_v = Integer.parseInt(xo.getText().toString().trim());
                    a_v = Integer.parseInt(a.getText().toString().trim()); //valor en int de edit text
                    c_v = Integer.parseInt(c.getText().toString().trim());
                    m_v = Integer.parseInt(m.getText().toString().trim());
                    i_v = Integer.parseInt(i.getText().toString().trim());
                    if (xo_v > 0 && a_v > 0 && c_v > 0 && i_v > 0) {
                        if (m_v > xo_v && m_v > a_v && m_v > c_v) {
                            setMixto(new Mixto(xo_v, a_v, c_v, m_v, i_v));
                            cerrarDialog = true;
                        } else
                            Toast.makeText(getActivity(), "Introduce un módulo mayor que Xo,a,c", Toast.LENGTH_LONG).show();
                    } else
                        Toast.makeText(getActivity(), "Introduce valores mayores a 0 para Xo, a y c", Toast.LENGTH_LONG).show();

                } catch (NumberFormatException e) {
                    Toast.makeText(getContext(), "Asegurate de llenar todos los campos", Toast.LENGTH_LONG).show();
                }


                if (cerrarDialog)
                    alertDialog.dismiss();
                instanciarRecyclerView();
            }
        });


    }

    private void instanciarRecyclerView() {
        MixtoAdapter adapter = new MixtoAdapter(mixto);
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(llm);



    }
}