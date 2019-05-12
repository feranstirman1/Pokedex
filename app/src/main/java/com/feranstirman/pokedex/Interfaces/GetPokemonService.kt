package com.feranstirman.pokedex.Interfaces

import com.feranstirman.pokedex.Models.TypeData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface GetPokemonService {

    @GET("{tipo}")
    fun getAllPokemon(@Path("tipo") tipoPokemon:String): Call<TypeData>


}