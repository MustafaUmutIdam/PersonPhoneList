package com.example.phonelistapp.di

import com.example.phonelistapp.data.datasource.PersonDataSource
import com.example.phonelistapp.data.repo.PersonRepository
import com.google.firebase.Firebase
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.firestore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


//Nesneleri tek seferde olusturarak tekrar tekrar kullanılmasını sağlıyoruz
//Gerekli nesneleri burda tek tek sağlamalıyız
@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun providePersonDataSource(collectionPersons:CollectionReference) : PersonDataSource{
        return PersonDataSource(collectionPersons)
    }

    @Provides
    @Singleton
    fun providePersonRepository(pds:PersonDataSource) : PersonRepository {
        return PersonRepository(pds)
    }

    @Provides
    @Singleton
    fun provideCollectionReference() : CollectionReference{
        return Firebase.firestore.collection("Persons")
    }

}