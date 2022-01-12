package com.example.recyclerview_add_clubs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.recyclerview_add_clubs.databinding.ActivityMainBinding
import com.example.recyclerview_add_clubs.model.Club

class MainActivity : AppCompatActivity() {
    private lateinit var bin: ActivityMainBinding
    private var adapter = ClubAdapter()
    private var index = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bin = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bin.root)

        initViews()

    }

    private fun initViews() {
        val imageList = listOf(
            R.drawable.barselona,
            R.drawable.chelsea,
            R.drawable.totten,
            R.drawable.realmad,
            R.drawable.liverpool,
            R.drawable.mancity,
            R.drawable.psg,
        )
        bin.apply {
            recyclerview.layoutManager = GridLayoutManager(this@MainActivity, 3)
            recyclerview.adapter = adapter

            addBtn.setOnClickListener {
                if (index > 6) index = 0
                val club = Club(imageList[index], "Club $index")
                adapter.addClub(club)
                index++
            }
        }
    }
}