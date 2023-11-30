package com.example.gestorrutinasapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.gestorrutinasapp.databinding.FragmentRoutineInfoBinding


class RoutineInfoFragment : Fragment() {

    private var _binding: FragmentRoutineInfoBinding? = null
    private val binding get()= _binding!!
    val model: RoutineViewModel by viewModels(
        ownerProducer = {this.requireActivity()}
    )
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRoutineInfoBinding.inflate(inflater,container,false)
        val view = binding.root
        binding.routineInfoName.text =model.routineInfo.name.uppercase()
        binding.routineDayInfo.text = model.routineInfo.day.name.uppercase()





        binding.exerciceName1.text = model.routineInfo.exercices[0].name
        binding.exerciceReps1.text= model.routineInfo.exercices[0].repetitions.toString()
        binding.exerciceTime1.text = model.routineInfo.exercices[0].time.toString()


        binding.exerciceName2.text = model.routineInfo.exercices[1].name
        binding.exerciceReps2.text= model.routineInfo.exercices[1].repetitions.toString()
        binding.exerciceTime2.text = model.routineInfo.exercices[1].time.toString()


        binding.exerciceName3.text = model.routineInfo.exercices[2].name
        binding.exerciceReps3.text= model.routineInfo.exercices[2].repetitions.toString()
        binding.exerciceTime3.text = model.routineInfo.exercices[2].time.toString()


        binding.exerciceName4.text = model.routineInfo.exercices[3].name
        binding.exerciceReps4.text= model.routineInfo.exercices[3].repetitions.toString()
        binding.exerciceTime4.text = model.routineInfo.exercices[3].time.toString()


         binding.exerciceName5.text = model.routineInfo.exercices[4].name
         binding.exerciceReps5.text= model.routineInfo.exercices[4].repetitions.toString()
         binding.exerciceTime5.text = model.routineInfo.exercices[4].time.toString()


        return view
    }


}