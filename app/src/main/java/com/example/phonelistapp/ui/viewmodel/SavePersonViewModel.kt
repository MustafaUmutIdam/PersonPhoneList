package com.example.phonelistapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.phonelistapp.data.repo.PersonRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SavePersonViewModel : ViewModel() {
    var prep = PersonRepository()

    fun save(person_name:String, person_phone_number:String){
    CoroutineScope(Dispatchers.Main).launch{
        prep.save(person_name,person_phone_number)
    }
 }
}