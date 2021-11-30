package com.esprit.koorafan.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.esprit.koorafan.R;
import com.esprit.koorafan.adapters.FavoriteAdapter;
import com.esprit.koorafan.adapters.TeamAdapter;
import com.esprit.koorafan.database.AppDataBase;
import com.esprit.koorafan.entity.Team;

import java.util.ArrayList;
import java.util.List;

public class FavoriteFragment extends Fragment {
    private RecyclerView recyclerFav;
    private FavoriteAdapter Adapter;

    private List<Team> teams = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.favorites_fragment, container, false);
        recyclerFav = root.findViewById(R.id.recylerFav);

        teams = AppDataBase.getInstance(getActivity()).teamDao().getAll();

        Adapter = new FavoriteAdapter(teams, getActivity());

        recyclerFav.setAdapter(Adapter);

        recyclerFav.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));

        return root;
    }
}
