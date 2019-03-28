package cn.iddev.groupedrecyclerview.module.main.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Rect
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import cn.iddev.groupedrecyclerview.R
import cn.iddev.groupedrecyclerview.module.main.viewmodel.ContactsViewModel
import cn.iddev.groupedrecyclerview.util.ScreenUtil
import kotlinx.android.synthetic.main.item_decoration_contact.view.*

class ContactItemDecoration(context: Context, contactsViewModel: ContactsViewModel): RecyclerView.ItemDecoration() {

    private val layoutInflater = LayoutInflater.from(context)
    private var contactsViewModel = contactsViewModel

    private val itemDecorationHeight = ScreenUtil.dipToPx(30)

    override fun getItemOffsets(outRect: Rect?, view: View?, parent: RecyclerView?, state: RecyclerView.State?) {
        super.getItemOffsets(outRect, view, parent, state)

        // 计算当前 Item 的 position
        if (view != null && parent != null) {
            val position = parent.getChildAdapterPosition(view)
            // 判断该 Item 是否需要显示 ItemDecoration
            if (contactsViewModel.itemDecorationMap.containsKey(position)) {
                outRect?.top = itemDecorationHeight
            }
        }
    }

    override fun onDraw(c: Canvas?, parent: RecyclerView?, state: RecyclerView.State?) {
        super.onDraw(c, parent, state)

        // 解析 xml 中的视图
        val itemDecorationView = layoutInflater.inflate(R.layout.item_decoration_contact, parent, false)

        // 绘制所需的 decoration
        parent?.let {

            for (index in 0 until parent.childCount) {
                val child = parent.getChildAt(index)
                val childPosition = parent.getChildAdapterPosition(child)

                if (contactsViewModel.itemDecorationMap.containsKey(childPosition)) {

                    // 设置 ItemDecoration 的 Title
                    itemDecorationView.contact_decoration_title_tv.text = contactsViewModel.itemDecorationMap[childPosition]
                }
                // 保存
                c?.save()
                // 移动画笔
                c?.translate(0f, (child.top - itemDecorationHeight).toFloat())

                // 测量布局
                val widthSpec = View.MeasureSpec.makeMeasureSpec(parent.width, View.MeasureSpec.EXACTLY)
                val childWidth = ViewGroup.getChildMeasureSpec(widthSpec, it.paddingLeft + it.paddingRight, itemDecorationView.layoutParams.width)

                itemDecorationView.measure(childWidth, itemDecorationHeight)
                itemDecorationView.layout(0, 0, itemDecorationView.measuredWidth, itemDecorationView.measuredHeight)

                // 绘制 decoration
                itemDecorationView.draw(c)
                c?.restore()
            }
        }
    }
}