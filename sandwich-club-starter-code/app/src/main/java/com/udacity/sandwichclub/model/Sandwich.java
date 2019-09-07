package com.udacity.sandwichclub.model;

import org.json.JSONArray;



public class Sandwich {

    private String mainName;
    private JSONArray alsoKnownAs = new JSONArray().put("Data not available");
    private String placeOfOrigin = "Data not available";
    private String description = "Data not available";
    private String image;
    private JSONArray ingredients = new JSONArray().put("Data not available");

    /**
     * No args constructor for use in serialization
     */
    public Sandwich() {
    }

    public Sandwich(String mainName, JSONArray alsoKnownAs, String placeOfOrigin, String description, String image, JSONArray ingredients) {
        this.mainName = mainName;
        this.alsoKnownAs = alsoKnownAs;
        this.placeOfOrigin = placeOfOrigin;
        this.description = description;
        this.image = image;
        this.ingredients = ingredients;
    }

    public String getMainName() {
        return mainName;
    }

    public void setMainName(String mainName) {
        this.mainName = mainName;
    }

    public JSONArray getAlsoKnownAs() {
        return alsoKnownAs;
    }

    public void setAlsoKnownAs(JSONArray alsoKnownAs) {
        if (!alsoKnownAs.isNull(0))this.alsoKnownAs = alsoKnownAs;
    }

    public String getPlaceOfOrigin() {
        return placeOfOrigin;
    }

    public void setPlaceOfOrigin(String placeOfOrigin) {
        if (placeOfOrigin!="")this.placeOfOrigin = placeOfOrigin;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public JSONArray getIngredients() {
       return ingredients;
    }

    public void setIngredients(JSONArray ingredients) {
        if (!ingredients.isNull(0))this.ingredients = ingredients;
    }


    }

