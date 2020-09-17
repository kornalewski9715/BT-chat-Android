package com.example.technologiemobilneprojekt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        SettingsB.setOnClickListener{
            var message=Toast.makeText(applicationContext,"Settings",Toast.LENGTH_SHORT)
            message.show()

            var SettingsActivity: Intent=Intent(applicationContext,Settings::class.java)
            startActivity(SettingsActivity)

        }

        PairDevices.setOnClickListener{
            var message=Toast.makeText(applicationContext,"Chat",Toast.LENGTH_SHORT)
            message.show()

            var PairDavicesChatActivity: Intent=Intent(applicationContext,PairDavicesChat::class.java)
            startActivity(PairDavicesChatActivity)

        }




    }
}