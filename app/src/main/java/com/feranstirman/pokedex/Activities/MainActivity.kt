package com.feranstirman.pokedex.Activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.feranstirman.pokedex.Fragments.PokedexFragment
import com.feranstirman.pokedex.Interfaces.GetPokemonService
import com.feranstirman.pokedex.Models.Pokemon
import com.feranstirman.pokedex.Models.TypeData
import com.feranstirman.pokedex.Models.TypePokemon
import com.feranstirman.pokedex.R
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity(),PokedexFragment.OnFragmentInteractionListener {

    var pokemonList:List<TypePokemon> ?= null

    override fun onFragmentInteraction(pokemon: Pokemon) {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val retrofit = Retrofit.Builder().baseUrl("https://pokeapi.co/api/v2/type/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val api = retrofit.create(GetPokemonService::class.java)


        btn_search.setOnClickListener {
            val type = et_pokemon_type.text.toString().toLowerCase().trim()

            api.getAllPokemon(type).enqueue(object :Callback<TypeData>{
                override fun onFailure(call: Call<TypeData>, t: Throwable) {
                    println("fail")
                }

                override fun onResponse(call: Call<TypeData>, response: Response<TypeData>) {
                    val body = response.body()
                    pokemonList = body?.pokemon

                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.container_pokedex_fragment,PokedexFragment.newInstance(pokemonList))
                        .commit()
                }

            })

        }


    }

}
