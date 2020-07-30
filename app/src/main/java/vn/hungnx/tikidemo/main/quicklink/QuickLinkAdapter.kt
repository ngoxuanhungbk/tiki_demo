package vn.hungnx.tikidemo.main.quicklink

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import vn.hungnx.tikidemo.data.display.QuickLinkDisplay
import vn.hungnx.tikidemo.databinding.ItemMainQuicklinkBinding

class QuickLinkAdapter(private val items: List<QuickLinkDisplay>) :
    RecyclerView.Adapter<QuickLinkAdapter.ItemQuickLinkViewHolder>() {

    class ItemQuickLinkViewHolder(private val binding: ItemMainQuicklinkBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindData(item:QuickLinkDisplay){
            binding.quicklink = item
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemQuickLinkViewHolder {
        val binding = ItemMainQuicklinkBinding.inflate(LayoutInflater.from(parent.context))
        return ItemQuickLinkViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ItemQuickLinkViewHolder, position: Int) {
        holder.bindData(items[position])
    }
}