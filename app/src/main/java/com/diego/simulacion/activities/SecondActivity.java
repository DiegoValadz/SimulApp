package com.diego.simulacion.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.diego.simulacion.R;
import com.diego.simulacion.fragments.MontecarloMainFragment;
import com.diego.simulacion.utilities.Utilities;

public class SecondActivity extends AppCompatActivity {

    private MontecarloMainFragment fragment;
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        fragment = new MontecarloMainFragment();
        setToolBar();
        Utilities.changeFragment(R.id.containe_scnd,fragment,this,Utilities.ADD,"Second_Fragment" );
    }

    public void setToolBar() {
        toolbar = findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("MonteCarloFragment");
    }
}
