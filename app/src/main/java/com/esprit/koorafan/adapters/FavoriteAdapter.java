package com.esprit.koorafan.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.esprit.koorafan.R;
import com.esprit.koorafan.database.AppDataBase;
import com.esprit.koorafan.entity.Team;

import java.util.List;

public class FavoriteAdapter extends RecyclerView.Adapter<FavoriteAdapter.FavoriteViewHolder> {

    private List<Team> teamList;
    private Context mContext;

    public FavoriteAdapter(List<Team> teamList, Context mContext) {
        this.teamList = teamList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public FavoriteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(mContext).inflate(R.layout.single_row_favorite, parent, false);
        return new FavoriteViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(@NonNull FavoriteViewHolder holder, int position) {

        Team singleItem = teamList.get(position);

        holder.teamName.setText(singleItem.getTeamName());

        holder.teamImg.setImageResource(singleItem.getImage());

        holder.deleteBtn.setOnClickListener(view ->{
            AppDataBase.getInstance(mContext).teamDao().deleteTeam(singleItem);
            teamList.remove(position);
            notifyDataSetChanged();
        });

    }

    @Override
    public int getItemCount() {
        return teamList.size();
    }

    class FavoriteViewHolder extends RecyclerView.ViewHolder {

        private ImageView teamImg,deleteBtn;
        private TextView teamName;

        public FavoriteViewHolder(@NonNull View itemView) {
            super(itemView);

            teamName = itemView.findViewById(R.id.teamName);
            teamImg = itemView.findViewById(R.id.teamImg);
            deleteBtn = itemView.findViewById(R.id.deleteBtn);

        }
    }
}
