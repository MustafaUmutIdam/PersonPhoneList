package com.example.phonelistapp.data.datasource

import android.util.Log
import com.example.phonelistapp.data.entity.Persons
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PersonDataSource {

    //Data Oldugu icin IO (input Output)
    suspend fun uploadPersons(): List<Persons> =
        withContext(Dispatchers.IO){
            val personList= ArrayList<Persons>()
            val p1 = Persons(1,"Ays","383838")
            val p2 = Persons(2,"Duygu","333333")
            val p3 = Persons(3,"Semih","343434")

            personList.add(p1)
            personList.add(p2)
            personList.add(p3)
            return@withContext personList
        }
    suspend fun search(searchingPerson:String) : List<Persons> =
    withContext(Dispatchers.IO){
        val personList= ArrayList<Persons>()
        val p1 = Persons(1,"Ays","383838")

        personList.add(p1)
        return@withContext personList
    }

    suspend fun save(person_name:String, person_phone_number:String){
        Log.e("The person is saved ", "$person_name - $person_phone_number")
    }

    suspend fun update(person_id:Int,person_name:String, person_phone_number:String){
        Log.e("The person has been updated ", "$person_id-$person_name - $person_phone_number")
    }

    suspend fun delete(person_id:Int){
        Log.e("The Person has been deleted : ",person_id.toString())

    }
}