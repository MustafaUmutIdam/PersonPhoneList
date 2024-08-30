package com.example.phonelistapp.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.phonelistapp.databinding.FragmentSavePersonBinding


class SavePersonFragment : Fragment() {

    private lateinit var binding: FragmentSavePersonBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSavePersonBinding.inflate(inflater, container, false)

        binding.toolbarSavePerson.title = "Add Person"

        binding.buttonSavePerson.setOnClickListener {
            val person_name = binding.textInputSavePersonName.text.toString()
            val person_phone_number = binding.textInputSavePersonPhoneNumber.text.toString()
            save(person_name,person_phone_number)

        }

        return binding.root
    }

    fun save(person_name:String, person_phone_number:String){
        Log.e("The person is saved ", "$person_name - $person_phone_number")
    }

}