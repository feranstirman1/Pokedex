package com.feranstirman.pokedex.Adapters

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.feranstirman.pokedex.Activities.PokedataActivity
import com.feranstirman.pokedex.AppConstants.AppConstants
import com.feranstirman.pokedex.Models.Pokemon
import com.feranstirman.pokedex.Models.TypeData
import com.feranstirman.pokedex.Models.TypePokemon
import com.feranstirman.pokedex.R
import kotlinx.android.synthetic.main.pokemon_row.view.*

class PokedexAdapter(val pokemonList : List<TypePokemon>) : RecyclerView.Adapter<CustomViewholder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewholder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.pokemon_row,parent,false)
        return CustomViewholder(view)
    }

    override fun getItemCount(): Int {
        return pokemonList.size
    }

    override fun onBindViewHolder(holder: CustomViewholder, position: Int) {
        val pokemon = pokemonList.get(position).pokemon
        holder.itemView.tv_pokemon_name.text = pokemon.name
        holder.itemView.tv_pokemon_url.text = pokemon.url
    }

}

class CustomViewholder(itemView: View) : RecyclerView.ViewHolder(itemView){

    init {
        itemView.setOnClickListener {
            val intent = Intent(itemView.context,PokedataActivity::class.java)
            intent.putExtra(AppConstants.POKEMON_NAME_KEY,itemView.tv_pokemon_name.text)
            intent.putExtra(AppConstants.POKEMON_URL_KEY,itemView.tv_pokemon_url.text)
            itemView.context.startActivity(intent)
        }
    }
}