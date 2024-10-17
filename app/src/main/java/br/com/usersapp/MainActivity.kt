package br.com.usersapp

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.marvelapp.adapter.UsuarioAdapter
import br.com.usersapp.api.UsuarioApi
import br.com.usersapp.api.UsuarioService
import br.com.usersapp.models.Usuario
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var rvUsuarios : RecyclerView
    private val api = UsuarioApi()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        rvUsuarios = findViewById<RecyclerView>(R.id.rvUsuarios)

        chamarApi()
    }

    fun chamarApi(){

        lifecycleScope.launch {
            try {
                val service = api.getRetrofit().create(UsuarioService::class.java)
                val call = service.getUsers()

                if(call.isSuccessful) {
                    val charactersList = call.body()?.data ?: listOf()
                    rvUsuarios.adapter = UsuarioAdapter(charactersList)

                    rvUsuarios.visibility = View.VISIBLE
                }

                rvUsuarios.layoutManager = LinearLayoutManager(this@MainActivity)
            } catch (ex : Exception){
            }
        }
    }
}