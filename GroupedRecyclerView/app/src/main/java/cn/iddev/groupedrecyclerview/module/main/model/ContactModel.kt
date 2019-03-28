package cn.iddev.groupedrecyclerview.module.main.model

data class ContactModel(val nickname: String, val avatarResourId: Int) {

    // 昵称对应的拼音
    var nicknameInPinYin: String = ""
}