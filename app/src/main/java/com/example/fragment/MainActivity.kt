package com.example.fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    var isFragmentLoaded = 0
    val manager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val leftbutton = findViewById<Button>(R.id.btn_back)
        val rightbutton = findViewById<Button>(R.id.btn_next)
        showFragmentOne()

        rightbutton.setOnClickListener {
            isFragmentLoaded++
            if(isFragmentLoaded == 1){
                showFragmentTwo()
            }else if(isFragmentLoaded == 2){
                showFragmentThree()
            }
        }
        leftbutton.setOnClickListener {
            isFragmentLoaded--
            if (isFragmentLoaded == 1){
                showFragmentTwo()
            }else if(isFragmentLoaded == 0){
                showFragmentOne()
            }
        }


    }

    fun showFragmentOne() {
        val transaction = manager.beginTransaction()
        val fragment = FragmentOne()
        transaction.replace(R.id.fl_layout, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
        val leftbutton = findViewById<Button>(R.id.btn_back)
        leftbutton.setEnabled(false)

    }
    fun showFragmentTwo() {
        val transaction = manager.beginTransaction()
        val fragment = FragmentTwo()
        transaction.replace(R.id.fl_layout, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
        val leftbutton = findViewById<Button>(R.id.btn_back)
        leftbutton.setEnabled(true)

        val rightbutton = findViewById<Button>(R.id.btn_next)
        rightbutton.setEnabled(true)
    }
    fun showFragmentThree() {
        val transaction = manager.beginTransaction()
        val fragment = FragmentThree()
        transaction.replace(R.id.fl_layout, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
        val rightbutton = findViewById<Button>(R.id.btn_next)
        rightbutton.setEnabled(false)
    }

}
