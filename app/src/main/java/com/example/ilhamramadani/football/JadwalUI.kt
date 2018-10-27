package com.example.ilhamramadani.football

import android.view.Gravity
import android.view.ViewGroup
import android.widget.LinearLayout
import org.jetbrains.anko.*

class JadwalUI : AnkoComponent<ViewGroup> {
    companion object {
        var clubfootball = 1
        val logofootball = 2
    }

    override fun createView(ui: AnkoContext<ViewGroup>)= with(ui) {
        relativeLayout {
            padding = dip(8)
            linearLayout {
                orientation = LinearLayout.VERTICAL
                linearLayout {
                    orientation = LinearLayout.HORIZONTAL
                    imageView {
                        id = logofootball
                    }.lparams(dip(55), dip(55))
                    textView {
                        id = clubfootball
                        textSize = sp(9).toFloat()
                    }.lparams(matchParent, wrapContent) {
                        margin = dip(10)
                        gravity = Gravity.CENTER_VERTICAL
                    }
                    view {
                        backgroundColor = R.color.colorPrimary

                    }.lparams(dip(2))
                }
            }
        }
    }
}
