package br.com.rafaeldias.myapplication.api

import br.com.rafaeldias.myapplication.model.Pokemon
import br.com.rafaeldias.myapplication.model.PokemonResponse
import retrofit2.http.GET
import retrofit2.http.Path
import rx.Observable

interface PokemonAPI {
    @GET("api/v2/pokemon")
    fun listaPokemons(): Observable<PokemonResponse>

    @GET("api/v2/pokemon/{nomePokemon}")
    fun buscaPor(@Path("nomePokemon") nomePokemon : String) : Observable<Pokemon>
}