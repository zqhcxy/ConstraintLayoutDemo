package com.example.zqh.constraintlayoutdemo

import android.os.Bundle
import android.support.constraint.Group
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_barrier.*

/**
 * Barrier 屏障辅助
 */
class BarrierActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_barrier)


        group_btn.setOnClickListener {
            when (group_ly.visibility) {
                View.VISIBLE -> {
                    group_ly.visibility = View.GONE
//                    setGroupViewVisible(false,group_ly)
                }
                View.GONE -> {
                    group_ly.visibility = View.VISIBLE
//                    setGroupViewVisible(true,group_ly)
                }
            }

        }
    }

    /**
     * 设置Group的显示与隐藏(貌似无效)
     * <p> 通过读取Group中的每个View 来设置visibile
     */
    fun setGroupViewVisible(visible: Int, group: Group) {
        val ids = group.referencedIds
        for (id in ids) {
            group.findViewById<View>(id)?.visibility = visible
        }
    }


    /**
     * 设置Group的显示与隐藏
     * <p> 先把Group设置为Gone，再设置为INVISIBLE或者VISIBLE
     */
    fun setGroupViewVisible(show: Boolean, group: Group) {
        if (show) {
            group.visibility = View.GONE
            group.visibility = View.VISIBLE
        } else {
            group.visibility = View.GONE
            group.visibility = View.INVISIBLE
        }
    }


}