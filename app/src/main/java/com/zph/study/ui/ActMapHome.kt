
package com.zph.study.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.util.Log
import com.amap.api.maps.AMap
import com.zph.study.R
import com.zph.study.util.FileUtil
import kotlinx.android.synthetic.main.activity_act_map_home.*
import java.io.File
import android.os.Environment.getExternalStorageDirectory



class ActMapHome : AppCompatActivity() {
    internal var mAMap: AMap?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_act_map_home)
        initMap(savedInstanceState)
    }
    private fun initMap(avedInstanceState: Bundle?){
        mapview.onCreate(avedInstanceState)
        mAMap=mapview.map
        mAMap!!.setMapCustomEnable(true)
        //online
//        mAMap!!.setCustomMapStyleID("51d8031f6d1b6154e7f5c2eb878b8a80")
        //outline
//        var flag:Boolean=FileUtil.copyAssetAndWrite(this,"style.data")
        var path=Environment.getExternalStorageDirectory().absolutePath+"/style.data"
        Log.i("TAGG","path:"+path)
        mAMap!!.setCustomMapStylePath(path)


    }

    override fun onResume() {
        super.onResume()
        mapview.onResume()
    }

    override fun onPause() {
        super.onPause()
        mapview.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        mapview.onDestroy()
    }
}
