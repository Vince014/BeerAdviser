package com.example.sivin.spinner;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class MainActivity extends Activity {
    private BeerExpert expert = new BeerExpert();
    protected TextView brands;
    protected Spinner color;
    protected RatingBar rating;
    protected EditText comments;
    private String[] beerColors = { "Light", "Amber", "Brown", "Dark" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Get reference to the TextView, rating bar and comments field
        brands = (TextView) findViewById(R.id.textView_brands);
        rating = (RatingBar) findViewById(R.id.ratingBar);
        comments = (EditText) findViewById(R.id.editText_Comment);

        //Get reference to the Spinner and populate it with an adapter
        color = (Spinner) findViewById(R.id.spinner_beerColors);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, beerColors);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        color.setAdapter(adapter);

        //Get reference to the beer color picker button & set a listener
        Button button_ChooseBeer = (Button) findViewById(R.id.button_findBeer);
        button_ChooseBeer.setOnClickListener(updateSuggestions);

        //Get reference to the comments button & set a listener
        Button button_Save = (Button) findViewById(R.id.button_Save);
        button_Save.setOnClickListener(saveUserInput);
    }

    //Call when the user clicks the button --- Selects a color of beer
    public View.OnClickListener updateSuggestions = new View.OnClickListener(){
        public void onClick(View view) {
            //Get reference to the selected item in the spinner
            String beerType = String.valueOf(color.getSelectedItem());
            Log.d("OnClick", "Selected beer color");

            //Get recommendations from the BeerExpert class
            List<String> brandsList = expert.getBrands(beerType);
            StringBuilder brandsFormatted = new StringBuilder();
            for (String brand : brandsList) {
                brandsFormatted.append(brand).append('\n');
            }

            //Display the selected items
            brands.setText(brandsFormatted);

            //Get the user-made star rating and comments for the selected beer
            expert.loadUserFeedback(beerType, rating, comments);
        }
    };

    //Call when the user clicks the button --- Selects a color of beer
    public View.OnClickListener saveUserInput = new View.OnClickListener(){
        //The thing about this is that it's possible to highlight a different beer
        //without pressing "Find Beer" and save the information there.
        public void onClick(View view) {
            //Get reference to the selected item in the spinner
            String beerType = String.valueOf(color.getSelectedItem());
            Log.d("OnClick", "Selected beer color");

            //Get the user-made star rating and comments for the selected beer
            expert.saveUserFeedback(beerType, rating, comments);
        }
    };

}
