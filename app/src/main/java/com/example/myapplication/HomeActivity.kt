package com.example.myapplication

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.youth.banner.loader.ImageLoader
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    var userId: Int? = null
    var sessionId: String? = null
    var plateId: Int? = null
    var page: Int? = null
    var count: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val userid = intent.getIntExtra("userId", 0)
        val sessionid = intent.getStringExtra("sessionId")
        ApiHttpUtils.instance.create(ApiHttp::class.java).banner().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : DisposableObserver<BannerBean>() {
                override fun onComplete() {
                }

                override fun onNext(t: BannerBean) {
                    val result = t.result
                    beanner.setImages(result)
                    beanner.setImageLoader(object : ImageLoader() {
                        override fun displayImage(context: Context, path: Any, imageView: ImageView) {
                            val re =path as BannerBean.ResultBean
                            Glide.with(context).load(re.imageUrl).into(imageView)
                        }
                    })
                    beanner.setDelayTime(3000)
                    beanner.isAutoPlay(true)
                    beanner.start()
                }

                override fun onError(e: Throwable) {

                }
            });
        ApiHttpUtils.instance.create(ApiHttp::class.java)
            .getshou(userid, sessionid, 5, 1, 5)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : DisposableObserver<HomeBean>() {
                override fun onComplete() {
                    Log.i("??", "??accept: ")
                }

                //成功
                override fun onNext(t: HomeBean) {
                    Log.i("成功", "成功accept: " + t.getMessage())
                    val result = t.getResult()
                    val linearLayoutManager =
                        LinearLayoutManager(this@HomeActivity, RecyclerView.VERTICAL, false)
                    recycle.setLayoutManager(linearLayoutManager)
                    val baseAdpaterBing = BaseAdpaterBing(R.layout.doctorrecycle, result)
                    recycle.setAdapter(baseAdpaterBing)

                }

                //失败
                override fun onError(e: Throwable) {
                    Log.i("失败", "失败accept: " + e.message)
                    //吐司
                    Toast(e.message.toString())
                }
            })
    }

    //注册吐司
    fun Toast(t: String) {
        android.widget.Toast.makeText(this, "" + t, android.widget.Toast.LENGTH_LONG).show()

    }
}
