package com.example.activityandfragments;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.Button;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class FragmentManager extends AppCompatActivity implements Fragment1.FirstFragmentNavigationHandler,
Fragment2.SecondFragmentNavigationHandler, Fragment3.ThirdFragmentNavigationHandler, Fragment4.FourthFragmentNavigationHandler{

    ArrayList<AnimalModalClass> arrayList;
    JSONArray jsonArray;
    Button fragment1, fragment2, fragment3, fragment4;
    Fragment2 fragment2View;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_manager);
        Intent intent = getIntent();
        String s = intent.getStringExtra("json");

        fragment1 = findViewById(R.id.fragment1Button);
        fragment2 = findViewById(R.id.fragment2Button);
        fragment3 = findViewById(R.id.fragment3Button);
        fragment4 = findViewById(R.id.fragment4Button);

        //if List has only 1 item so only 1 fragment will be visible and rest of them will be made visible if the list increases
        fragment2.setVisibility(View.GONE);
        fragment3.setVisibility(View.GONE);
        fragment4.setVisibility(View.GONE);

        try {
            jsonArray = new JSONArray(s);


            Bundle args = new Bundle();
            JSONObject jsonObject1 = jsonArray.getJSONObject(0);

            if(jsonArray.length() > 1)
            {
                makeButtonVisible(jsonArray.length());
                initializationCode(jsonArray.length(),jsonArray);
            }

            fragment1.setText(jsonObject1.getString("animalName"));
            args.putString("name",jsonObject1.getString("animalName"));
            args.putString("biography",jsonObject1.optString("animalBiography"));
            args.putInt("image",jsonObject1.optInt("animalImage"));
            args.putInt("size",jsonArray.length());
            Fragment1 fragment = new Fragment1();
            fragment.setArguments(args);
            getSupportFragmentManager().beginTransaction().add(R.id.frameLayout,fragment).commit();

            fragment1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    initializeFragment1(jsonArray);
                }
            });
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void initializeFragment1(JSONArray jsonArray)
    {
        JSONObject jsonObject1 = null;
        try {
            jsonObject1 = jsonArray.getJSONObject(0);
            Bundle args = new Bundle();
            args.putString("name",jsonObject1.getString("animalName"));
            args.putString("biography",jsonObject1.optString("animalBiography"));
            args.putInt("image",jsonObject1.optInt("animalImage"));
            args.putInt("size",jsonArray.length());
            Fragment1 fragment = new Fragment1();
            fragment.setArguments(args);
            getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,fragment).commit();
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

    //Method initialization Fragments based on the array Length
    public void initializationCode(int length, JSONArray array)
    {
        switch (length)
        {
            case 4: {fragment4Initialization(0); };
            case 3:{fragment3Initialization(0);};
            case 2: {
                int i=0;
                fragment2Initialization(i);
                break;
            }
        }
    }


    //method makes Button for the framents visible based on the array length
    public void makeButtonVisible(int length)
    {
        switch (length) {
            case 4:
                fragment4.setVisibility(View.VISIBLE);
            case 3:
                fragment3.setVisibility(View.VISIBLE);
            case 2:
                fragment2.setVisibility(View.VISIBLE);break;
        }
    }


    //Below are the initialization code for the fragments
    public void fragment2Initialization(int i)
    {
        final Bundle args = new Bundle();
        try {
            JSONObject jsonObject2 = jsonArray.getJSONObject(1);

            fragment2.setText(jsonObject2.getString("animalName"));

            args.putString("name",jsonObject2.getString("animalName"));
            args.putString("biography",jsonObject2.optString("animalBiography"));
            args.putInt("image",jsonObject2.optInt("animalImage"));
            args.putInt("size",jsonArray.length());

            if(i == 0) {
                fragment2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Fragment2 fragment2View = new Fragment2();
                        fragment2View.setArguments(args);
                        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, fragment2View).commit();
                    }
                });
            }
            else
            {
                Fragment2 fragment2View = new Fragment2();
                fragment2View.setArguments(args);
                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, fragment2View).commit();
            }
        } catch (JSONException e) {
            e.printStackTrace();

        }
    }



    public void fragment1Initialization(int flag)
    {
        try {
            JSONObject jsonObject1 = jsonArray.getJSONObject(0);
            Bundle args = new Bundle();
            args.putString("name",jsonObject1.getString("animalName"));
            args.putString("biography",jsonObject1.optString("animalBiography"));
            args.putInt("image",jsonObject1.optInt("animalImage"));
            args.putInt("size",jsonArray.length());
            Fragment1 fragment = new Fragment1();
            fragment.setArguments(args);
            getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,fragment).commit();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void fragment3Initialization(int flag)
    {
        final Bundle args = new Bundle();
        try {
            JSONObject jsonObject3 = jsonArray.getJSONObject(2);

            fragment3.setText(jsonObject3.getString("animalName"));

            args.putString("name",jsonObject3.getString("animalName"));
            args.putString("biography",jsonObject3.optString("animalBiography"));
            args.putInt("image",jsonObject3.optInt("animalImage"));
            args.putInt("size",jsonArray.length());
            if(flag == 0) {
                fragment3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Fragment3 fragment3 = new Fragment3();
                        fragment3.setArguments(args);
                        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, fragment3).commit();
                    }
                });
            }
            else
            {
                Fragment3 fragment3 = new Fragment3();
                fragment3.setArguments(args);
                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,fragment3).commit();
            }
        } catch (JSONException e) {
            e.printStackTrace();

        }
    }

    public void fragment4Initialization(int flag)
    {
        final Bundle args = new Bundle();
        try {
            JSONObject jsonObject4 = jsonArray.getJSONObject(3);
            fragment4.setText(jsonObject4.getString("animalName"));
            args.putString("name",jsonObject4.getString("animalName"));
            args.putString("biography",jsonObject4.optString("animalBiography"));
            args.putInt("image",jsonObject4.optInt("animalImage"));
            args.putInt("size",jsonArray.length());
            if(flag == 0) {
                fragment4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Fragment4 fragment4 = new Fragment4();
                        fragment4.setArguments(args);
                        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, fragment4).commit();
                    }
                });
            }
            else{
                Fragment4 fragment4 = new Fragment4();
                fragment4.setArguments(args);
                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, fragment4).commit();
            }

        } catch (JSONException e) {
            e.printStackTrace();

        }
    }


    //Below are interface Method for the 4 fragment
    @Override
    public void navigateFromFragment1() {
        int i=1;
        fragment2Initialization(i);
    }

    @Override
    public void navigateFromFragment2(int i) {
        if(i == 0)
            fragment1Initialization(1);
        else
            fragment3Initialization(1);
    }

    @Override
    public void navigateFromFragment3(int i) {
        if(i == 0)
            fragment2Initialization(1);
        else
            fragment4Initialization(1);
    }

    @Override
    public void navigateFromFragment4() {
        fragment3Initialization(1);
    }
}


