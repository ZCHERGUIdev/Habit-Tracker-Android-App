package com.example.habit_traker.logic.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.habit_traker.data.Models.Habit

@Dao
interface habitDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addHabit(habit:Habit)
    @Update
    suspend fun updateHabit(habit:Habit)
    @Delete
    suspend fun deleteHabit(habit:Habit)

    @Query("SELECT * FROM habit_table ORDER by id DESC")
    fun getAllHabits():LiveData<List<Habit>>
    @Query("DELETE From habit_table")
    suspend fun deleteALL()


}