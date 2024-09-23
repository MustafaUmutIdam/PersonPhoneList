package com.example.phonelistapp.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.phonelistapp.R
import com.example.phonelistapp.databinding.FragmentDetailPersonBinding
import com.example.phonelistapp.ui.viewmodel.DetailPersonViewModel
import com.example.phonelistapp.ui.viewmodel.SavePersonViewModel


class DetailPersonFragment : Fragment() {
    private lateinit var binding: FragmentDetailPersonBinding
    private lateinit var viewModel: DetailPersonViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_detail_person, container, false)

        binding.detailPersonFragment = this
        binding.detailPersonToolbarTitle="Update"


        //Nav ile gelen veriyi aldık
        val bundle :DetailPersonFragmentArgs by navArgs()
        val sentPerson = bundle.person
        binding.personObject = sentPerson

        return binding.root
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: DetailPersonViewModel by viewModels()
        viewModel = tempViewModel
    }

    fun buttonUpdate(person_id:Int,person_name:String, person_phone_number:String){
        viewModel.update(person_id,person_name,person_phone_number)
    }

}