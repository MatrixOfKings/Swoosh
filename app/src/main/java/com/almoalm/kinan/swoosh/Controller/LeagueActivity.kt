package com.almoalm.kinan.swoosh.Controller


import android.content.Intent
import android.os.Bundle
import android.view.View
import com.almoalm.kinan.swoosh.R
import android.widget.Toast
import com.almoalm.kinan.swoosh.Model.Player
import com.almoalm.kinan.swoosh.Utilities.EXTRA_PLAYER
import kotlinx.android.synthetic.main.activity_league.*

class LeagueActivity : BaseActivity() {

    var player = Player("", "")


    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putParcelable(EXTRA_PLAYER, player)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_league)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        if(savedInstanceState !=null){
            player = savedInstanceState?.getParcelable<Player>(EXTRA_PLAYER)
        }
    }


    fun onMenClicked(view: View){
        womenLeagueBtn.isChecked = false
        coedLeagueBtn.isChecked = false

        player.league = "men"
    }

    fun onWomenClicked(view:View){
        menLeagueBtn.isChecked = false
        coedLeagueBtn.isChecked = false

        player.league = "women"
    }

    fun onCoedClicked(view:View){
        womenLeagueBtn.isChecked = false
        menLeagueBtn.isChecked = false

        player.league = "co-ed"
    }

    fun leagueNextBtn(view: View){
        if(!player.league.isEmpty()){
            val skillIntent = Intent(this, SkillActivity::class.java)
            skillIntent.putExtra(EXTRA_PLAYER, player)
            startActivity(skillIntent)
        }else{
            Toast.makeText(this, "Please Select a League.", Toast.LENGTH_SHORT).show()
        }

    }

}
