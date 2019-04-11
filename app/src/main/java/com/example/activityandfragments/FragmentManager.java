package com.example.activityandfragments;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class FragmentManager extends AppCompatActivity {

    ArrayList<AnimalModalClass> arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_manager);
        /*Intent intent = getIntent();
        Bundle b = intent.getExtras();
        arrayList = intent.getParcelableExtra(MainActivity.intentIdgit aentifier);
        Log.d("arrayList",arrayList.toString());*/

    }
}
