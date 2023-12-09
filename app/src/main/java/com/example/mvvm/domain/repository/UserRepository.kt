package com.example.mvvm.domain.repository

import com.example.mvvm.domain.models.SaveUserNameParam
import com.example.mvvm.domain.models.UserName

interface UserRepository {
    fun saveName(saveparam: SaveUserNameParam): Boolean

    fun getName(): UserName
}
