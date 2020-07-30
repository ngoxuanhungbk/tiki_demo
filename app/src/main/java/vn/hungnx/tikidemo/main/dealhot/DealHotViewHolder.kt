package vn.hungnx.tikidemo.main.dealhot

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.view_main_dealhot.view.*
import vn.hungnx.tikidemo.data.DealHot

class DealHotViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    fun bindData(items: List<DealHot>) {
        itemView.recyclerView.layoutManager =
            LinearLayoutManager(itemView.context, LinearLayoutManager.HORIZONTAL, false)
        itemView.recyclerView.adapter = DealHotAdapter(items)
    }
}