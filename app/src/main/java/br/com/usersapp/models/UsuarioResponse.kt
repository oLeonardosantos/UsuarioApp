package br.com.usersapp.models

import com.google.gson.annotations.SerializedName

data class UsuarioResponse (
    val data: List<Usuario>
)

data class Usuario (
    val avatar: String,
    val email: String,
    @SerializedName("first_name")
    val firstName: String,
    @SerializedName("last_name")
    val lastName: String,
)