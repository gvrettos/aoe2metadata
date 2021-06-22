package gr.mastro.ageofempires2metadata.civilizations.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import gr.mastro.ageofempires2metadata.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CivilizationsRepository {

    fun fetchAllCivilizations(): LiveData<List<CivilizationModel>> {
        val data = MutableLiveData<List<CivilizationModel>>()

        ApiClient.apiService.fetchAllCivilizations().enqueue(object : Callback<CivilizationsModel> {

            override fun onFailure(call: Call<CivilizationsModel>, t: Throwable) {
                data.value = null
            }

            override fun onResponse(
                call: Call<CivilizationsModel>,
                response: Response<CivilizationsModel>) {

                val res = response.body()
                if (response.code() == 200 && res != null) {
                    data.value = res.civilizations
                } else {
                    data.value = null
                }
            }
        })
        return data
    }

}