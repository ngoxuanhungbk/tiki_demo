package vn.hungnx.tikidemo.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import vn.hungnx.tikidemo.R
import vn.hungnx.tikidemo.base.BaseUI
import vn.hungnx.tikidemo.data.Banner
import vn.hungnx.tikidemo.data.DealHot
import vn.hungnx.tikidemo.data.QuickLink
import vn.hungnx.tikidemo.data.Result
import vn.hungnx.tikidemo.main.banner.BannerViewHolder
import vn.hungnx.tikidemo.main.dealhot.DealHotViewHolder
import vn.hungnx.tikidemo.main.quicklink.QuickLinkViewHolder

class MainAdapter(private var items: List<Result<List<BaseUI>>>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    fun updateData(data: List<Result<List<BaseUI>>>) {
        items = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            R.layout.view_main_loading -> LoadingViewHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.view_main_loading, parent, false)
            )
            R.layout.view_main_banner -> BannerViewHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.view_main_banner, parent, false)
            )
            R.layout.view_main_quicklink -> QuickLinkViewHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.view_main_quicklink, parent, false)
            )
            R.layout.view_main_dealhot -> DealHotViewHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.view_main_dealhot,parent,false)
            )
            else -> LoadingViewHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.view_main_loading, parent, false)
            )
        }
    }

    override fun getItemViewType(position: Int): Int {
        if (items[position] is Result.Loading) {
            return R.layout.view_main_loading
        } else if ((items[position] as Result.Success<*>).data is List<*>) {
            when (((items[position] as Result.Success<*>).data as List<*>)[0]) {
                is Banner -> {
                    return R.layout.view_main_banner
                }
                is QuickLink -> {
                    return R.layout.view_main_quicklink
                }
                is DealHot -> {
                    return R.layout.view_main_dealhot
                }
            }
        }
        return R.layout.view_main_banner
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (items[position] is Result.Loading) {

        } else if ((items[position] as Result.Success<*>).data is List<*>) {
            when (((items[position] as Result.Success<*>).data as List<*>)[0]) {
                is Banner -> {
                    (holder as BannerViewHolder).bindData((items[position] as Result.Success<*>).data as List<Banner>)
                }
                is QuickLink -> {
                    (holder as QuickLinkViewHolder).bindData((items[position] as Result.Success<*>).data as List<QuickLink>)
                }
                is DealHot -> {
                    (holder as DealHotViewHolder).bindData((items[position] as Result.Success<*>).data as List<DealHot>)
                }
            }
        }
    }
}