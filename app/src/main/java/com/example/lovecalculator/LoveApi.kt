package com.example.lovecalculator

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface LoveApi {
    @GET("getPercentage")
    fun countCompability(@Query("fname")firstName:String,
                         @Query("sname")secondName:String,
                         @Header("X-RapidAPI-Key") key: String = "d932152decmsh4e34dcd5a601766p13cc13jsnb5a38bb5d900",
                         @Header("X-RapidAPI-Host") host: String = "love-calculator.p.rapidapi.com"
                        ) : Call<LoveModel>
}