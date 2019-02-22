package br.com.rafaeldias.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import br.com.rafaeldias.myapplication.adapter.PokemonAdapter
import br.com.rafaeldias.myapplication.api.PokemonService
import br.com.rafaeldias.myapplication.model.Pokemon
import br.com.rafaeldias.myapplication.model.PokemonResponse
import kotlinx.android.synthetic.main.activity_main.*
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class MainActivity : AppCompatActivity() {

    lateinit var adapter : PokemonAdapter
    val pokemons = ArrayList<Pokemon>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val api = PokemonService()

        val recyclerView = rvPokemon
        adapter = PokemonAdapter(pokemons,this,{})
        recyclerView.adapter = adapter
        rvPokemon.layoutManager = LinearLayoutManager(this)

        api.loadPokemons()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        {pokemons.add(it)},
                        //{Log.i ("POKEMON", "${it.name} - ${it.sprites.frontDefault}")},
                        {e -> e.printStackTrace()},
                        //{Log.i("POKEMON", "Todos pokemons emitidos")}
                        {}
                )
    }
}
