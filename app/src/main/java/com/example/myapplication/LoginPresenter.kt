package com.example.myapplication

import com.wd.health.kotlinlogin.presenter.BasePresenter

 class LoginPresenter : BasePresenter<Contract.LoginView>() {
     var loginModel:LoginModel?=null
    fun loaginPresenter(map:HashMap<String,String>){
        loginModel?.loginModel(map,object :Contract.LoginCallBack {
            override fun loginBack(loginBean: LoginBean) {
                view!!.loginView(loginBean)
            }

        });
    }

}
