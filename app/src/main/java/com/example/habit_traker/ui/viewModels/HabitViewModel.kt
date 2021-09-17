package com.example.habit_traker.ui.viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.habit_traker.data.Models.Habit
import com.example.habit_traker.data.database.DataBase
import com.example.habit_traker.logic.repository.HabitREpo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HabitViewModel(application: Application) :AndroidViewModel(application){
   private val habitRepo:HabitREpo
   val getAllHabit:LiveData<List<Habit>>

   init {
       val habitDao=DataBase.getDb(application).habitDao()
       habitRepo=HabitREpo(habitDao)
       getAllHabit=habitRepo.getAllHabbit
   }

    fun addHabit(habit: Habit){
        viewModelScope.launch(Dispatchers.IO) {
            habitRepo.addHabit(habit)
        }
    }

    fun updateHabit(habit: Habit){
        viewModelScope.launch(Dispatchers.IO) {
            habitRepo.updateHabit(habit)
        }
    }

    fun deleteHabit(habit: Habit){
        viewModelScope.launch(Dispatchers.IO) {
            habitRepo.deleteHabit(habit)
        }
    }

    fun deleteAllHabit(){
        viewModelScope.launch(Dispatchers.IO) {
            habitRepo.deleteAllHabit()
        }
    }


}