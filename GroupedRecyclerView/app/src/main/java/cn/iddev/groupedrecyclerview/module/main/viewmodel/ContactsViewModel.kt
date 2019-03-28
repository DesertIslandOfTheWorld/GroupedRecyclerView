package cn.iddev.groupedrecyclerview.module.main.viewmodel

import cn.iddev.groupedrecyclerview.R
import cn.iddev.groupedrecyclerview.module.main.model.ContactModel
import com.github.promeg.pinyinhelper.Pinyin

class ContactsViewModel {

    var contacts = listOf<ContactModel>(
        ContactModel("Angle", R.mipmap.user_2),
        ContactModel("世俗孤岛", R.mipmap.user_3),
        ContactModel("地下铁", R.mipmap.user_5),
        ContactModel("地下铁", R.mipmap.user_5),
        ContactModel("黄昏的灯", R.mipmap.user_4),
        ContactModel("Angle", R.mipmap.user_2),
        ContactModel("黄昏的灯", R.mipmap.user_4),
        ContactModel("黄昏的灯", R.mipmap.user_4),
        ContactModel("世俗孤岛", R.mipmap.user_3),
        ContactModel("书生", R.mipmap.user_1),
        ContactModel("世俗孤岛", R.mipmap.user_3),
        ContactModel("世俗孤岛", R.mipmap.user_3)
    )

    // 保存 ItemDecoration 的位置，以及 ItemDecoration 中 Title 显示的内容
    var itemDecorationMap = hashMapOf<Int, String>()

    constructor() {
        // 昵称转换成拼音
        contacts.map {
            it.nicknameInPinYin = Pinyin.toPinyin(it.nickname, "")
        }
        // 对 contacts 排序
        contacts = contacts.sortedBy {
            it.nicknameInPinYin
        }
        // 计算 ItemDecoration 的位置，以及 ItemDecoration 中 Title 显示的内容
        var lastNicknameFirstLetter = ""
        contacts.forEachIndexed { index, contactModel ->
            val nicknameFirstLetter = contactModel.nicknameInPinYin.first().toString()
            if (nicknameFirstLetter != lastNicknameFirstLetter) {
                itemDecorationMap[index] = nicknameFirstLetter
                lastNicknameFirstLetter = nicknameFirstLetter
            }
        }
    }
}