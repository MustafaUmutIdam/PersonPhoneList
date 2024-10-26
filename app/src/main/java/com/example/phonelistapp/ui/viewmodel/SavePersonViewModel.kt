package com.example.phonelistapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.phonelistapp.data.repo.PersonRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SavePersonViewModel @Inject constructor (var prep : PersonRepository) : ViewModel() {


    fun save(person_name:String, person_phone_number:String){
        prep.save(person_name,person_phone_number)
    }

}