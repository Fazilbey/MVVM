package com.example.mvvm.data.storage

import com.example.mvvm.data.storage.models.User

interface UserStorage {
    fun save(user: User): Boolean

    fun getName() : User
}