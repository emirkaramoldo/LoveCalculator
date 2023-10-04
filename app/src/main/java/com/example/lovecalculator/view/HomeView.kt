package com.example.lovecalculator.view

import com.example.lovecalculator.model.LoveModel

interface HomeView {
        fun changeFragment(loveModel: LoveModel)
        fun showError(message: String)
        fun navigateOnBoardFragment()
    }