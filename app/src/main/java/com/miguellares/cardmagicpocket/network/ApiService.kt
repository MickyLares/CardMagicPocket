package com.miguellares.cardmagicpocket.network

import com.miguellares.cardmagicpocket.model.PersonajesCardsResponse
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiService {
    @GET("character")
    suspend fun getCardList(): Response<PersonajesCardsResponse>

    companion object {
        var apiService: ApiService? = null
        fun getInstance(): ApiService {
            if (apiService == null) {
                apiService = Retrofit.Builder().baseUrl("https://rickandmortyapi.com/api/")
                    .addConverterFactory(GsonConverterFactory.create()).build()
                    .create(ApiService::class.java)
            }
            return apiService!!
        }
    }
}