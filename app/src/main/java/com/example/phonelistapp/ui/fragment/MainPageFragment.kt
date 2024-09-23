package com.example.phonelistapp.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.phonelistapp.R
import com.example.phonelistapp.data.entity.Persons
import com.example.phonelistapp.databinding.FragmentMainPageBinding
import com.example.phonelistapp.ui.adapter.PersonAdapter
import com.example.phonelistapp.ui.viewmodel.DetailPersonViewModel
import com.example.phonelistapp.ui.viewmodel.MainPageViewModel
import com.example.phonelistapp.ui.viewmodel.SavePersonViewModel


class MainPageFragment : Fragment() {
    private lateinit var binding: FragmentMainPageBinding
    private lateinit var viewModel: MainPageViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding =DataBindingUtil.inflate(inflater,R.layout.fragment_main_page, container, false)
        binding.mainPageFragment = this
        binding.mainPageToolbarTitle="Person List"


        //Listenin Olusum Dizaynı burdan degistiriliyor(Alt Alta)
        binding.recyclerView.layoutManager=LinearLayoutManager(requireContext())

        //Adapter ile bilgi islemleri halloldu, Rv islemleri .xml sayfasında, Observe ile dinleyerek veriyi getirdik
        viewModel.personList.observe(viewLifecycleOwner){
            val personAdapter = PersonAdapter(requireContext(),it,viewModel)
            binding.personAdapter=personAdapter
        }





        //SearchView Islemleri(Burda MVVM yok )

        binding.searchView.setOnQueryTextListener(object :SearchView.OnQueryTextListener{

            //Harf girdikce sonuc gelen fonksiyon
            override fun onQueryTextChange(newText: String): Boolean {
                viewModel.search(newText)
                return true
            }
            //arama butonuna basınca sonuc gösteren fonksiyon
            override fun onQueryTextSubmit(query: String): Boolean {
                viewModel.search(query)
                return true
            }

        } )



        return binding.root
    }

    //Ilk acıldıgında burası calısarak verileri getiriyor
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: MainPageViewModel by viewModels()
        viewModel = tempViewModel
    }


    fun fabClick(it:View){
        //KısıKaydetmeButton'undan Kaydetme sayfasına gecis
        Navigation.findNavController(it).navigate(R.id.mainToSave)
    }

    override fun onResume() {
        super.onResume()
        viewModel.uploadPersons()
    }

}