package br.com.marvelapp.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.usersapp.R
import br.com.usersapp.models.Usuario
import com.squareup.picasso.Picasso

class UsuarioAdapter (private val users : List<Usuario>) : RecyclerView.Adapter<UsuarioAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_usuario, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return users.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val usuario = users [position]

        holder.addItem(usuario)
    }

    class ViewHolder (item : View) : RecyclerView.ViewHolder(item) {

        val image = item.findViewById<ImageView>(R.id.image)
        val name = item.findViewById<TextView>(R.id.firstName)
        val email = item.findViewById<TextView>(R.id.email)

        fun addItem( usuario : Usuario ) {
            name.text = usuario.firstName
            email.text = usuario.email

            Picasso.get().load(usuario.avatar).into(image)

        }
    }
}
