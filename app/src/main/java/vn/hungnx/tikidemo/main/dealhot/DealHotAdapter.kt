package vn.hungnx.tikidemo.main.dealhot

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import vn.hungnx.tikidemo.data.display.DealHotDisplay
import vn.hungnx.tikidemo.databinding.ItemMainDealhotBinding

class DealHotAdapter(private val items:List<DealHotDisplay>):RecyclerView.Adapter<DealHotAdapter.ViewHolder>() {

    class ViewHolder(private val binding: ItemMainDealhotBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindData(item:DealHotDisplay){
            binding.dealhot = item
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemMainDealhotBinding.inflate(LayoutInflater.from(parent.context))
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(items[position])
    }
}