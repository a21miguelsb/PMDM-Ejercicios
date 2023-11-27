package com.example.gestorrutinasapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.example.gestorrutinasapp.databinding.FragmentNewRoutineBinding

class NewRoutineFragment : Fragment() {


    private var _binding: FragmentNewRoutineBinding? = null
    val model: RoutineViewModel by viewModels(
        ownerProducer = {this.requireActivity()}
    )
    private val binding get()= _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding=FragmentNewRoutineBinding.inflate(inflater,container,false)
        val view = binding.root

        val btn_Next = binding.btnNext

        val nameRoutine =binding.nameText.text
        val numExercices =binding.numExercices.text

        btn_Next.setOnClickListener {
            if (nameRoutine.isEmpty()||numExercices.isEmpty()){
                Toast.makeText(requireContext(),"Debes completar los datos!", Toast.LENGTH_SHORT).show()
            }
            else{
                model.changeNumEx(numExercices.toString().toInt())
                view.findNavController().navigate(R.id.action_newRoutineFragment_to_newRoutineExerciceFragment)
            }
        }
        return view
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }
}