package com.example.habit_traker.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.habit_traker.data.Models.Habit
import com.example.habit_traker.logic.dao.habitDao


@Database(entities = [Habit::class],version = 1 ,exportSchema = false)
abstract class DataBase:RoomDatabase() {
    abstract fun habitDao():habitDao

    companion object{
        @Volatile
       private var INSTANCE :DataBase?=null
        fun getDb(context: Context):DataBase{
          val tmpInstan= INSTANCE

            if (tmpInstan!=null){
                return tmpInstan
            }
            synchronized(this){
                var instance = Room.databaseBuilder(
                    context.applicationContext,
                    DataBase::class.java,
                    "habit_database"
                ).build()
                INSTANCE=instance
                return instance
            }

        }
    }
}