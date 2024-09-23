package com.example.phonelistapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.phonelistapp.data.repo.PersonRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailPersonViewModel : ViewModel()   {
    var prep = PersonRepository()

    fun update(person_id:Int,person_name:String, person_phone_number:String){
        CoroutineScope(Dispatchers.Main).launch {
            prep.update(person_id,person_name,person_phone_number)
        }
    }

}