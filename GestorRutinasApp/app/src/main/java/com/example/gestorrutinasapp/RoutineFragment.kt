package com.example.gestorrutinasapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController
import com.example.gestorrutinasapp.databinding.FragmentObjetivesBinding
import com.example.gestorrutinasapp.databinding.FragmentRoutineBinding

class RoutineFragment : Fragment() {
    private var _binding: FragmentRoutineBinding? = null
    private val binding get()= _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding= FragmentRoutineBinding.inflate(inflater,container,false)
        val view = binding.root
        // Inflate the layout for this fragment

        val btn_next = binding.newRoutine

        btn_next.setOnClickListener {
            view.findNavController().navigate(R.id.action_routineFragment_to_newRoutineFragment)


        }
        return view
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }
}