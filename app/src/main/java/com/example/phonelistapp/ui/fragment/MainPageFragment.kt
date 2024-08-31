package com.example.phonelistapp.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.appcompat.widget.SearchView.OnQueryTextListener
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.phonelistapp.R
import com.example.phonelistapp.data.entity.Persons
import com.example.phonelistapp.databinding.FragmentMainPageBinding
import com.example.phonelistapp.ui.adapter.PersonAdapter


class MainPageFragment : Fragment() {
    private lateinit var binding: FragmentMainPageBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding =FragmentMainPageBinding.inflate(inflater, container, false)

        binding.toolbarMainPage.title="Person List"


        //Listenin Olusum Dizaynı burdan degistiriliyor(Alt Alta)
        binding.recyclerView.layoutManager=LinearLayoutManager(requireContext())

        val personList= ArrayList<Persons>()
        val p1 = Persons(1,"Ays","383838")
        val p2 = Persons(2,"Duygu","333333")
        val p3 = Persons(3,"Semih","343434")

        personList.add(p1)
        personList.add(p2)
        personList.add(p3)

        //Adapter ile bilgi islemleri halloldu, Altında RV ile görüntülendi
        val personAdapter = PersonAdapter(requireContext(),personList)
        binding.recyclerView.adapter=personAdapter

        binding.floatingActionButton.setOnClickListener {
            //KısıKaydetmeButton'undan Kaydetme sayfasına gecis
            Navigation.findNavController(it).navigate(R.id.mainToSave)
        }

        //SearchView Islemleri

        binding.searchView.setOnQueryTextListener(object :SearchView.OnQueryTextListener{

            //Harf girdikce sonuc gelen fonksiyon
            override fun onQueryTextChange(newText: String): Boolean {
                search(newText)
                return true
            }
            //arama butonuna basınca sonuc gösteren fonksiyon
            override fun onQueryTextSubmit(query: String): Boolean {
                search(query)
                return true
            }

        } )



        return binding.root
    }

    fun search(searchingPerson:String){
        Log.e("Searching Person is : ", searchingPerson)
    }
}