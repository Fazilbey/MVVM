package com.example.mvvm.data.repository

import com.example.mvvm.data.storage.models.User
import com.example.mvvm.data.storage.UserStorage
import com.example.mvvm.domain.models.SaveUserNameParam
import com.example.mvvm.domain.models.UserName
import com.example.mvvm.domain.repository.UserRepository


class UserRepositoryImpl(private val userStorage: UserStorage) : UserRepository {



    override fun saveName(saveparam: SaveUserNameParam): Boolean{
        val user =  User(firstName = saveparam.name, lastName = "")

        val result = userStorage.save(user)
        return result
    }

    override fun getName(): UserName{
        val user = userStorage.getName()
        val userName = UserName(firstName = user.firstName, lastName = user.lastName)
        return userName
    }
}