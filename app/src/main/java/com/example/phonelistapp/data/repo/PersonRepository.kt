package com.example.phonelistapp.data.repo

import androidx.lifecycle.MutableLiveData
import com.example.phonelistapp.data.datasource.PersonDataSource
import com.example.phonelistapp.data.entity.Persons

class PersonRepository(var pds:PersonDataSource ) {

     fun uploadPersons() : MutableLiveData<List<Persons>> = pds.uploadPersons()

     fun search(searchingPerson:String) : MutableLiveData<List<Persons>> = pds.search(searchingPerson)

     fun save(person_name:String, person_phone_number:String) = pds.save(person_name,person_phone_number)

     fun update(person_id:String,person_name:String, person_phone_number:String){
        pds.update(person_id,person_name,person_phone_number)
    }

     fun delete(person_id:String){
        pds.delete(person_id)
    }
}
