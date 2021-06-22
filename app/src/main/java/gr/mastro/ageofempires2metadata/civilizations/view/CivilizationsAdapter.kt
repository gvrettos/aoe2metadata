package gr.mastro.ageofempires2metadata.civilizations.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import gr.mastro.ageofempires2metadata.R
import gr.mastro.ageofempires2metadata.civilizations.data.CivilizationModel
import kotlinx.android.synthetic.main.civilization_item_view.view.*

class CivilizationsAdapter: RecyclerView.Adapter<CivilizationsAdapter.MainViewHolder>() {
    private var data : ArrayList<CivilizationModel>? = null

    fun setData(list: ArrayList<CivilizationModel>){
        data = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.civilization_item_view, parent, false))
    }

    override fun getItemCount(): Int {
        return data?.size ?: 0
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val item = data?.get(position)
        holder.bindView(item)
    }

    class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindView(item: CivilizationModel?) {
            itemView.item_title.text = item?.name
        }

    }
}