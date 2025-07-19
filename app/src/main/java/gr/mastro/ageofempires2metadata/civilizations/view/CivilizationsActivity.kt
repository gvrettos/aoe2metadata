package gr.mastro.ageofempires2metadata.civilizations.view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import gr.mastro.ageofempires2metadata.civilizations.data.CivilizationModel
import gr.mastro.ageofempires2metadata.civilizations.viewmodel.CivilizationsViewModel
import gr.mastro.ageofempires2metadata.databinding.ActivityCivilizationsBinding

class CivilizationsActivity : AppCompatActivity() {
    private var civilizationsAdapter : CivilizationsAdapter? = null
    private lateinit var viewModel : CivilizationsViewModel
    private lateinit var binding: ActivityCivilizationsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCivilizationsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        initAdapter()

        viewModel = ViewModelProvider(this)[CivilizationsViewModel::class.java]
        viewModel.fetchAllCivilizations()
        viewModel.civilizationModelListLiveData?.observe(this, Observer {
            if (it != null) {
                binding.civilizations.visibility = View.VISIBLE
                civilizationsAdapter?.setData(it as ArrayList<CivilizationModel>)
            } else {
                showToast("Something went wrong! No data retrieved...")
            }
            binding.progressCivilizations.visibility = View.GONE
        })
    }

    private fun initAdapter() {
        binding.civilizations.apply {
            layoutManager = LinearLayoutManager(this@CivilizationsActivity)
            civilizationsAdapter = CivilizationsAdapter()
            adapter = civilizationsAdapter
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}
