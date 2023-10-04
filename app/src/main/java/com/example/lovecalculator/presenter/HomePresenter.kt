package com.example.lovecalculator.presenter

import android.content.SharedPreferences
import com.example.lovecalculator.App
import com.example.lovecalculator.view.HomeView
import com.example.lovecalculator.model.LoveModel
import com.example.lovecalculator.model.RetrofitService
import com.example.lovecalculator.model.room.Pref
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.Date
import javax.inject.Inject

class HomePresenter @Inject constructor(private val sharedPreferences: SharedPreferences){
    lateinit var homeView: HomeView//если заменить на view то работать не будет

    @Inject
    lateinit var pref: Pref

    private var api = RetrofitService().api

    fun getLove(firstName: String, secondName: String) {
        api.countCompability(firstName, secondName)
            .enqueue(object : Callback<LoveModel> {
                override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                    response.body()?.let {
                        homeView.changeFragment(it)
                    }
                }
                override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                    homeView.showError("Ошибка: ${t.message}")
                }
            })
    }

    fun setView(view: HomeView){
        this.homeView = view
    }

    fun showOnBoard(){
        if (!pref.isOnBoardShowed()){
            homeView.navigateOnBoardFragment()
        }
    }
}