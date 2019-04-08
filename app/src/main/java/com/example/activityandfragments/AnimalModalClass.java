package com.example.activityandfragments;

import android.graphics.Bitmap;

public class AnimalModalClass {
    Bitmap animalImage;
    String animalName;
    String animalBiography;


    public AnimalModalClass(Bitmap animalImage, String animalName, String animalBiography) {
        this.animalImage = animalImage;
        this.animalName = animalName;
        this.animalBiography = animalBiography;
    }
}
