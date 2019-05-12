package com.feranstirman.pokedex.Fragments

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.feranstirman.pokedex.Adapters.PokedexAdapter
import com.feranstirman.pokedex.Models.Pokemon
import com.feranstirman.pokedex.Models.TypeData
import com.feranstirman.pokedex.Models.TypePokemon

import com.feranstirman.pokedex.R
import kotlinx.android.synthetic.main.fragment_pokedex.view.*


class PokedexFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var pokemonList: List<TypePokemon>? = null
    private var listener: OnFragmentInteractionListener? = null
    private var mContext:Context?=null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pokedex, container, false).apply {
            rv_pokedex.apply {
                setHasFixedSize(true)
                adapter = pokemonList?.let { PokedexAdapter(it) }
                layoutManager = LinearLayoutManager(mContext)
            }
        }
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
        if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson [Communicating with Other Fragments]
     * (http://developer.android.com/training/basics/fragments/communicating.html)
     * for more information.
     */
    interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onFragmentInteraction(pokemon : Pokemon)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment PokedexFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(pokemonList: List<TypePokemon>?) =
            PokedexFragment().apply {
                this.pokemonList = pokemonList
            }
    }
}
