package com.zhewen.eyepetizersimulation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.youth.banner.adapter.BannerAdapter
import com.zhewen.eyepetizer_common.util.font.CustomFontText
import com.zhewen.eyepetizersimulation.R
import com.zhewen.eyepetizersimulation.bean.ImageTitleBean

/**
 * 图片+标题适配器
 */
class ImageTitleAdapter(private val mMutableList: MutableList<ImageTitleBean>): BannerAdapter<ImageTitleBean, ImageTitleAdapter.ImageTitleViewHolder>(mMutableList) {

    fun updateData(data:List<ImageTitleBean>) {
        mMutableList.clear()
        mMutableList.addAll(data)
        notifyDataSetChanged()
    }

    override fun onCreateHolder(parent: ViewGroup?, viewType: Int): ImageTitleViewHolder? {
        return LayoutInflater.from(parent?.context)?.inflate(R.layout.banner_image_title,parent,false)?.let {
            ImageTitleViewHolder(it)
        }
    }

    override fun onBindView(holder: ImageTitleViewHolder?, data: ImageTitleBean?, position: Int, size: Int) {

        data?.imageRes?.let { holder?.mBannerImageView?.setImageResource(it) }
        holder?.mBannerText?.text = data?.title
        if (position == itemCount -1) {
            holder?.mBannerButton?.visibility = View.VISIBLE
            holder?.mBannerButton?.setOnClickListener {
                //todo 跳转到主页面
            }
        } else {
            holder?.mBannerButton?.visibility = View.GONE
        }
    }

    override fun getItemCount(): Int {
        return mMutableList.size
    }

    class ImageTitleViewHolder(view: View):RecyclerView.ViewHolder(view) {
        val mBannerImageView:ImageView by lazy { view.findViewById(R.id.welcome_banner_image) }
        val mBannerText : CustomFontText by lazy { view.findViewById(R.id.welcome_banner_title) }
        val mBannerButton : Button by lazy { view.findViewById(R.id.welcome_enter_home_page) }
    }
}
