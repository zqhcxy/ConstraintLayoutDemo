package com.example.zqh.constraintlayoutdemo

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.title_item.view.*


class MainActivity : AppCompatActivity() {

    lateinit var lists: List<String>
    lateinit var adapter: RecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lists = mutableListOf("相对位移", "屏障辅助")

        adapter = RecyclerAdapter(this, lists)
        constraint_recy.layoutManager = LinearLayoutManager(this)
        constraint_recy.adapter = adapter
        adapter.setItemClickListener(object : ItemClickListener {
            override fun click(v: View) {
                val pos = v?.tag
                when (pos) {
                    0 -> {//相对位移
                        val intent = Intent(this@MainActivity, RelativeConstraintActivity::class.java)
                        startActivity(intent)
                    }
                    1 -> {//屏障辅助
                        val intent = Intent(this@MainActivity, BarrierActivity::class.java)
                        startActivity(intent)
                    }
                }
            }
        })
    }


    class RecyclerAdapter(private val mContext: Context, private val titles: List<String>) : RecyclerView.Adapter<RecyclerAdapter.TitleViewHoler>() {


        private var inf: ItemClickListener? = null

        fun setItemClickListener(inf: ItemClickListener?) {
            this.inf = inf
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewtype: Int): TitleViewHoler {
            return TitleViewHoler(LayoutInflater.from(mContext).inflate(R.layout.title_item, parent, false))
        }

        override fun getItemCount(): Int {
            return titles?.size
        }

        override fun onBindViewHolder(viewHolder: TitleViewHoler, position: Int) {
            viewHolder.itemView.item_title_tv.text = titles.get(position)
            viewHolder.itemView.item_title_tv.tag = position
            viewHolder.itemView.item_title_tv.setOnClickListener {
                inf?.click(it)
            }
        }


        class TitleViewHoler(itemView: View) : RecyclerView.ViewHolder(itemView)
    }

    interface ItemClickListener {
        fun click(v: View)
    }


}

