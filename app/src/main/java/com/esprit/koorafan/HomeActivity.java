package com.esprit.koorafan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.widget.Button;

import com.esprit.koorafan.fragments.FavoriteFragment;
import com.esprit.koorafan.fragments.ProfileFragment;
import com.esprit.koorafan.fragments.TeamsFragment;

public class HomeActivity extends AppCompatActivity {
Button btnTeams,btnFavorites, btnProfile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btnTeams = findViewById(R.id.btnTeams);
        btnFavorites = findViewById(R.id.btnFavorites);
        btnProfile = findViewById(R.id.btnProfile);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_container,new TeamsFragment())
                .commit();



        btnTeams.setOnClickListener(v -> {
            changeFragment(new TeamsFragment(),"");
        });

        btnProfile.setOnClickListener(v -> {
            changeFragment(new ProfileFragment(),"");
        });

        btnFavorites.setOnClickListener(v -> {
            //To do
            changeFragment(new FavoriteFragment(),"");
        });



    }

    public void changeFragment(Fragment fragment,String tag){
        if (tag.isEmpty()){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container,fragment)
                    .commit();
        }else{
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container,fragment)
                    .addToBackStack(tag)
                    .commit();
        }
    }
}