package gr.mastro.ageofempires2metadata.civilizations.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import gr.mastro.ageofempires2metadata.R
import kotlinx.android.synthetic.main.activity_civilizations.*

class CivilizationsActivity : AppCompatActivity() {
    private var civilizationsAdapter : CivilizationsAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_civilizations)

        initAdapter()

        // set some dummy data
        civilizationsAdapter?.setData(arrayListOf<String>("Britons", "Celts", "Mongols"))
    }

    private fun initAdapter() {
        civilizations.apply {
            layoutManager = LinearLayoutManager(this@CivilizationsActivity)
            civilizationsAdapter = CivilizationsAdapter()
            adapter = civilizationsAdapter
        }
    }
}
