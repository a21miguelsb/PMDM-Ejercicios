package com.example.gestorrutinasapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.gestorrutinasapp.databinding.FragmentRoutineBinding
import com.example.gestorrutinasapp.databinding.FragmentRoutineInfoBinding


class RoutineInfoFragment : Fragment() {

    private var _binding: FragmentRoutineInfoBinding? = null
    private val binding get()= _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRoutineInfoBinding.inflate(inflater,container,false)
        val view = binding.root

        return view
    }


}