package com.esprit.koorafan.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.esprit.koorafan.dao.TeamDao;
import com.esprit.koorafan.entity.Team;

@Database(entities = {Team.class}, version = 1, exportSchema = false)
public abstract class AppDataBase extends RoomDatabase {

    public static AppDataBase instance;

    public abstract TeamDao teamDao();

    public static AppDataBase getInstance(Context context){

        if (instance == null){
            instance = Room
                    .databaseBuilder(context, AppDataBase.class, "koora_db")
                    .allowMainThreadQueries()
                    .build();
        }

        return instance;
    }

}
