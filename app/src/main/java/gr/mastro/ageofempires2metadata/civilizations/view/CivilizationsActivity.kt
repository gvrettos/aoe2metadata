package gr.mastro.ageofempires2metadata.civilizations.view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import gr.mastro.ageofempires2metadata.R
import gr.mastro.ageofempires2metadata.civilizations.data.CivilizationModel
import gr.mastro.ageofempires2metadata.civilizations.viewmodel.CivilizationsViewModel
import kotlinx.android.synthetic.main.activity_civilizations.*

class CivilizationsActivity : AppCompatActivity() {
    private var civilizationsAdapter : CivilizationsAdapter? = null
    lateinit var viewModel : CivilizationsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_civilizations)

        initAdapter()

        viewModel = ViewModelProvider(this).get(CivilizationsViewModel::class.java)
        viewModel.fetchAllCivilizations()
        viewModel.civilizationModelListLiveData?.observe(this, Observer {
            if (it != null) {
                civilizations.visibility = View.VISIBLE
                civilizationsAdapter?.setData(it as ArrayList<CivilizationModel>)
            } else {
                showToast("Something went wrong! No data retrieved...")
            }
            progress_civilizations.visibility = View.GONE
        })
    }

    private fun initAdapter() {
        civilizations.apply {
            layoutManager = LinearLayoutManager(this@CivilizationsActivity)
            civilizationsAdapter = CivilizationsAdapter()
            adapter = civilizationsAdapter
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}
