package com.example.phonelistapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.phonelistapp.data.repo.PersonRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailPersonViewModel @Inject constructor (var prep : PersonRepository): ViewModel()   {

    fun update(person_id:String,person_name:String, person_phone_number:String){
        prep.update(person_id,person_name,person_phone_number)
    }

}