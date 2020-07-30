package vn.hungnx.tikidemo.main.banner

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.view_main_banner.view.*
import vn.hungnx.tikidemo.R
import vn.hungnx.tikidemo.data.Banner

class BannerViewHolder (view:View):RecyclerView.ViewHolder(view){

    fun bindData(banners:List<Banner>){
        val padding = itemView.context.resources.getDimensionPixelSize(R.dimen.banner_padding)
        itemView.viewPager.clipToPadding = false
        itemView.viewPager.setPadding(padding,0,padding,0)
        itemView.viewPager.pageMargin = padding
        itemView.viewPager.adapter = BannerPagerAdapter(banners)
    }
}