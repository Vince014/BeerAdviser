/**
 * Created by Sidney on 2/8/2016.
 */

package com.example.sivin.spinner;
import android.widget.EditText;
import android.widget.RatingBar;

import java.util.ArrayList;
import java.util.List;

public class BeerExpert {
    protected float[] starRatings = { 0, 0, 0, 0 };
    protected String[] beerComments = { "comments?", "comments?", "comments?", "comments?" };

    List<String> getBrands(String color){
        List<String> brands = new ArrayList<String>();
        if (color.equals("Amber")){
            brands.add("Jack Amber");
            brands.add("Red Moose");
        }
        else{
            brands.add("Jail Pale Ale");
            brands.add("Gout Stout");
        }
        return brands;
    }

    void loadUserFeedback(String color, RatingBar rating, EditText comments){
        float userRating;
        String userComments;

        if (color.equals("Light")){
            userRating = starRatings[0];
            userComments = beerComments[0];
            rating.setRating(userRating);
            comments.setText(userComments);
        }
        if(color.equals("Amber")){
            userRating = starRatings[1];
            userComments = beerComments[1];
            rating.setRating(userRating);
            comments.setText(userComments);
        }
        if (color.equals("Brown")){
            userRating = starRatings[2];
            userComments = beerComments[2];
            rating.setRating(userRating);
            comments.setText(userComments);
        }
        if(color.equals("Dark")){
            userRating = starRatings[3];
            userComments = beerComments[3];
            rating.setRating(userRating);
            comments.setText(userComments);
        }
    }

    void saveUserFeedback(String color, RatingBar rating, EditText comments) {
        float userRating = rating.getRating();
        String userComments = comments.getText().toString();

        if (color.equals("Light")) {
            starRatings[0] = userRating;
            beerComments[0] = userComments;
        }
        if (color.equals("Amber")) {
            starRatings[1] = userRating;
            beerComments[1] = userComments;
        }
        if (color.equals("Brown")) {
            starRatings[2] = userRating;
            beerComments[2] = userComments;
        }
        if (color.equals("Dark")) {
            starRatings[3] = userRating;
            beerComments[3] = userComments;
        }
    }
}
