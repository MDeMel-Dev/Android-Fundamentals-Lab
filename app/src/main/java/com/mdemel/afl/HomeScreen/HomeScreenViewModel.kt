package com.mdemel.afl.HomeScreen

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mdemel.afl.network.services.UserLoginService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create

class HomeScreenViewModel: ViewModel() {

    val retrofit: Retrofit = Retrofit.Builder().baseUrl("http://10.0.2.2:8080/login/").addConverterFactory(
        MoshiConverterFactory.create().asLenient()).build()

    var usernameValue = ""
    var passwordValue = ""

    val submitClicked: MutableLiveData<Boolean> = MutableLiveData(false)
    val authenticated: MutableLiveData<String> = MutableLiveData("")

    fun makeUserAuthenticationCall() {
        CoroutineScope(Dispatchers.Main).launch {
            var result = ""

            try {
               result =  authenticateApiService.authenticate(user = usernameValue, pswd = passwordValue)
            } catch (e: Exception) {
                result = e.message.toString()
            }

            authenticated.value = result
        }
    }

    val authenticateApiService: UserLoginService = retrofit.create<UserLoginService>()
}