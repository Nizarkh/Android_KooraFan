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
import com.esprit.koorafan.adapters.TeamAdapter;
import com.esprit.koorafan.entity.Team;

import java.util.ArrayList;
import java.util.List;

public class TeamsFragment extends Fragment {
    private RecyclerView recyclerView;
    private TeamAdapter teamAdapter;

    private List<Team> teams = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.teams_fragment, container, false);
        recyclerView = root.findViewById(R.id.recylerTeam);

        teams.add(new Team(1, R.drawable.barcelona, "FC Barcelona"));
        teams.add(new Team(2, R.drawable.chelsea, "chelsea"));
        teams.add(new Team(3, R.drawable.juventus, "juventus"));
        teams.add(new Team(4, R.drawable.liverpool, "liverpool"));
        teams.add(new Team(5, R.drawable.manchester_united, "manchester_united"));
        teams.add(new Team(6, R.drawable.real_madrid, "real_madrid"));
        teams.add(new Team(7, R.drawable.roma, "roma"));


        teamAdapter = new TeamAdapter(teams, getActivity());

        recyclerView.setAdapter(teamAdapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));

        return root;
    }
}
