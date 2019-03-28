package cn.iddev.groupedrecyclerview.module.main.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import cn.iddev.groupedrecyclerview.R
import cn.iddev.groupedrecyclerview.module.main.viewmodel.ContactsViewModel
import kotlinx.android.synthetic.main.item_contact.view.*

class ContactsAdapter(context: Context, contactsViewModel: ContactsViewModel): RecyclerView.Adapter<ContactsAdapter.ViewHolder>() {

    private var context: Context = context
    private var contactsViewModel = contactsViewModel

    private val layoutInflater = LayoutInflater.from(context)

    override fun getItemCount(): Int {
        return contactsViewModel.contacts.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // 加载 xml 中的 item
        val itemView = layoutInflater.inflate(R.layout.item_contact, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // 获取数据
        val contactModel = contactsViewModel.contacts[position]
        // 填充数据
        holder.itemView.contact_avatar_iv.setImageResource(contactModel.avatarResourId)
        holder.itemView.contact_nickname_tv.text = contactModel.nickname
    }

    class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView)
}