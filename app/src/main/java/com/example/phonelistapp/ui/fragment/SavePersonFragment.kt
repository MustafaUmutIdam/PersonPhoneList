package com.example.phonelistapp.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import com.example.phonelistapp.R
import com.example.phonelistapp.databinding.FragmentSavePersonBinding
import com.example.phonelistapp.ui.viewmodel.SavePersonViewModel


class SavePersonFragment : Fragment() {

    private lateinit var binding: FragmentSavePersonBinding
    private lateinit var viewModel: SavePersonViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_save_person , container, false)

        binding.savePersonFragment = this
        binding.savePersonToolbarTitle = "Add Person"
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: SavePersonViewModel by viewModels()
        viewModel = tempViewModel
    }

    fun buttonSave(person_name:String, person_phone_number:String){
        viewModel.save(person_name,person_phone_number)
    }

}