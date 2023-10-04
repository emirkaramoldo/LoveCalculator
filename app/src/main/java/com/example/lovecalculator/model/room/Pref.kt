package com.example.lovecalculator.model.room

import android.content.SharedPreferences
import javax.inject.Inject

class Pref @Inject constructor(private val sharedPreferences: SharedPreferences) {
    fun isOnBoardShowed():Boolean{
        return sharedPreferences.getBoolean("key", false)
    }

    fun onBoardShowed(){
        sharedPreferences.edit().putBoolean("key", true).apply()
    }
}