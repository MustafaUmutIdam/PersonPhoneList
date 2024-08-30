package com.example.phonelistapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.phonelistapp.R
import com.example.phonelistapp.data.entity.Persons
import com.example.phonelistapp.databinding.FragmentMainPageBinding


class MainPageFragment : Fragment() {
    private lateinit var binding: FragmentMainPageBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding =FragmentMainPageBinding.inflate(inflater, container, false)

        binding.toolbarMainPage.title="Person List"

        binding.floatingActionButton.setOnClickListener {
            //KısıKaydetmeButton'undan Kaydetme sayfasına gecis
            Navigation.findNavController(it).navigate(R.id.mainToSave)
        }

        binding.buttonToDetail.setOnClickListener {
            val person = Persons(1,"Ays","3838")
            val transition =  MainPageFragmentDirections.mainToDetail(person=person)
            Navigation.findNavController(it).navigate(transition)
        }

        return binding.root
    }


}