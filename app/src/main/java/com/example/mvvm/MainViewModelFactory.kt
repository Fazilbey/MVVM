package com.example.mvvm

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm.data.repository.UserRepositoryImpl
import com.example.mvvm.data.storage.sharedrefs.SharedPrefUserStorage
import com.example.mvvm.domain.usecase.GetUserNameUseCase
import com.example.mvvm.domain.usecase.SaveUserNameUseCase

class MainViewModelFactory(context : Context): ViewModelProvider.Factory{

        private val userRepository by lazy(LazyThreadSafetyMode.NONE){
        UserRepositoryImpl(userStorage = SharedPrefUserStorage(context = context))
    }

    private val getUserNameUseCase by lazy(LazyThreadSafetyMode.NONE){
        GetUserNameUseCase(userRepository = userRepository)
    }

    private val saveUsernameUseCase by lazy(LazyThreadSafetyMode.NONE) {
        SaveUserNameUseCase(userRepository = userRepository )
    }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(getUserNameUseCase = getUserNameUseCase, saveUsernameUseCase = saveUsernameUseCase ) as T
    }
}