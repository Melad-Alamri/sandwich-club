package com.udacity.sandwichclub;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.udacity.sandwichclub.model.Sandwich;
import com.udacity.sandwichclub.utils.JsonUtils;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_POSITION = "extra_position";
    private static final int DEFAULT_POSITION = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ImageView ingredientsIv = findViewById(R.id.image_iv);
        TextView description = findViewById(R.id.description_tv);
        TextView origin = findViewById(R.id.origin_tv);
        TextView ingredients = findViewById(R.id.ingredients_tv);
        TextView alsoKnown = findViewById(R.id.also_known_tv);


        Intent intent = getIntent();
        if (intent == null) {
            closeOnError();
        }

        int position = intent.getIntExtra(EXTRA_POSITION, DEFAULT_POSITION);
        if (position == DEFAULT_POSITION) {
            // EXTRA_POSITION not found in intent
            closeOnError();
            return;
        }

        String[] sandwiches = getResources().getStringArray(R.array.sandwich_details);
        String json = sandwiches[position];
        Sandwich sandwich = null;
        try {
            sandwich = JsonUtils.parseSandwichJson(json);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (sandwich == null) {
            // Sandwich data unavailable
            closeOnError();
            return;
        }

        populateUI();
        Picasso.with(this)
                .load(sandwich.getImage())
                .into(ingredientsIv);

        setTitle(sandwich.getMainName());
        origin.append("\n"+sandwich.getPlaceOfOrigin());

        description.append("\n"+sandwich.getDescription());

        ingredients.append("\n"+printData(sandwich.getIngredients()));

        alsoKnown.append("\n"+printData(sandwich.getAlsoKnownAs()));



    }

    private void closeOnError() {
        finish();
        Toast.makeText(this, R.string.detail_error_message, Toast.LENGTH_SHORT).show();
    }

    private void populateUI() {

    }

    private String printData(JSONArray data){
        String print ="";

        for (int i=0 ;i<data.length();i++){

            print += data.opt(i)+", ";
        }

     return print;
    }
}
