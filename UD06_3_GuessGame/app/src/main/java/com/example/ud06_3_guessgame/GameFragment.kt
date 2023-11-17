package com.example.ud06_3_guessgame

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import com.example.ud06_3_guessgame.databinding.FragmentGameBinding


class GameFragment : Fragment() {
    private var _binding: FragmentGameBinding? = null

    private val binding get()= _binding!!
    val model: GameViewModel by viewModels(
        ownerProducer = {this.requireActivity()}
    )
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentGameBinding.inflate(inflater, container, false)
        val view = binding.root



        binding.btnTry.setOnClickListener {
            //model.secretWord="Palabra de prueba"
            if (binding.txtGuess.text.length<1) {
                Toast.makeText(activity,"Introduce un caracter",Toast.LENGTH_SHORT).show()
            }
            else{
                model.game(binding.txtGuess.text.toString()[0])

                if (model.win()||model.lost()){
                    view.findNavController().navigate(com.example.ud06_3_guessgame.R.id.action_gameFragment_to_resultFragment)
                }

            }

        }
        model.lives.observe(
            viewLifecycleOwner,
            Observer {
                    newValue-> binding.txtLives.text = "Te quedan ${newValue} vidas"

            }
        )
        model.secretWordDisplay.observe(
            viewLifecycleOwner,
            Observer {
                it-> binding.txtWord.text = it

            }
        )


        return view
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }
}