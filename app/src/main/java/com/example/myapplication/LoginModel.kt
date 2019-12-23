package com.example.myapplication

import ApiHttpUtils
import android.database.Observable
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

class LoginModel {
    private var apiHttpUtils: ApiHttpUtils? = null
    fun loginModel(map: HashMap<String,String>,loginCallBack: Contract.LoginCallBack) {
        apiHttpUtils!!.create(ApiHttp::class.java).loginbean(map).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : DisposableObserver<LoginBean>(){
                override fun onComplete() {

                }

                override fun onNext(t: LoginBean) {

                    loginCallBack.loginBack(t)
                }

                override fun onError(e: Throwable) {

                }

            })
    }
}