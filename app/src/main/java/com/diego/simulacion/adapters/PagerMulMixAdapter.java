package com.diego.simulacion.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.diego.simulacion.fragments.MixtoFragment;
import com.diego.simulacion.fragments.MultiplicativoFragment;

/**
 * Created by diego on 18/02/2018.
 */

public class PagerMulMixAdapter extends FragmentStatePagerAdapter {
    private int numeroTabs;
    public PagerMulMixAdapter(FragmentManager fm,int numeroTabs) {
        super(fm);
        this.numeroTabs =numeroTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new MixtoFragment();
            case 1:
                return new MultiplicativoFragment();
            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return numeroTabs;
    }
}
