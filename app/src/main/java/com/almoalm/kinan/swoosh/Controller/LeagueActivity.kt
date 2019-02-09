package com.almoalm.kinan.swoosh.Controller


import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.almoalm.kinan.swoosh.R
import com.almoalm.kinan.swoosh.Utilities.EXTRA_LEAGUE
import kotlinx.android.synthetic.main.activity_league.*

class LeagueActivity : BaseActivity() {

    var selectedLeague = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_league)
    }


    fun onMenClicked(view: View){
        womenLeagueBtn.isChecked = false
        coedLeagueBtn.isChecked = false

        selectedLeague = "men"
    }

    fun onWomenClicked(view:View){
        menLeagueBtn.isChecked = false
        coedLeagueBtn.isChecked = false

        selectedLeague = "women"
    }

    fun onCoedClicked(view:View){
        womenLeagueBtn.isChecked = false
        menLeagueBtn.isChecked = false

        selectedLeague = "co-ed"
    }

    fun leagueNextBtn(view: View){
        if(!selectedLeague.isEmpty()){
            val skillIntent = Intent(this, SkillActivity::class.java)
            skillIntent.putExtra(EXTRA_LEAGUE, selectedLeague)
            startActivity(skillIntent)
        }else{
            Toast.makeText(this, "Please Select a League.", Toast.LENGTH_SHORT).show()
        }

    }

}
