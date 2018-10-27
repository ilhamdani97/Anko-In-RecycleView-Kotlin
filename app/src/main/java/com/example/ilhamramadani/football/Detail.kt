package com.example.ilhamramadani.football

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.view.View
import android.widget.LinearLayout
import com.bumptech.glide.Glide
import org.jetbrains.anko.*

class Detail : AppCompatActivity() {
    companion object {
        val detail = 2
        val detail_extra = "detail_extra"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val l = intent.getParcelableExtra<ModelFootball>(detail_extra)
        DetailUI(l).setContentView(this)
    }
    internal class DetailUI(var list: ModelFootball) : AnkoComponent<Detail>{
        override fun createView(ui: AnkoContext<Detail>) = with(ui){
            linearLayout {
                orientation = LinearLayout.VERTICAL
                lparams(matchParent, matchParent)
                imageView(){
                    Glide.with(this).load(list.logo).into(this)
                    id = JadwalUI.logofootball
                    padding = dip(8)
                    this@linearLayout.gravity = Gravity.CENTER_HORIZONTAL
                }.lparams(dip(200), dip(200))

                textView{
                    id = JadwalUI.clubfootball
                    text = list.club
                    textSize = sp(14).toFloat()
                    padding = dip(4)
                }
                textView{
                    id = detail
                    text = list.detail
                    padding = dip(10)
                }

            }
        }
    }
}