package com.diego.simulacion.activities;

import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.diego.simulacion.R;
import com.diego.simulacion.adapters.PagerMulMixAdapter;

public class SecondActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private TabLayout tabLayout;
    private Toolbar toolbar;
    private FragmentStatePagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bindUI();// ViewPager,Toolbar
        Bundle bundle = getIntent().getExtras();
        if (bundle!=null) {
            int selector = bundle.getInt("selector");
            setTabText(selector);
            adapter = instanceAdapter(selector);
            viewPager.setAdapter(adapter);
            viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
            tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
                @Override
                public void onTabSelected(TabLayout.Tab tab) {
                    int pos = tab.getPosition();
                    viewPager.setCurrentItem(pos);
                }

                @Override
                public void onTabUnselected(TabLayout.Tab tab) {

                }

                @Override
                public void onTabReselected(TabLayout.Tab tab) {

                }
            });
        }
        else {
            Toast.makeText(getApplicationContext(), "Selecciona Nuevamente la simulacion", Toast.LENGTH_LONG).show();

        }

    }

    private void bindUI() {
        setContentView(R.layout.activity_second);
        viewPager = findViewById(R.id.view_pager);
        tabLayout = findViewById(R.id.tab_layout);
        toolbar = findViewById(R.id.second_toolbar);
        setSupportActionBar(toolbar);
    }
    //Devulve el adaptador segun el selector recibido de la MainActivity
    private FragmentStatePagerAdapter instanceAdapter(int selector) {
        switch (selector){
            case 0:
                return new PagerMulMixAdapter(getSupportFragmentManager(),tabLayout.getTabCount());
            default:
                return null;
        }
    }
    //Personaliza Tabs
    public void setTabText(int selector) {
        switch (selector){
            case 0:
                tabLayout.addTab(tabLayout.newTab().setText("Mixto"));
                tabLayout.addTab(tabLayout.newTab().setText("Multiplicativo"));
            break;
                default:
        }
        tabLayout.setTabGravity(tabLayout.GRAVITY_FILL);
    }
}
