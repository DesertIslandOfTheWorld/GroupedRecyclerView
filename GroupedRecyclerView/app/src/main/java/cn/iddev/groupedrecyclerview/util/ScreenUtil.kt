package cn.iddev.groupedrecyclerview.util

import cn.iddev.groupedrecyclerview.config.BaseApplication

class ScreenUtil {

    companion object {

        private val context = BaseApplication.context

        private val density: Float = context.resources.displayMetrics.density

        // 屏幕宽高
        val width = context.resources.displayMetrics.widthPixels
        val height = context.resources.displayMetrics.heightPixels

        // dip 转 px
        fun dipToPx(dip: Int): Int {
            return (0.5 + (density * dip)).toInt()
        }
    }
}