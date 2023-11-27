package com.example.gestorrutinasapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.LinearLayout
import androidx.fragment.app.viewModels
import com.example.gestorrutinasapp.databinding.FragmentDietBinding
import com.example.gestorrutinasapp.databinding.FragmentNewRoutineExerciceBinding

class NewRoutineExerciceFragment : Fragment() {

    private var _binding: FragmentNewRoutineExerciceBinding? = null
    val model: RoutineViewModel by viewModels(
        ownerProducer = {this.requireActivity()}
    )
    private val binding get()= _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentNewRoutineExerciceBinding.inflate(inflater, container, false)
        val view = binding.root
        val layoutExercices = binding.layoutExercices





        return view
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }
}