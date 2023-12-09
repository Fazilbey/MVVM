package com.example.mvvm.data.storage.sharedrefs

import android.content.Context
import com.example.mvvm.data.storage.UserStorage
import com.example.mvvm.data.storage.models.User

private const val SHARED_PREFS_NAME = "shared_prefs_name"
private const val KEY_FIRST_NAME = "firstName"
private const val KEY_LAST_NAME = "lastName"
private const val DEFAULT_First_NAME = "Default first name"
private const val DEFAULT_last_NAME = "Default last name"

class SharedPrefUserStorage(context: Context) : UserStorage {
    private val sharedPreferences =
        context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE)

    override fun save(user: User): Boolean {
        sharedPreferences.edit().putString(KEY_FIRST_NAME, user.firstName).apply()
        sharedPreferences.edit().putString(KEY_LAST_NAME, user.lastName).apply()
        return true
    }

    override fun getName(): User {
        val firstName =
            sharedPreferences.getString(KEY_FIRST_NAME, DEFAULT_First_NAME) ?: DEFAULT_First_NAME
        val lastName =
            sharedPreferences.getString(KEY_LAST_NAME, DEFAULT_last_NAME) ?: DEFAULT_last_NAME
        return User(firstName = firstName, lastName = lastName)

    }
}