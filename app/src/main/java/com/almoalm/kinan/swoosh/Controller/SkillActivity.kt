package com.almoalm.kinan.swoosh.Controller

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.almoalm.kinan.swoosh.Model.Player
import com.almoalm.kinan.swoosh.Utilities.EXTRA_PLAYER
import kotlinx.android.synthetic.main.activity_skill.*
import com.almoalm.kinan.swoosh.R

class SkillActivity : BaseActivity() {

    lateinit var player: Player

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putParcelable(EXTRA_PLAYER, player)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skill)
        player = intent.getParcelableExtra(EXTRA_PLAYER)
        Toast.makeText(this, player.league, Toast.LENGTH_SHORT).show()
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        if(savedInstanceState != null)
            player = savedInstanceState.getParcelable(EXTRA_PLAYER)
    }

    fun onBeginnerClicked(view: View){
        if(!beginnerBtn.isChecked){
            player.skill = ""
        }else{
            ballerBtn.isChecked = false
            player.skill = "beginner"
        }
    }

    fun onBallerClicked(view: View){
        if(!ballerBtn.isChecked){
            player.skill = ""
        }else{
            beginnerBtn.isChecked = false
            player.skill = "baller"
        }
    }

    fun onFinishClicked(view: View){
        if(!player.skill.isEmpty()){
            val finishActivity = Intent(this, FinishActivity::class.java)
            finishActivity.putExtra(EXTRA_PLAYER, player)
            startActivity(finishActivity)
        }else{
            Toast.makeText(this, "Please Select a Skill.", Toast.LENGTH_SHORT).show()
        }
    }


}
