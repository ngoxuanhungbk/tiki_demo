package vn.hungnx.tikidemo.main.quicklink

import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.view_main_quicklink.view.*
import vn.hungnx.tikidemo.data.QuickLink

class QuickLinkViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    fun bindData(items: List<QuickLink>) {
        itemView.recyclerView.layoutManager =
            GridLayoutManager(itemView.context, 2, GridLayoutManager.HORIZONTAL, false)
        itemView.recyclerView.adapter = QuickLinkAdapter(items)
    }
}