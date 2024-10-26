package com.example.phonelistapp.data.datasource

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.phonelistapp.data.entity.Persons
import com.google.firebase.firestore.CollectionReference

//DataBase erişmek için collection kullanacagız
class PersonDataSource(var collectionPersons: CollectionReference) {
//FireBase LiveData ile çalışıyor
     var personList = MutableLiveData<List<Persons>>()


     fun uploadPersons(): MutableLiveData<List<Persons>> {
        collectionPersons.addSnapshotListener { value, error ->
            if (value != null){
                val list = ArrayList<Persons>()

                for (d in value.documents){
                    val person = d.toObject(Persons::class.java)

                    if (person!=null)
                        person.person_id=d.id
                    list.add(person!!)
                }
                personList.value=list
            }

        }

         return  personList
     }

     fun search(searchingPerson:String) : MutableLiveData<List<Persons>> {
         collectionPersons.addSnapshotListener { value, error ->
             if (value != null){
                 val list = ArrayList<Persons>()

                 for (d in value.documents){
                     val person = d.toObject(Persons::class.java)

                     if (person!=null){
                         if (person.person_name!!.lowercase().contains(searchingPerson.lowercase())) {
                             person.person_id = d.id
                             list.add(person)
                         }
                     }
                 }
                 personList.value=list
             }

         }

         return  personList
     }

     fun save(person_name:String, person_phone_number:String){
        val newPerson = Persons("",person_name,person_phone_number)
         collectionPersons.document().set(newPerson)

    }

     fun update(person_id:String,person_name:String, person_phone_number:String){
        val updatedPerson = HashMap<String,Any>()
         updatedPerson["person_name"]=person_name
         updatedPerson["person_phone_number"]=person_phone_number
         collectionPersons.document(person_id).update(updatedPerson)
    }

     fun delete(person_id:String){
        collectionPersons.document(person_id).delete()

    }
}