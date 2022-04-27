package br.senai.sp.cotia.todolistapp.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import br.senai.sp.cotia.todolistapp.model.Tarefa;

@Database(entities = {Tarefa.class}, version = 1)
public abstract class AppDataBase extends RoomDatabase {
    // variavel para acessar a database
    private static AppDataBase database;
    //método para tarefa Dao
    public abstract TarefaDao getTarefaDao();

    public static AppDataBase getDatabase(Context context){
        //verifico se a database é null
        if(database == null){
            //instanciar a database
            database = Room.databaseBuilder(context.getApplicationContext(), AppDataBase.class, "todolist").build();
        }
        //retorna a database
        return database;
    }
}
