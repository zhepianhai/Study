package com.zph.study.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.zph.study.R
import kotlinx.android.synthetic.main.activity_act_map_list_bean.*

class ActMapListBean : AppCompatActivity() {
    var sb : StringBuilder =StringBuilder()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_act_map_list_bean)
        initMap()
        initBean()
        tv_map_list_bean.text=sb.toString()
    }

    private fun initMap() {
        sb.append("Map:\n")
        var hashMap : HashMap<Int,String> =HashMap()
        hashMap.put(1,"value1")
        hashMap.put(2,"value2")
        hashMap.put(3,"value3")
        sb.append("1:"+hashMap[1]+"\n")
        hashMap.put(1,"value11")
        sb.append("1_:"+hashMap[1]+"\n")
    }
    private fun initBean(){
        val user :User= User()
        user.userName="name"
        user.psd="1234"
        sb.append(user.toString()+"\n")
    }

    class User{
        var userName : String=""
        var psd : String=""
    }
}
