package com.example.habit_traker.logic.repository

import androidx.lifecycle.LiveData
import com.example.habit_traker.data.Models.Habit
import com.example.habit_traker.logic.dao.habitDao

class HabitREpo (private var habitDAO: habitDao){

    val getAllHabbit:LiveData<List<Habit>> =habitDAO.getAllHabits()

    suspend fun addHabit(habit: Habit){
        habitDAO.addHabit(habit)
    }
    suspend fun updateHabit(habit: Habit){
        habitDAO.updateHabit(habit)
    }
    suspend fun deleteHabit(habit: Habit){
        habitDAO.deleteHabit(habit)
    }
    suspend fun deleteAllHabit(){
        habitDAO.deleteALL()
    }


}