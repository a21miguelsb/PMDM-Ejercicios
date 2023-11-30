package com.example.gestorrutinasapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.example.gestorrutinasapp.databinding.FragmentRoutineBinding

class RoutineFragment : Fragment() {
    private var _binding: FragmentRoutineBinding? = null
    private val binding get()= _binding!!
    private lateinit var adapter: ArrayAdapter<String>
    private val itemList = ArrayList<String>()
    val model: RoutineViewModel by viewModels(
        ownerProducer = {this.requireActivity()}
    )
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding= FragmentRoutineBinding.inflate(inflater,container,false)
        val view = binding.root
        // Inflate the layout for this fragment
        var lista = binding.listaRutinas


        if(model.listaRutinas.size!=0){
            adapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, itemList)
            lista.adapter = adapter

            for (rutina in model.listaRutinas){
                var item = rutina.name.uppercase()+"("+rutina.day.toString().lowercase()+")"
                if (!itemList.contains(item)){
                    itemList.add(item)
                    adapter.notifyDataSetChanged()
                }

            }
            lista.setOnItemClickListener { parent, _, position, _ ->
                val selectedItem = parent.getItemAtPosition(position)

                view.findNavController().navigate(R.id.action_routineFragment_to_routineInfoFragment)


            }



        }
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