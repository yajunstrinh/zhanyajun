
import android.content.Context
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


import java.io.IOException
import java.security.*
import java.security.cert.CertificateException
import java.security.cert.CertificateFactory
import java.security.cert.X509Certificate
import javax.net.ssl.SSLContext
import javax.net.ssl.SSLSocketFactory
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager

/*
 *@Auther: 封装的网络工具类
 *@Date: 2019/9/27
 *@Time:21:44
 *@Description:15901514581
 * */

class ApiHttpUtils private constructor() {
    private val okHttpClient: OkHttpClient
    private val retrofit: Retrofit

    companion object {
        val instance : ApiHttpUtils by lazy (mode = LazyThreadSafetyMode.SYNCHRONIZED){
            ApiHttpUtils()
        }

    }

    init {

        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        okHttpClient = OkHttpClient.Builder()
                .writeTimeout(50, TimeUnit.SECONDS)
                .readTimeout(50, TimeUnit.SECONDS)
                .connectTimeout(50, TimeUnit.SECONDS)
                .addInterceptor(httpLoggingInterceptor)
                .build()
        retrofit = Retrofit.Builder()
                .baseUrl("https://mobile.bwstudent.com/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build()

    }

    fun <T> create(service: Class<T>): T {
        return retrofit.create(service)
    }



}
