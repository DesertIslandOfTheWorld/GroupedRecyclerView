package cn.iddev.groupedrecyclerview.module.main.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import cn.iddev.groupedrecyclerview.R
import cn.iddev.groupedrecyclerview.module.main.adapter.ContactsAdapter
import cn.iddev.groupedrecyclerview.module.main.model.ContactModel
import cn.iddev.groupedrecyclerview.module.main.view.ContactItemDecoration
import cn.iddev.groupedrecyclerview.module.main.viewmodel.ContactsViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        contacts_rv.layoutManager = linearLayoutManager

        val contactsViewModel = ContactsViewModel()

        val itemDecoration = ContactItemDecoration(this, contactsViewModel)
        contacts_rv.addItemDecoration(itemDecoration)

        val adapter = ContactsAdapter(this, contactsViewModel)
        contacts_rv.adapter = adapter
    }
}
