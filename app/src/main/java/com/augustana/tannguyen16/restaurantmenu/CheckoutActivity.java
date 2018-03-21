package com.augustana.tannguyen16.restaurantmenu;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by tannguyen16 on 3/20/2018.
 */

public class CheckoutActivity extends Activity {
    private TextView appetizer;
    private TextView entree;
    private TextView dessert;

    private String[] appetizerList = {"Glazed Chicken Wing\n$5.00", "Honey-Garlic Meatball\n$4.00", "Avocado Salsa\n$3.00"};
    private String[] entreeList = {"Chili Braised Beef Noodle Bowl\n$5.00", "Fried Chicken Livers with Marinated Figs\n$4.00", "Beef Short Ribs Braised in Red Wine\n$3.00"};
    private String[] dessertList = {"Chantal's New York Cheesecake\n$5.00", "Chocolate Lovin Spooncake\n$4.00", "Classic Oreo Icebox\n$3.00"};

    private TextView totalCost;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.checkout_activity);

        String appetizerChange = readFromFile(CheckoutActivity.this, "appetizer.txt");
        String entreeChange = readFromFile(CheckoutActivity.this, "entree.txt");
        String dessertChange = readFromFile(CheckoutActivity.this, "dessert.txt");

        appetizer = (TextView) findViewById(R.id.textView3);
        entree = (TextView) findViewById(R.id.textView4);
        dessert = (TextView) findViewById(R.id.textView5);
        totalCost = (TextView) findViewById(R.id.textView7);

        Integer num1 = Integer.parseInt(appetizerChange) - 1;
        Integer num2 = Integer.parseInt(entreeChange) - 1;
        Integer num3 = Integer.parseInt(dessertChange) - 1;
        appetizer.setText(appetizerList[num1]);
        entree.setText(entreeList[num2]);
        dessert.setText(dessertList[num3]);

        Integer total = computeCost(num1+1) + computeCost(num2+1) + computeCost(num3+1);
        totalCost.setText("$"+total+".00");

    }
    private Integer computeCost(Integer number){
        switch(number){
            case 1:
                return 5;
            case 2:
                return 4;
            case 3:
                return 3;
            default:
                return 0;
        }
    }
    private String readFromFile(Context context, String name) {

        String ret = "";

        try {
            InputStream inputStream = context.openFileInput(name);

            if ( inputStream != null ) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String receiveString = "";
                StringBuilder stringBuilder = new StringBuilder();

                while ( (receiveString = bufferedReader.readLine()) != null ) {
                    stringBuilder.append(receiveString);
                }

                inputStream.close();
                ret = stringBuilder.toString();
            }
        }
        catch (FileNotFoundException e) {
            Log.e("login activity", "File not found: " + e.toString());
        } catch (IOException e) {
            Log.e("login activity", "Can not read file: " + e.toString());
        }

        return ret;
    }
}
