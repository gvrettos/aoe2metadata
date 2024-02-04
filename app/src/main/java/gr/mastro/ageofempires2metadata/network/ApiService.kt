package gr.mastro.ageofempires2metadata.network

import gr.mastro.ageofempires2metadata.civilizations.data.CivilizationModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("civilizations")
    fun fetchAllCivilizations(): Call<List<CivilizationModel>>
}