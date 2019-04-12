package com.example.activityandfragments;

import android.graphics.Bitmap;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

public class AnimalModalClass implements Serializable {
    //Bitmap animalImage;
    String animalName;
    String animalBiography;
    int animalImage;


    public String getAnimalName() {
        return animalName;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public String getAnimalBiography() {
        return animalBiography;
    }

    public void setAnimalBiography(String animalBiography) {
        this.animalBiography = animalBiography;
    }

    public int getAnimalImage() {
        return animalImage;
    }

    public void setAnimalImage(int animalImage) {
        this.animalImage = animalImage;
    }

    @Override
    public String toString() {
        return "AnimalModalClass{" +
                "animalName='" + animalName + '\'' +
                ", animalBiography='" + animalBiography + '\'' +
                ", animalImage=" + animalImage +
                '}';
    }

    public AnimalModalClass(int animalImage, String animalName, String animalBiography) {
        this.animalImage = animalImage;
        this.animalName = animalName;
        this.animalBiography = animalBiography;
    }

    public JSONObject getJSONObject() {
        JSONObject obj = new JSONObject();
        try {
            obj.put("animalName", animalName);
            obj.put("animalBiography", animalBiography);
            obj.put("animalImage", animalImage);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return obj;
    }
}
