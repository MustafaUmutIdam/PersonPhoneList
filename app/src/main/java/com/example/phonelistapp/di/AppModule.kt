package com.example.phonelistapp.di

import com.example.phonelistapp.data.datasource.PersonDataSource
import com.example.phonelistapp.data.repo.PersonRepository
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
    fun providePersonDataSource() : PersonDataSource{
        return PersonDataSource()
    }

    @Provides
    @Singleton
    fun providePersonRepository(pds:PersonDataSource) : PersonRepository {
        return PersonRepository(pds)
    }
}