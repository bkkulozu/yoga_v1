package com.example.kulozubeste;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class BottomFragment extends Fragment {

    ImageView frgBottomImg;
    int[] imgIds = new int[]{R.drawable.advancedtile, R.drawable.balancetile, R.drawable.weighttile};

    //int[] imgIds = new int[]{R.drawable.yadvanced, R.drawable.ysport, R.drawable.yweight};

    public BottomFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bottom, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        frgBottomImg = view.findViewById(R.id.frgBottomImg);
    }

    //STEP 7
    //Implenet changeCityImage(position) method,
    // so that mainActivity can call it to chane the image according to postin value
    //position value is sent from TopActivity to MainActivity
    //then sent from MainActivity to BottomFragment
    void changeCityImage(int position){
        frgBottomImg.setImageResource(imgIds[position]);
    }
}