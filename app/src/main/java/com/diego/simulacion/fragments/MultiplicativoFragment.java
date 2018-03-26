package com.diego.simulacion.fragments;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;
import com.diego.simulacion.R;
import com.diego.simulacion.adapters.MultiAdapter;
import com.diego.simulacion.controller.Multiplicativo;

/**
 * A simple {@link Fragment} subclass.
 */
public class MultiplicativoFragment extends SecondFragment  {

    private FloatingActionButton fab;
    private Multiplicativo multiplicativo;
    private RecyclerView recyclerView;
    private MultiAdapter adapter;
    private int pAux;
    public MultiplicativoFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_multiplicativo, container, false);
        fab = view.findViewById(R.id.fab_multi);
        recyclerView = view.findViewById(R.id.multi_rv);
        fab.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                crearAlertDialog();
            }

        });
        return view;
    }

    private void crearAlertDialog() {
        View v = LayoutInflater.from(getContext()).inflate(R.layout.alert_dialog_multi, null);
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        final EditText xo = v.findViewById(R.id.xo_edt);
        final EditText a = v.findViewById(R.id.a_edt);
        final EditText c = v.findViewById(R.id.c_edt);
        final EditText m = v.findViewById(R.id.m_edt);
        final EditText i = v.findViewById(R.id.i_edt);
        final EditText t = v.findViewById(R.id.t_edt);
        final RadioButton rP=v.findViewById(R.id.r_positivo);
        final RadioButton  rN=v.findViewById(R.id.r_negativo);;



        builder.setView(v);
        builder.setTitle("Generar Nuevos Números");
        builder.setMessage("Introduce los valores necesarios: ");

        Spinner spinner = v.findViewById(R.id.spinner_multi);
        ArrayAdapter<CharSequence> spinnerAdapter = ArrayAdapter
                .createFromResource(getContext(),R.array.p_array,android.R.layout.simple_spinner_item);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                pAux = Integer.parseInt((String) parent.getItemAtPosition(position));
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });

      builder.setPositiveButton("Crear", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {}
        });
        final AlertDialog alertDialog = builder.create();
        alertDialog.show();

        alertDialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //valor en int de edit text
                int xo_v, c_v, m_v, i_v,t_v,p_v;
                boolean cerrarDialog = false;
                try {
                    xo_v = Integer.parseInt(xo.getText().toString().trim());
                    c_v = Integer.parseInt(c.getText().toString().trim());
                    m_v = Integer.parseInt(m.getText().toString().trim());
                    i_v = Integer.parseInt(i.getText().toString().trim());
                    t_v = Integer.parseInt(t.getText().toString().trim());
                    p_v = pAux;

                    if(m_v>0){
                        if(xo_v%2 != 0 && xo_v%5!=0){
                            if (sonPrimosRelativos(xo_v,m_v)){
                                if(rP.isChecked()){
                                    multiplicativo = new Multiplicativo(xo_v,t_v,p_v,c_v,m_v,i_v);
                                    cerrarDialog = true;

                                }else if (rN.isChecked()){
                                    p_v=p_v*(-1);
                                    multiplicativo = new Multiplicativo(xo_v,t_v,p_v,c_v,m_v,i_v);
                                    cerrarDialog = true;
                                }

                            }else
                                Toast.makeText(getActivity(), "Xo debe ser primo relativo a m ", Toast.LENGTH_LONG).show();

                        }else
                            Toast.makeText(getActivity(), "Xo no debe ser divisible por 2 o 5 ", Toast.LENGTH_LONG).show();
                    }else
                        Toast.makeText(getActivity(), "Verifica que i y m sean valores positivos", Toast.LENGTH_LONG).show();

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
        if (multiplicativo != null) {
            adapter = new MultiAdapter(multiplicativo);
            LinearLayoutManager llm = new LinearLayoutManager(getContext());
            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager(llm);
        }

    }

    public boolean sonPrimosRelativos(int x, int y){

        boolean ans =false;
        int divisor;
        for (divisor=2;(divisor<=x)&&(divisor<=y);divisor++)
            if (((x%divisor)==0)&&((y%divisor)==0)){
                return ans;
            }

        ans = true;
        return ans;

    }



}
