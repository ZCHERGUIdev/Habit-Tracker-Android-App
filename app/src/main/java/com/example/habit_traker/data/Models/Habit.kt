package com.example.habit_traker.data.Models

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "habit_table")
data class Habit (
    @PrimaryKey(autoGenerate = true)
    val id :Int,
    val habit_title:String,
    val habit_description :String,
    val start_Time:String,
    val habit_image:Int
        ):Parcelable