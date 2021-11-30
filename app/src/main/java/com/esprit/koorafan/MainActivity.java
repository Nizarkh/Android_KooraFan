package com.esprit.koorafan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText MyName,MyEmail,MyAge,MyPassword;
CheckBox cbRememberMe;
Button btnNext;
    private SharedPreferences mSharedPref;
    // Nom de fichier de données
    public static final String sharedPrefFileName = "com.esprit.koora.file1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyName = findViewById(R.id.MyName);
        MyEmail = findViewById(R.id.MyEmail);
        MyAge = findViewById(R.id.MyAge);
        MyPassword = findViewById(R.id.MyPassword);
        cbRememberMe = findViewById(R.id.cbRememberMe);
        btnNext = findViewById(R.id.btnNext);


        mSharedPref = getSharedPreferences(sharedPrefFileName, MODE_PRIVATE);

//Set les valeur des champs par default lors du la 1ére exucution
        MyName.setText(mSharedPref.getString("NAME", ""));
        MyEmail.setText(mSharedPref.getString("EMAIL", ""));
        MyAge.setText(mSharedPref.getString("AGE", ""));
        MyPassword.setText(mSharedPref.getString("PASSWORD", ""));
        cbRememberMe.setChecked(mSharedPref.getBoolean("REMEMBERED", false));

        btnNext.setOnClickListener(view -> {
            if (validate()) {

                if (cbRememberMe.isChecked()) {

                    //  Log.e("user signedIn", tempUser.toString());

                    //Permet de modifier le fichier de donnée local storage "shared preference"
                    SharedPreferences.Editor editor = mSharedPref.edit();

                    editor.putString("NAME", MyName.getText().toString());
                    editor.putString("EMAIL", MyEmail.getText().toString());
                    editor.putString("AGE", MyAge.getText().toString());
                    editor.putString("PASSWORD", MyPassword.getText().toString());
                    editor.putBoolean("REMEMBERED", cbRememberMe.isChecked());

                    editor.apply();
                    Intent mainIntent = new Intent(MainActivity.this,
                            HomeActivity.class);
                    startActivity(mainIntent);
                   finish();


                } else {
                    //supprime tous les données du fichier shared preference
                    mSharedPref.edit().clear().apply();
                }


            }
        });
    }
    private boolean validate(){

        if(MyName.getText().toString().isEmpty()) {
            Toast.makeText(MainActivity.this,"Enter your Name !",Toast.LENGTH_SHORT).show();
            return false;
        }if(MyEmail.getText().toString().isEmpty()) {
            Toast.makeText(MainActivity.this, "Enter your Email !", Toast.LENGTH_SHORT).show();
            return false;
        }if(MyAge.getText().toString().isEmpty()) {
            Toast.makeText(MainActivity.this, "Enter your Age !", Toast.LENGTH_SHORT).show();
            return false;
        } if(MyPassword.getText().toString().isEmpty()) {
            Toast.makeText(MainActivity.this, "Enter your Password !", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }
}