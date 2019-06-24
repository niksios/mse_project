package niks.com.mseapp

import android.app.FragmentManager
import android.app.FragmentTransaction
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.ListView

import java.util.Arrays
import java.util.Collections

import niks.com.mseapp.Album_Modal.Albums_Modal
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

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
