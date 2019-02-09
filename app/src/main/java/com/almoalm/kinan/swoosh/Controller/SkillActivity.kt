package com.almoalm.kinan.swoosh.Controller

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.almoalm.kinan.swoosh.R
import com.almoalm.kinan.swoosh.Utilities.EXTRA_LEAGUE
import com.almoalm.kinan.swoosh.Utilities.EXTRA_SKILL
import kotlinx.android.synthetic.main.activity_skill.*

class SkillActivity : BaseActivity() {

    var league = ""
    var skill =""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skill)
        league = intent.getStringExtra(EXTRA_LEAGUE)
        Toast.makeText(this, league, Toast.LENGTH_SHORT).show()
    }

    fun onBeginnerClicked(view: View){
        if(!beginnerBtn.isChecked){
            skill = ""
        }else{
            ballerBtn.isChecked = false
            skill = "beginner"
        }
    }

    fun onBallerClicked(view: View){
        if(!ballerBtn.isChecked){
            skill = ""
        }else{
            beginnerBtn.isChecked = false
            skill = "baller"
        }
    }

    fun onFinishClicked(view: View){
        if(!skill.isEmpty()){
            val finishActivity = Intent(this, FinishActivity::class.java)
            finishActivity.putExtra(EXTRA_LEAGUE, league)
            finishActivity.putExtra(EXTRA_SKILL, skill)
            startActivity(finishActivity)
        }else{
            Toast.makeText(this, "Please Select a Skill.", Toast.LENGTH_SHORT).show()
        }
    }


}
