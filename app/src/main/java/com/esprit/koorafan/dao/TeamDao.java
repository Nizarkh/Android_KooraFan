package com.esprit.koorafan.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.esprit.koorafan.entity.Team;

import java.util.List;

@Dao
public interface TeamDao {

    @Insert
    void insertTeam(Team t);

    @Update
    void updateTeam(Team t);

    @Delete
    void deleteTeam(Team t);

    @Query("SELECT * FROM team_table ")
    List<Team> getAll();


}
