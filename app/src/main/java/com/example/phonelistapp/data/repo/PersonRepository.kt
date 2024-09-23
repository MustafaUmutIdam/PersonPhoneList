package com.example.phonelistapp.data.repo

import com.example.phonelistapp.data.datasource.PersonDataSource
import com.example.phonelistapp.data.entity.Persons

class PersonRepository {
    var pds = PersonDataSource()

    suspend fun uploadPersons() = pds.uploadPersons()

    suspend fun search(searchingPerson:String) : List<Persons> = pds.search(searchingPerson)

    suspend fun save(person_name:String, person_phone_number:String) = pds.save(person_name,person_phone_number)

    suspend fun update(person_id:Int,person_name:String, person_phone_number:String){
        pds.update(person_id,person_name,person_phone_number)
    }
    suspend fun delete(person_id:Int){
        pds.delete(person_id)
    }
}
