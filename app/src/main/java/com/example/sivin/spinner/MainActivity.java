package com.example.sivin.spinner;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class MainActivity extends Activity {
    private BeerExpert expert = new BeerExpert();
    private String[] beerColors = { "Light", "Amber", "Brown", "Dark" };
    public TextView brands;
    public Spinner color;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Get reference to the TextView
        brands = (TextView) findViewById(R.id.textView_brands);

        //Get reference to the Spinner...
        color = (Spinner) findViewById(R.id.spinner_beerColors);
        //.... and populate it with an Adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, beerColors);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        color.setAdapter(adapter);

        //Get reference to the button & set a listener
        Button button_ChooseBeer = (Button) findViewById(R.id.button_findBeer);
        button_ChooseBeer.setOnClickListener(updateSuggestions);

        //Get reference to the selected item in the spinner
        /*String beerType = String.valueOf(color.getSelectedItem());
        Log.d("Color", beerType);

        //Get recommendations from the BeerExpert class
        List<String> brandsList = expert.getBrands(beerType);
        StringBuilder brandsFormatted = new StringBuilder();
        for (String brand : brandsList) {
            brandsFormatted.append(brand).append('\n');
        }

        //Display the selected item
        brands.setText(brandsFormatted);*/

    }

    //Call when the user clicks the button
    public View.OnClickListener updateSuggestions = new View.OnClickListener(){
        public void onClick(View view) {
            //Get reference to the selected item in the spinner
            String beerType = String.valueOf(color.getSelectedItem());

            //Get recommendations from the BeerExpert class
            List<String> brandsList = expert.getBrands(beerType);
            StringBuilder brandsFormatted = new StringBuilder();
            for (String brand : brandsList) {
                brandsFormatted.append(brand).append('\n');
            }

            //Display the selected item
            brands.setText(brandsFormatted);
        }

    };
}
