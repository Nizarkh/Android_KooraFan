package com.esprit.koorafan.fragments;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.esprit.koorafan.MainActivity;
import com.esprit.koorafan.R;

public class ProfileFragment extends Fragment {

    private TextView MyName, MyEmail, MyAge;
    private Button btnLogout;
       private SharedPreferences mSharedPref;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.profile_fragment, container, false);
        btnLogout = root.findViewById(R.id.btnLogout);
        MyName = root.findViewById(R.id.MyName);
        MyEmail = root.findViewById(R.id.MyEmail);
        MyAge = root.findViewById(R.id.MyAge);

        //mSharedPref = getSharedPreferences(LoginActivity.sharedPrefFileName, MODE_PRIVATE);
        mSharedPref = getActivity().getSharedPreferences(MainActivity.sharedPrefFileName, Context.MODE_PRIVATE);

        MyName.setText(mSharedPref.getString("NAME", ""));
        MyEmail.setText(mSharedPref.getString("EMAIL", ""));
        MyAge.setText(mSharedPref.getString("AGE", ""));

        btnLogout.setOnClickListener(view -> {
            mSharedPref.edit().clear().apply();
           getActivity().finish();
        });
        return root;
    }
}
