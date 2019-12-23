package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

import kotlinx.android.synthetic.main.activity_regin.*

class ReginActivity : AppCompatActivity() {
    var map = HashMap<String, String>()
    val regintext: String? = null
    val reginname: String? = null
    val reginpass: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_regin)
        val regintext = regin_text.text
        val reginname = regin_name.text
        val reginpass = regin_pass.text
        regin_but.setOnClickListener {
            val regintexts = regintext.toString()
            val reginnames = reginname.toString()
            val reginpasss = reginpass.toString()
            try {
                //密码加密
                val encryptByPublicKey = RsaCoder.encryptByPublicKey(reginpasss)
                map.put("nickName", regintexts!!)
                map.put("phone", reginnames!!)
                map.put("pwd", encryptByPublicKey!!)
                ApiHttpUtils.instance.create(ApiHttp::class.java)
                    .reginBean(map)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(object : DisposableObserver<ReginBean>() {
                        override fun onComplete() {
                            Log.i("??", "??accept: ")
                        }

                        //成功
                        override fun onNext(t: ReginBean) {
                            Log.i("成功", "成功accept: " + t.message)
                            if ("0000".equals(t.status)) {

                                //吐司
                                Toast(t.message.toString())
                                finish()
                            }
                        }

                        //失败
                        override fun onError(e: Throwable) {
                            Log.i("失败", "失败accept: " + e.message)
                            //吐司
                            Toast(e.message.toString())
                        }
                    })
            }catch (e:Exception){
                e.printStackTrace()
            }
        }
    }
    //注册吐司
    fun Toast(t: String) {
        android.widget.Toast.makeText(this, "" + t, android.widget.Toast.LENGTH_LONG).show()

    }
}
