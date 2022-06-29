package com.example.lugares.ui.lugar


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.lugares.R
import com.example.lugares.databinding.FragmentAddLugarBinding
import com.example.lugares.model.Lugar
import com.example.lugares.viewmodel.LugarViewModel


class AddLugarFragment : Fragment() {
    private var _binding: FragmentAddLugarBinding? = null
    private val binding get() = _binding!!

    private lateinit var lugarViewModel: LugarViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddLugarBinding.inflate(inflater,container,false)

        lugarViewModel = ViewModelProvider (this).get(LugarViewModel::class.java)


        binding.submitBtn.setOnClickListener {  addLugar() }
        return binding.root
        }

            private fun addLugar(){
                val nombre = binding.lugarName.text.toString()

                if(validation(nombre)) {
                    //guardar el lugar
                    val lugar = Lugar(0, nombre)
                    lugarViewModel.addLugar(lugar)
                    Toast.makeText(requireContext(), getString(R.string.msg_lugar_added), Toast.LENGTH_LONG).show()

                findNavController().navigate(R.id.action_addLugarFragment_to_nav_lugar)
                }else{
                    Toast.makeText(requireContext(), getString(R.string.msg_error), Toast.LENGTH_LONG).show()

                }
                }

            private fun validation (nombre: String): Boolean {
                return !(nombre.isEmpty())



            }

        }




