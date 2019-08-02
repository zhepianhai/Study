package com.zph.study.adapter

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.zph.study.R

class AdpHome(context:Context, mListData:ArrayList<String>, private val itemClick:(String)->Unit): RecyclerView.Adapter<AdpHome.ViewHolder>() {
    private val TYPE_FLAG_1 = 1
    private val TYPE_FLAG_2 = 2
    private val TYPE_FLAG_3 = 3

    private var mContext: Context = context
    private var mList = ArrayList<String>()


    init {
        mList.clear()
        mList.addAll(mListData)
    }
    fun setData(mListData : String,position :Int ){
        mList[position]=mListData
        notifyItemChanged(position)
    }
    override fun onBindViewHolder(holder: AdpHome.ViewHolder, position: Int){
        holder.tv.text= mList[position]
        holder.tv.setOnClickListener {
            myRecycleItemClick!!.onRecyclePostionClick(position,mList[position])
            itemClick.invoke(mList[position])
        }
        when(getItemViewType(position)) {
            TYPE_FLAG_1 -> holder.tv.setTextColor(Color.BLACK)
            TYPE_FLAG_2 -> holder.tv.setTextColor(Color.RED)
            TYPE_FLAG_3 -> holder.tv.setTextColor(Color.BLUE)
        }
    }

    override fun getItemCount(): Int {
        return  mList.size
    }

    override fun getItemViewType(position: Int): Int = when (position%3) {
        0 -> TYPE_FLAG_1
        1 -> TYPE_FLAG_2
        else -> TYPE_FLAG_3
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdpHome.ViewHolder {
        return if(viewType==TYPE_FLAG_1){
            val horizontalFeed = LayoutInflater.from(mContext).inflate(R.layout.item_recycle_home, parent, false)
            ViewHolder(horizontalFeed)

        }else{
            val horizontalFeed = LayoutInflater.from(mContext).inflate(R.layout.item_recycle_home, parent, false)
            ViewHolder(horizontalFeed)
        }
    }
    class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
        var tv: TextView = itemView!!.findViewById(R.id.tv_item_recy_home)
    }
    private var  myRecycleItemClick: MyRecycleItemClick? = null
    fun setRecycleOnClickLinstener(myRecycleItemClick : MyRecycleItemClick){
        this.myRecycleItemClick=myRecycleItemClick
    }
     interface  MyRecycleItemClick{
        fun onRecyclePostionClick(position: Int,name :String)
    }
}