package com.example.phonelistapp.util

import android.view.View
import androidx.navigation.NavDirections
import androidx.navigation.Navigation

//main page kayıt geçişi
fun Navigation.doTransition(it:View,id:Int){
    findNavController(it).navigate(id)
}
//adapter için NavD. kullanarak geçiş (kisi detay)
fun Navigation.doTransition(it:View,id:NavDirections){
    findNavController(it).navigate(id)
}