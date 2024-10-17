package br.com.usersapp.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class UsuarioApi {

    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://reqres.in/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}