package cn.iddev.groupedrecyclerview.config

import android.app.Application
import kotlin.properties.Delegates


class BaseApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        context = this
    }

    // context
    companion object {
        var context: BaseApplication by Delegates.notNull<BaseApplication>()
    }
}