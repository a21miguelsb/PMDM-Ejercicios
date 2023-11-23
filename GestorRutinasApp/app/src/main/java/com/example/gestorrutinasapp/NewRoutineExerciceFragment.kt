package com.example.gestorrutinasapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.gestorrutinasapp.databinding.FragmentDietBinding
import com.example.gestorrutinasapp.databinding.FragmentNewRoutineExerciceBinding

class NewRoutineExerciceFragment : Fragment() {

    private var _binding: FragmentNewRoutineExerciceBinding? = null

    private val binding get()= _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentNewRoutineExerciceBinding.inflate(inflater, container, false)
        val view = binding.root


        return view
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }
}