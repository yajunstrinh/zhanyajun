package com.example.myapplication

import android.text.AutoText

interface Contract {
    interface LoginView {
        fun loginView(loginBean: LoginBean)

    }

    interface LoginCallBack {
        fun loginBack(loginBean: LoginBean)
    }
}