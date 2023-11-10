package com.example.ud05_1_pizza


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar

/**
 * A simple [Fragment] subclass.
 * Use the [OrderFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class OrderFragment : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_order, container, false)
        val toolbar = view.findViewById<MaterialToolbar>(R.id.toolbar)
        (activity as AppCompatActivity).setSupportActionBar(toolbar)


        val btnSend = view.findViewById<FloatingActionButton>(R.id.fab)
        btnSend.setOnClickListener {
            val pizzaGroup = view.findViewById<RadioGroup>(R.id.group_pizza)
            val pizzaType = pizzaGroup.checkedRadioButtonId

            val parmessano = view.findViewById<Chip>(R.id.parmesano)
            val mozzarella = view.findViewById<Chip>(R.id.mozzarella)

            var msg=""

            if (pizzaType ==-1){
                msg ="Debes seleccionar una pizza!"
            }else{
                msg="Has seleccionado la pizza "
                msg+= when(pizzaType){
                    R.id.radio_margarita->"Margarita"
                            R.id.radio_calzone ->"Calzone"
                        else ->"No existe"
                }


                if (mozzarella.isChecked && parmessano.isChecked)msg+=" con mozzarella y parmesano"
                else {
                    if (parmessano.isChecked)msg+=" con parmesano"
                    if (mozzarella.isChecked)msg+=" con mozzarella"
                }



            }
            //Toast.makeText(activity,msg,Toast.LENGTH_SHORT).show()
            val snackbar= Snackbar.make(btnSend,msg,Snackbar.LENGTH_SHORT)

            snackbar.setAction("Undo"){
                pizzaGroup.clearCheck()
            }
            snackbar.show()
        }


        return view
    }

}