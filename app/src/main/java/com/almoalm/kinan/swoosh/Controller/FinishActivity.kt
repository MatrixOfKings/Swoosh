package com.almoalm.kinan.swoosh.Controller

import android.os.Bundle
import com.almoalm.kinan.swoosh.Model.Player
import com.almoalm.kinan.swoosh.R
import com.almoalm.kinan.swoosh.Utilities.EXTRA_PLAYER
import kotlinx.android.synthetic.main.activity_finish.*

class FinishActivity : BaseActivity() {

    lateinit var player: Player

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finish)
        player = intent.getParcelableExtra(EXTRA_PLAYER)
        searchTxt.text = "Looking for a ${player.league} ${player.skill} league near you..."
    }



}
