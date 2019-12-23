package com.wd.health.kotlinlogin.presenter

import android.text.method.TextKeyListener.clear
import java.lang.ref.WeakReference


/**
 * date:2019/12/20
 *
 * function:
 */

open class BasePresenter<P> {

    private var weakReference: WeakReference<P>? = null

    val view: P?
        get() = weakReference!!.get()

    fun attchView(p: P) {
        weakReference = WeakReference(p)
    }

    fun detachView() {
        weakReference!!.clear()
    }
}
