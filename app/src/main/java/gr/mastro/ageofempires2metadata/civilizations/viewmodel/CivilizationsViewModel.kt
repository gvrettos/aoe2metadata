package gr.mastro.ageofempires2metadata.civilizations.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import gr.mastro.ageofempires2metadata.civilizations.data.CivilizationModel
import gr.mastro.ageofempires2metadata.civilizations.data.CivilizationsRepository

class CivilizationsViewModel : ViewModel() {
    private var civilizationsRepository: CivilizationsRepository? = null
    var civilizationModelListLiveData : LiveData<List<CivilizationModel>>? = null

    init {
        civilizationsRepository = CivilizationsRepository()
        civilizationModelListLiveData = MutableLiveData()
    }

    fun fetchAllCivilizations() {
        civilizationModelListLiveData = civilizationsRepository?.fetchAllCivilizations()
    }
}