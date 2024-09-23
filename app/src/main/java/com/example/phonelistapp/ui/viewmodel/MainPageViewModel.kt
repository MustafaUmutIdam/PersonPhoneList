package com.example.phonelistapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.phonelistapp.data.entity.Persons
import com.example.phonelistapp.data.repo.PersonRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainPageViewModel : ViewModel()   {
    var prep = PersonRepository()
    var personList =MutableLiveData<List<Persons>>()

    init {
        uploadPersons()
    }

    fun delete(person_id:Int){
        CoroutineScope(Dispatchers.Main).launch {
            prep.delete(person_id)
            uploadPersons()
        }
    }
    fun uploadPersons(){
        CoroutineScope(Dispatchers.Main).launch {
            personList.value = prep.uploadPersons()
        }
    }
    fun search(searchingPerson:String){
        CoroutineScope(Dispatchers.Main).launch {
        personList.value = prep.search(searchingPerson)
    }}
}