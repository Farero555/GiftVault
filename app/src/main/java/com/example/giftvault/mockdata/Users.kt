package com.example.giftvault.mockdata

import com.example.giftvault.model.User

class Users {
    companion object {
        val userList: ArrayList<User> = ArrayList();

        fun initUsers() {
            val user1 = User("user1", "123", "Eriks", "Cepurits", "someEmail@example.com");
            userList.add(user1);
        }
    }
}