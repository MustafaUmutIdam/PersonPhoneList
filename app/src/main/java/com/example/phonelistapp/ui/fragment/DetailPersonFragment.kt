package com.example.phonelistapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.phonelistapp.R
import com.example.phonelistapp.databinding.FragmentDetailPersonBinding


class DetailPersonFragment : Fragment() {
    private lateinit var binding: FragmentDetailPersonBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailPersonBinding.inflate(inflater, container, false)

        binding.toolbarDetailPerson.title="Update"


        //Nav ile gelen veriyi aldık
        val bundle :DetailPersonFragmentArgs by navArgs()
        val sentPerson = bundle.person

        binding.textInputDetailPersonName.setText(sentPerson.person_name)
        binding.textInputDetailPersonPhoneNumber.setText(sentPerson.person_phone_number)





        return binding.root
    }

}