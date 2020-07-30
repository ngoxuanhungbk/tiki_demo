package vn.hungnx.tikidemo.main.banner

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_main_banner.view.*
import vn.hungnx.tikidemo.R
import vn.hungnx.tikidemo.data.display.BannerDisplay

class BannerPagerAdapter(private val banners: List<BannerDisplay>) : PagerAdapter() {
    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun getCount(): Int {
        return banners.size
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val bannerView =
            LayoutInflater.from(container.context).inflate(R.layout.item_main_banner, null)
        val banner = banners[position]
        Glide.with(bannerView).load(banner.getImageUrl()).into(bannerView.img_cover)
        container.addView(bannerView)
        return bannerView
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

}