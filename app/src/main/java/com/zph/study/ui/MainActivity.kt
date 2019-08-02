package com.zph.study.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.zph.study.R
import com.zph.study.adapter.AdpHome
import com.zph.study.anko.act.MainActivityAnkoView
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity(), AdpHome.MyRecycleItemClick {


    var mListData= ArrayList<String>()
    var adapter :AdpHome ? = null
    var mTimer : Timer=Timer()
    var task :TimerTask?=null
    val sdf : SimpleDateFormat=SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initData()
        recycle_home.layoutManager=LinearLayoutManager(this)
        adapter= AdpHome(this,mListData){
//            toast(it)
        }
        recycle_home.adapter=adapter
        adapter!!.setRecycleOnClickLinstener(this)
        task= object : TimerTask() {
            override fun run() {
                runOnUiThread {
                    adapter!!.setData("当前时间:"+sdf.format(Date()),0)
                }
            }
        }
        mTimer!!.scheduleAtFixedRate(task, 0, (1 * 1000).toLong())
    }
    fun initData(){
        mListData.clear()
        mListData.add("")
        mListData.add("Map,List,Bean")
        mListData.add("Recycle列表3")
        mListData.add("Recycle列表4")
        mListData.add("Recycle列表5")
        mListData.add("Recycle列表6")
    }

    override fun onRecyclePostionClick(position: Int, name: String)=when(position) {
        0->{}
        1->{
            val intent= Intent(this,ActMapListBean::class.java)
            startActivity(intent)
        }
        else -> {
        }
    }
}
