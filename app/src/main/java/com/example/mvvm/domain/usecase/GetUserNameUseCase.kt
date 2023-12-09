package com.example.mvvm.domain.usecase

import com.example.mvvm.domain.models.UserName
import com.example.mvvm.domain.repository.UserRepository

class GetUserNameUseCase(private val userRepository: UserRepository) {

    fun execute(): UserName{
        return userRepository.getName()
    }
}