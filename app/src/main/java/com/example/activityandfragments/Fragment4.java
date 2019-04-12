package com.example.activityandfragments;


import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class Fragment4 extends Fragment {

    ImageView animalImage;
    TextView animalName, animalBiography;
    Button previousButton;
    Fragment4.FourthFragmentNavigationHandler navigationHandler;
    interface FourthFragmentNavigationHandler{
        void navigateFromFragment4();
    }


    public Fragment4() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_blank, container, false);
        animalImage = view.findViewById(R.id.fragment4ImageView);
        animalName = view.findViewById(R.id.fragment4AnimalName);
        animalBiography = view.findViewById(R.id.fragment4AnimalBiography);
        previousButton = view.findViewById(R.id.fragment4PreviousButton);
        previousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigationHandler = (FourthFragmentNavigationHandler) getContext();
                navigationHandler.navigateFromFragment4();

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
        if(image != 0) {
            switch (image) {
                case 1:
                    animalImage.setImageBitmap(BitmapFactory.decodeResource(getContext().getResources(), R.drawable.bird));
                    break;
                case 2:
                    animalImage.setImageBitmap(BitmapFactory.decodeResource(getContext().getResources(), R.drawable.cat));
                    break;
                case 3:
                    animalImage.setImageBitmap(BitmapFactory.decodeResource(getContext().getResources(), R.drawable.dog));
                    break;
                case 4:
                    animalImage.setImageBitmap(BitmapFactory.decodeResource(getContext().getResources(), R.drawable.panther));
                    break;
                case 5:
                    animalImage.setImageBitmap(BitmapFactory.decodeResource(getContext().getResources(), R.drawable.horse));
                    break;

            }
        }
        else
        {
            animalImage.setVisibility(View.INVISIBLE);
        }
    }

}
