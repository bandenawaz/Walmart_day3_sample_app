package com.walmart.sampleproject

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var etMsg: EditText
    private lateinit var btnClick: Button
    private lateinit var btnDial: Button
    private lateinit var btnNext: Button
    private lateinit var btnShowAlert: Button
    private lateinit var linearLayout: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etMsg = findViewById(R.id.editTextMessage)
        btnClick = findViewById(R.id.buttonClick)
        btnDial = findViewById(R.id.buttonDial)
        btnNext = findViewById(R.id.buttonNext)
        btnShowAlert = findViewById(R.id.buttonAlert)
        linearLayout = findViewById(R.id.linearLayout)

        btnClick.setOnClickListener{

            //Toast.makeText(this,"Welcome to WM",Toast.LENGTH_LONG).show()
            val snack: Snackbar = Snackbar.make(linearLayout, "Welcome to WM",5000)
                .setAction("Retry",{})
            snack.show()
        }

        btnDial.setOnClickListener {

            val intent = Intent(Intent.ACTION_DIAL)
            startActivity(intent)
        }

        //launching a new activity
        btnNext.setOnClickListener{

            startActivity(Intent(this@MainActivity,WalmartActivity::class.java))
        }

        //for display alert
        btnShowAlert.setOnClickListener{

            var builder = AlertDialog.Builder(this@MainActivity)
            builder.setTitle("Exit")
            builder.setCancelable(false)
            builder.setMessage("Do you want to exit ?")
            builder.setPositiveButton("Yes", DialogInterface.OnClickListener{
                dialog, id -> finish()
            })

            builder.setNegativeButton("No", DialogInterface.OnClickListener{
                dialog, id -> dialog.cancel()
            })
            val alertDialog = builder.create()
            alertDialog.show()
        }
    }
}