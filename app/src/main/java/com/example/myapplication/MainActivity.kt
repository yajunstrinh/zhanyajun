package com.example.myapplication
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.ApiHttp
import com.example.myapplication.LoginBean
import com.example.myapplication.R
import com.example.myapplication.RsaCoder
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var map = HashMap<String, String>()
    var nametext: String? = null
    var pwdtexts: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //手机号
        var nametext = edit_name.text
        //密码
        var pwdtext = edit_pass.text
        but_regin.setOnClickListener{
            val intent = Intent(this@MainActivity, ReginActivity::class.java)
            startActivity(intent)
        }
        //登录
        but.setOnClickListener {
             val nametexts = nametext.trim().toString()
            pwdtexts = pwdtext.trim().toString()

           try {
               //密码加密
               val encryptByPublicKey = RsaCoder.encryptByPublicKey(pwdtexts)
               map.put("phone", nametexts!!)
               map.put("pwd", encryptByPublicKey!!)
               ApiHttpUtils.instance.create(ApiHttp::class.java)
                   .loginbean(map)
                   .subscribeOn(Schedulers.io())
                   .observeOn(AndroidSchedulers.mainThread())
                   .subscribe(object : DisposableObserver<LoginBean>() {
                       override fun onComplete() {
                           Log.i("??", "??accept: ")
                       }

                       //成功
                       override fun onNext(t: LoginBean) {
                           Log.i("成功", "成功accept: " + t.message)
                           val userId = t.result.userId
                           val sessionId = t.result.sessionId
                           if ("0000".equals(t.status)) {
                               //跳转
                               //吐司
                               Toast(t.message.toString())
                               val intent = Intent(this@MainActivity, HomeActivity::class.java)
                               intent.putExtra("userId",userId)
                               intent.putExtra("sessionId",sessionId)
                               startActivity(intent)
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
        Toast.makeText(this, "" + t, Toast.LENGTH_LONG).show()

    }
}
