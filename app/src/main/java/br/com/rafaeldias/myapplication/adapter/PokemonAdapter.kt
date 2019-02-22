package br.com.rafaeldias.myapplication.adapter

import android.content.Context
import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.rafaeldias.myapplication.R
import br.com.rafaeldias.myapplication.model.Pokemon
import br.com.rafaeldias.myapplication.model.PokemonResponse
import kotlinx.android.synthetic.main.activity_main.view.*

class PokemonAdapter(private val pokemon: ArrayList<Pokemon>,
                     private val context: Context,
                     val listener: (Pokemon) -> Unit) : RecyclerView.Adapter<PokemonAdapter.PokemonViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.activity_pokemon, parent, false)
        return PokemonViewHolder(view)
    }

    override fun getItemCount(): Int {
        return pokemon.size
    }

    class PokemonViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bindView(pokemon: ArrayList<Pokemon>,
                     listener: (Pokemon) -> Unit) {
               tvName.//pokemon.name
        }
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        val extrato = pokemon[position]
        holder?.let {
            it.bindView(extrato, listener)
        }
    }
}