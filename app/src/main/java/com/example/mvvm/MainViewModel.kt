package com.example.mvvm

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.mvvm.data.repository.UserRepositoryImpl
import com.example.mvvm.data.storage.sharedrefs.SharedPrefUserStorage
import com.example.mvvm.domain.models.SaveUserNameParam
import com.example.mvvm.domain.models.UserName
import com.example.mvvm.domain.usecase.GetUserNameUseCase
import com.example.mvvm.domain.usecase.SaveUserNameUseCase

class MainViewModel(private val getUserNameUseCase: GetUserNameUseCase, private val saveUsernameUseCase: SaveUserNameUseCase) : ViewModel() {


    init {
        Log.e("AAAA", "VM created")
    }

    override fun onCleared() {
        Log.e("AAA", "VM cleared")
        super.onCleared()
    }

    fun save(text: String): String{
        val params = SaveUserNameParam(name = text)
        val result: Boolean = saveUsernameUseCase.execute(param = params)
        return "Save result = $result"
    }

    fun load() :String{
        val userName: UserName = getUserNameUseCase.execute()
        val result: String = "${userName.firstName}  ${userName.lastName}"
        return result
    }
}