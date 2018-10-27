package com.example.ilhamramadani.football
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.widget.LinearLayout
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView

class MainActivity : AppCompatActivity() {
    var clubfootball : MutableList<ModelFootball> = mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Data()
        verticalLayout {
            lparams(matchParent, matchParent){
                margin = dip(8)
            }
            orientation = LinearLayout.VERTICAL
            recyclerView {
                lparams(matchParent, matchParent)
                layoutManager = LinearLayoutManager(context)
                adapter = Adapter(clubfootball){
                    startActivity<Detail>(Detail.detail_extra to it)

                }

            }
        }
    }
    private fun Data(){
        val name = resources.getStringArray(R.array.nama_klub)
        val image = resources.obtainTypedArray(R.array.logo_klub)
        val keterangan = resources.getStringArray(R.array.detail_klub)
        clubfootball.clear()

        for (i in name.indices){
            clubfootball.add(ModelFootball(name[i], image.getResourceId(i,0), keterangan[i] ))
        }
        Log.e("info", clubfootball.size.toString())

        image.recycle()
    }
}
