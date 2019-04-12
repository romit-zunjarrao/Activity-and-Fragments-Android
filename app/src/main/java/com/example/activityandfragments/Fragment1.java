package com.example.activityandfragments;


import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

public class Fragment1 extends Fragment {

    ImageView animalImage;
    TextView animalName, animalBiography;
    Button nextButton;
    public Fragment1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment1, container, false);
        animalImage = view.findViewById(R.id.fragment1_image_View);
        animalName = view.findViewById(R.id.fragment1AnimalName);
        animalBiography = view.findViewById(R.id.fragment1AnimalBiography);
        nextButton = view.findViewById(R.id.fragment_next_button);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        return view;
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        populateView();
    }

    public void populateView()
    {
        Bundle b = getArguments();
        String name = b.getString("name");
        String biography = b.getString("biography");
        int image = b.getInt("image");
        animalName.setText(name);
        animalBiography.setText(biography);
        switch(image)
        {
            case 1: animalImage.setImageBitmap(BitmapFactory.decodeResource(getContext().getResources(), R.drawable.bird)); break;
            case 2: animalImage.setImageBitmap(BitmapFactory.decodeResource(getContext().getResources(), R.drawable.cat)); break;
            case 3: animalImage.setImageBitmap(BitmapFactory.decodeResource(getContext().getResources(), R.drawable.dog)); break;
            case 4: animalImage.setImageBitmap(BitmapFactory.decodeResource(getContext().getResources(), R.drawable.panther)); break;
            case 5: animalImage.setImageBitmap(BitmapFactory.decodeResource(getContext().getResources(), R.drawable.horse)); break;

        }
    }

}
