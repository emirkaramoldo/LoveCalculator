package com.example.lovecalculator.model.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.lovecalculator.model.LoveModel
@Dao
interface LoveDao {
    @Insert
    fun insert(loveModel: LoveModel)

    @Query("SELECT * FROM `love-table` ORDER BY id DESC")
    fun getAll(): List<LoveModel>
    @Delete
    fun delete(item : LoveModel)
}