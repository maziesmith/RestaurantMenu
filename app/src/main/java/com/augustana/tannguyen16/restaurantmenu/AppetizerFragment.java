package com.augustana.tannguyen16.restaurantmenu;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

/**
 * Created by tannguyen16 on 3/20/2018.
 */

public class AppetizerFragment extends Fragment{
    View myView;
    private RadioButton radioButton;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        myView =  inflater.inflate(R.layout.fragment_appetizer, container, false);
        RadioGroup radioGroup = (RadioGroup) myView .findViewById(R.id.radioGroup);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // checkedId is the RadioButton selected

                switch(checkedId) {
                    case R.id.radioButton:

                    case R.id.radioButton2:
                        Log.d("Tan", "Tan2");
                    case R.id.radioButton3:
                        Log.d("Tan", "Tan3");;
                }
            }
        });
        return myView;
    }

}
