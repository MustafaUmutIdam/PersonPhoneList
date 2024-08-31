package com.example.phonelistapp.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.phonelistapp.data.entity.Persons
import com.example.phonelistapp.databinding.CardDesignBinding
import com.example.phonelistapp.databinding.FragmentMainPageBinding
import com.example.phonelistapp.ui.fragment.MainPageFragmentDirections
import com.google.android.material.snackbar.Snackbar

class PersonAdapter(var mContext :Context, var personList:List<Persons>)
    //Inner Classi tanıması icin
    :RecyclerView.Adapter<PersonAdapter.CardDesignHolder>() {

    //CardDesign icin class
    inner class CardDesignHolder(var design : CardDesignBinding):RecyclerView.ViewHolder(design.root){

    }
    //Binding yapıp CardDesgina ulasmamızı saglıyor , asagıda icini olduruyoruz
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesignHolder {
        //CardDesignXml icin Binding
        val binding = CardDesignBinding.inflate(LayoutInflater.from(mContext),parent,false)
        return CardDesignHolder(binding)

    }

    override fun getItemCount(): Int {
        return personList.size

    }
    //Burda eristigimiz Design'in icindeki durumlara özgü islemler var
    override fun onBindViewHolder(holder: CardDesignHolder, position: Int) {

        val person = personList.get(position)
        //Binding icin holder (OnCreateViewHolder)
        val h = holder.design

        h.textViewPersonName.text = person.person_name
        h.textViewPersonPhoneNumber.text = person.person_phone_number

        h.cardViewRow.setOnClickListener {
            val transitionNav = MainPageFragmentDirections.mainToDetail(person=person)
            Navigation.findNavController(it).navigate(transitionNav)
        }
        h.imageViewDelete.setOnClickListener{
            Snackbar.make(it,"Do you wanna delete ${person.person_name} ? ", Snackbar.LENGTH_SHORT)
                .setAction("Yes") { delete(person.person_id) }
                .show()


        }

    }
    fun delete( person_id:Int){
        Log.e("The Person has been deleted : ",person_id.toString())

    }
}