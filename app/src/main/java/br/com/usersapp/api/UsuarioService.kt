package br.com.usersapp.api

import br.com.usersapp.models.UsuarioResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface UsuarioService {

    @GET("users")
    suspend fun getUsers(): Response<UsuarioResponse>
}