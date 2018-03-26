package com.diego.simulacion.activities;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.diego.simulacion.R;
import com.diego.simulacion.fragments.AcercaDeFragment;
import com.diego.simulacion.fragments.IntegrantesFragment;
import com.diego.simulacion.fragments.MainFragment;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private Fragment fragment = new MainFragment();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navigationView = findViewById(R.id.nav_view);
        drawerLayout = findViewById(R.id.drawer_layout);
        setToolBar();
        setDefaultFragment();

        //Se implementa listener del Drawer
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                boolean fragmentTransaction = false;
                int select;
                switch (item.getItemId()) {
                    case R.id.menu_main:
                        fragment = new MainFragment();
                        fragmentTransaction = true;
                        break;
                    case R.id.proyecto_1:
                        select = 0;
                        intentSecondActivity(select);
                        break;
                    case R.id.integrantes:
                        fragment = new IntegrantesFragment();
                        fragmentTransaction = true;
                        break;
                    case R.id.acerca_de:
                        fragment = new AcercaDeFragment();
                        fragmentTransaction = true;
                        break;
                }
                if (fragmentTransaction) {
                    selectFragment(fragment,item);
                }
                return true;
            }
        });

    }

    private void setDefaultFragment() {
        MenuItem item = navigationView.getMenu().getItem(Menu.FIRST);
        selectFragment(new MainFragment(),item);
        item.setChecked(true);
    }

    //Manda un valor para seleccionar Fragments en SecondActivity
    private void intentSecondActivity(int s) {
        Intent intent = new Intent(this, SecondActivity.class);
        switch (s) {
            case 0:
                intent.putExtra("selector", s);
                startActivity(intent);
                break;
        }
    }
    //Asigna la toolbar
    public void setToolBar() {
        Toolbar toolbar = findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Menú principal");
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_home);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
    private void selectFragment(Fragment fragment, MenuItem item){
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.content_frame, fragment).commit();
        item.setChecked(true);
        getSupportActionBar().setTitle(item.getTitle());
        drawerLayout.closeDrawers();
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
