package com.example.activityandfragments;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView list;
    Button addTabButton;
    EditText animalNameEditText,animalBiographyEditText;
    Bitmap selectedAnimalImage;
    ArrayList<AnimalModalClass> arrayList;
    ListViewAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = findViewById(R.id.list);
        addTabButton = findViewById(R.id.addTabButton);
        animalNameEditText = findViewById(R.id.nameEditText);
        animalBiographyEditText = findViewById(R.id.biographyEditText);

        arrayList = new ArrayList<>();
        adapter = new ListViewAdapter(this,arrayList);
        list.setAdapter(adapter);
    }


    public void addToList(View view)
    {

        if(validate()) {
            if(arrayList.size()<4) {
                String animalName = animalNameEditText.getText().toString();
                String animalBiography = animalBiographyEditText.getText().toString();

                arrayList.add(new AnimalModalClass(selectedAnimalImage, animalName, animalBiography));
                adapter.notifyDataSetChanged();
            }
           else
            {
                Toast.makeText(this,getString(R.string.item_count_warning),Toast.LENGTH_SHORT).show();
            }
        }
        clearAllInput();
    }


    public boolean validate()
    {
        if(animalNameEditText.getText().toString().isEmpty())
        {
            Toast.makeText(this,getString(R.string.empty_animal_name_error),Toast.LENGTH_SHORT).show();
            return false;
        }
        else if(animalBiographyEditText.getText().toString().isEmpty())
        {
            Toast.makeText(this,getString(R.string.animal_biography_error),Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    protected void selectImage(View view)
    {
        if(((BitmapDrawable)((ImageView)view).getDrawable()).getBitmap() == selectedAnimalImage)
            selectedAnimalImage = null;
        else
             selectedAnimalImage = ((BitmapDrawable)((ImageView)view).getDrawable()).getBitmap();
    }

    public void clearAllInput()
    {
        animalNameEditText.setText("");
        animalBiographyEditText.setText("");
        selectedAnimalImage = null;
    }



    public void clearAll(View view) {
        arrayList.clear();
        clearAllInput();
        adapter.notifyDataSetInvalidated();
    }
}
