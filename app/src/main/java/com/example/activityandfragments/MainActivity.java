package com.example.activityandfragments;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = findViewById(R.id.list);
        ArrayList<AnimalModalClass> arrayList = new ArrayList<>();
        arrayList.add(new AnimalModalClass(BitmapFactory.decodeResource(getResources(),R.drawable.bird),"Bird","Birds are Nice Creature"));
        arrayList.add(new AnimalModalClass(BitmapFactory.decodeResource(getResources(),R.drawable.cat),"Bird","Birds are Nice Creature"));
        arrayList.add(new AnimalModalClass(BitmapFactory.decodeResource(getResources(),R.drawable.dog),"Bird","Birds are Nice Creature"));
        arrayList.add(new AnimalModalClass(BitmapFactory.decodeResource(getResources(),R.drawable.panther),"Bird","Birds are Nice Creature"));

        ListViewAdapter adapter = new ListViewAdapter(this,arrayList);
        list.setAdapter(adapter);
    }
}
