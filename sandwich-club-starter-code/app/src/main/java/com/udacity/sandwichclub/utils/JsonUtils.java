package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONException;
import org.json.JSONObject;




public class JsonUtils {
    public static Sandwich parseSandwichJson(String json) throws JSONException {

        if (json==null)
            return null;

        JSONObject obj = jsonObject(json);
        Sandwich sandwich = new Sandwich();

        sandwich.setMainName(obj.getJSONObject("name").optString("mainName"));

        sandwich.setAlsoKnownAs(obj.getJSONObject("name")
                .optJSONArray("alsoKnownAs"));

        sandwich.setPlaceOfOrigin(obj.optString("placeOfOrigin"));

        sandwich.setDescription(obj.optString("description"));

        sandwich.setImage(obj.optString("image"));

        sandwich.setIngredients(
                obj.getJSONArray("ingredients")
                );


        return sandwich;
    }

    public static JSONObject jsonObject(String json){

        try {
            JSONObject obj =new JSONObject(json);
            return obj;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }

    }
}
