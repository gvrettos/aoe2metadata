package gr.mastro.ageofempires2metadata.civilizations.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import gr.mastro.ageofempires2metadata.civilizations.data.CivilizationModel
import gr.mastro.ageofempires2metadata.databinding.CivilizationItemViewBinding

class CivilizationsAdapter: RecyclerView.Adapter<CivilizationsAdapter.MainViewHolder>() {
    private var data : ArrayList<CivilizationModel>? = null

    fun setData(list: ArrayList<CivilizationModel>){
        data = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val binding = CivilizationItemViewBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return MainViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return data?.size ?: 0
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val item = data?.get(position)
        holder.bindView(item)
    }

    class MainViewHolder(private val binding: CivilizationItemViewBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bindView(item: CivilizationModel?) {
            binding.itemTitle.text = "${item?.id}. ${item?.name} (${item?.expansion})"
            binding.itemDescription.text = item?.army_type
        }
    }
}