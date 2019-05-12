package com.feranstirman.pokedex.Activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.feranstirman.pokedex.Adapters.PokedexAdapter
import com.feranstirman.pokedex.AppConstants.AppConstants
import com.feranstirman.pokedex.R
import kotlinx.android.synthetic.main.activity_pokedata.*

class PokedataActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokedata)

        tv_pokedata_name.text = intent.getStringExtra(AppConstants.POKEMON_NAME_KEY)
        tv_pokedata_url.text = intent.getStringExtra(AppConstants.POKEMON_URL_KEY)
    }
}
