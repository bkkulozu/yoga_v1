package com.example.kulozubeste;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

/**
 *  Beste Kulozu 214 00 474
 */
public class FragmentsActivity extends AppCompatActivity implements TopFragment.TopFragmentInterface{

        /*****************************************/
        //STEP 1
        //Spinner Event on TopFragment will change the image on BottomFragment
        //MainActivity will provide communication between them
        //So create objects from Both fragments
        TopFragment topFragment;
        BottomFragment bottomFragment;
        /*****************************************/
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragments);


        // Hiding title bar using code
        getSupportActionBar().hide();
        // Hiding the status bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        // Locking the orientation to Portrait
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        intent = getIntent();
        Bundle b = intent.getExtras();

            /*****************************************/
            //STEP 2
            //Create fragment objects
            topFragment = (TopFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentTop);
            bottomFragment = (BottomFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentBottom);
            /*****************************************/

    }

        //STEP 5B
        //TopFragmentInterface method is implemented
        //In this method main activity  can vall the methods of BottomActivity by using bottomFragment object
        @Override
        public void changeImage(int position) {
            bottomFragment.changeCityImage(position);
        }

    public void getAll(View view) {
        intent = new Intent(this, VolleyActivity.class);
        //  intent.putExtras(b);
        startActivity(intent);
    }

}
