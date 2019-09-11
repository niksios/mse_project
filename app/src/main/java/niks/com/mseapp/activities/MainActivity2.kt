package niks.com.mseapp.activities

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

import niks.com.mseapp.R
import niks.com.mseapp.fragments.AlbumList_Fragment_Kotlin

class MainActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fm = supportFragmentManager
       // val fragment = AlbumList_Fragment()
        val fragment = AlbumList_Fragment_Kotlin()
        fm.beginTransaction().add(R.id.frameLayout, fragment).commit()

    }


    override fun onBackPressed() {

        val nik = Intent(applicationContext, SplashScreen_Menu::class.java)
        startActivity(nik)
        finish()
    }


}//main
