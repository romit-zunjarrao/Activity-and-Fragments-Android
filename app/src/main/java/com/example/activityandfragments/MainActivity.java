package com.example.activityandfragments;

import android.content.Intent;
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

import org.json.JSONArray;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView list;
    Button addTabButton;
    EditText animalNameEditText,animalBiographyEditText;
    int selectedAnimalImage;
    ArrayList<AnimalModalClass> arrayList;
    ListViewAdapter adapter;

    static final String intentIdentifier = "intentIdentifier";


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

        switch(view.getId())
        {
            case R.id.birdImage:if(selectedAnimalImage == 1) { selectedAnimalImage = 0;} else { selectedAnimalImage = 1;} break;
            case R.id.catImage: if(selectedAnimalImage == 2) { selectedAnimalImage = 0;} else { selectedAnimalImage = 2;} break;
            case R.id.dogImage: if(selectedAnimalImage == 3) { selectedAnimalImage = 0;} else { selectedAnimalImage = 3;} break;
            case R.id.pantherImage: if(selectedAnimalImage == 4) { selectedAnimalImage = 0;} else { selectedAnimalImage = 4;} break;
            case R.id.horseImage: if(selectedAnimalImage == 5) { selectedAnimalImage = 0;} else { selectedAnimalImage = 5;} break;
        }

    }

    public void clearAllInput()
    {
        animalNameEditText.setText("");
        animalBiographyEditText.setText("");
        selectedAnimalImage = 0;
    }



    public void clearAll(View view) {
        arrayList.clear();
        clearAllInput();
        adapter.notifyDataSetInvalidated();
    }

    public void createTabs(View view) {
        Intent intent = new Intent(this,FragmentManager.class);
        Log.d("arrayList",arrayList.toString());
        JSONArray jsonArray = new JSONArray();
        for(int i=0;i<arrayList.size();i++)
        {
            jsonArray.put(arrayList.get(i).getJSONObject());
        }
        Log.d("json",""+jsonArray);

       //intent.putExtra(MainActivity.intentIdentifier,jsonArray.toString());
       intent.putExtra("json",""+jsonArray);
        startActivity(intent);
    }
}
