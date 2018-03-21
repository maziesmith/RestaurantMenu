package com.augustana.tannguyen16.restaurantmenu;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * Created by tannguyen16 on 3/20/2018.
 */

public class EntreeFragment extends Fragment{
    View myView;
    private RadioButton radioButton;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        myView =  inflater.inflate(R.layout.fragment_entree, container, false);
        RadioGroup radioGroup = (RadioGroup) myView .findViewById(R.id.radioGroup);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // checkedId is the RadioButton selected
                switch(checkedId) {
                    case R.id.radioButton:
                        writeToFile("1", getActivity());
                        break;
                    case R.id.radioButton2:
                        writeToFile("2", getActivity());
                        break;
                    case R.id.radioButton3:
                        writeToFile("3", getActivity());
                        break;
                }
            }
        });
        return myView;
    }
    private void writeToFile(String data, Context context) {
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(context.openFileOutput("entree.txt", Context.MODE_PRIVATE));
            outputStreamWriter.write(data);
            outputStreamWriter.close();
            Log.d("Success", "Written to file");
        }
        catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
        }
    }

}
