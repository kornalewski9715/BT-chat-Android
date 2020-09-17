package com.example.technologiemobilneprojekt

import android.app.Activity
import android.bluetooth.BluetoothAdapter
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_settings.*

class Settings : AppCompatActivity() {
    private val REQUEST_CODE_ENABLE_BT:Int=1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        //init B Adapter
        var bAdapter: BluetoothAdapter ? = BluetoothAdapter.getDefaultAdapter()
        //check B is avaiable/not avaiable
        if(bAdapter==null){
            BluetoothStatus.text="Bluetooth is not avaiable"
        }
        else{
            BluetoothStatus.text="Bluetooth is avaiable"
        }

        ButtonON.setOnClickListener {
            if(bAdapter!!.isEnabled){
                //already enable
                Toast.makeText(this,"Already on", Toast.LENGTH_SHORT).show()
            }
            else{
                //turn ON
                val intent =Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE)
                startActivityForResult(intent, REQUEST_CODE_ENABLE_BT)
            }
        }
        ButtonOff.setOnClickListener {
            if(!(bAdapter!!.isEnabled)){
                //already enable
                Toast.makeText(this,"Already off", Toast.LENGTH_SHORT).show()
            }
            else{
                //turn OFF
                bAdapter.disable()
                Toast.makeText(this,"BT turned off", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        when(requestCode){
            REQUEST_CODE_ENABLE_BT ->
                if(resultCode==Activity.RESULT_OK){
                    Toast.makeText(this,"BT is on",Toast.LENGTH_SHORT).show()
                }
                else{
                    Toast.makeText(this,"Could not be on BT",Toast.LENGTH_SHORT).show()
                }
        }
        super.onActivityResult(requestCode, resultCode, data)
    }

}