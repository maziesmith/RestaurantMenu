package com.augustana.tannguyen16.restaurantmenu;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends Activity {

    private static final String TAB_KEY_INDEX = "tab_key";
    private Fragment appetizerFragment;
    private Fragment checkoutFragment;
    private Fragment dessertFragment;
    private Fragment entreeFragment;

    private RadioGroup radioGroup;
    private RadioButton radioButton;
    private Button btnDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        actionBar.setDisplayShowTitleEnabled(false);

        ActionBar.Tab appetizerTab = actionBar.newTab().setText(getString(R.string.ui_tabname_appetizer));
        ActionBar.Tab entreeTab = actionBar.newTab().setText(getString(R.string.ui_tabname_entree));
        ActionBar.Tab dessertTab = actionBar.newTab().setText(getString(R.string.ui_tabname_dessert));
        ActionBar.Tab checkoutTab = actionBar.newTab().setText(getString(R.string.ui_tabname_checkout));

        appetizerFragment = new AppetizerFragment();
        entreeFragment = new EntreeFragment();
        checkoutFragment = new CheckoutFragment();
        dessertFragment = new DessertFragment();

        appetizerTab.setTabListener(new MyTabsListener(appetizerFragment, getApplicationContext()));
        entreeTab.setTabListener(new MyTabsListener(entreeFragment, getApplicationContext()));
        checkoutTab.setTabListener(new MyTabsListener(checkoutFragment, getApplicationContext()));
        dessertTab.setTabListener(new MyTabsListener(dessertFragment, getApplicationContext()));


        actionBar.addTab(appetizerTab);
        actionBar.addTab(entreeTab);
        actionBar.addTab(dessertTab);
        //actionBar.addTab(checkoutTab);
        if(savedInstanceState!= null){
            actionBar.setSelectedNavigationItem(savedInstanceState.getInt(TAB_KEY_INDEX, 0));
        }
    }

    public void onButtonClick(View v){
        if(v.getId() == R.id.button){
            Intent i = new Intent(MainActivity.this, CheckoutActivity.class);
            startActivity(i);
        }
    }

}


class MyTabsListener implements ActionBar.TabListener{
    public Fragment fragment;

    public MyTabsListener(Fragment f, Context context){
        fragment = f;
    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft){

    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft){
        ft.replace(R.id.fragment_container, fragment);
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft){
        ft.remove(fragment);
    }

}