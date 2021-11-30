package com.esprit.koorafan.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;


@Entity(tableName = "team_table")
public class Team {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "image")
    private int image;

    @ColumnInfo(name = "team_name")
    private String teamName;

    @Ignore
    public Team() {
    }

    public Team(int id, int image, String teamName) {
        this.id = id;
        this.image = image;
        this.teamName = teamName;
    }
    @Ignore
    public Team(int image, String teamName) {
        this.image = image;
        this.teamName = teamName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", image=" + image +
                ", teamName='" + teamName + '\'' +
                '}';
    }
}
