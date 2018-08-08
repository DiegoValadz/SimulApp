package com.diego.simulacion.utilities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.diego.simulacion.activities.PagerActivity;
import com.diego.simulacion.activities.SecondActivity;

public class Utilities {

    public final static int ADD = 1;
    public final static int REPLACE = 2;

    public static Intent intent(Activity activity, int selector) {
        Intent intent = null;
        switch (selector) {
            case 0:
                intent = new Intent(activity, PagerActivity.class);
                intent.putExtra("selector", selector);
                break;
            case 1:
                intent = new Intent(activity, SecondActivity.class);
                intent.putExtra("selector", selector);
                break;

        }
        return intent;
    }

    public static void changeFragment(int container, Fragment fragment, Context context, int action, String tag) {
        AppCompatActivity activity = (AppCompatActivity) context;
        switch (action) {
            case ADD:
                activity.getSupportFragmentManager().beginTransaction().add(container, fragment, tag).commit();
                break;
            case REPLACE:
                activity.getSupportFragmentManager().beginTransaction().replace(container, fragment, tag).addToBackStack(null).commit();
                break;
        }
    }

    public static void changeFragment(int container, Fragment fragment, Context context, int action, MenuItem item) {
        AppCompatActivity activity = (AppCompatActivity) context;
        switch (action) {
            case ADD:
                activity.getSupportFragmentManager().beginTransaction().add(container, fragment).commit();
                activity.getSupportActionBar().setTitle(item.getTitle());
                break;
            case REPLACE:
                activity.getSupportFragmentManager().beginTransaction().replace(container, fragment).addToBackStack(null).commit();
                break;
        }
    }


}
