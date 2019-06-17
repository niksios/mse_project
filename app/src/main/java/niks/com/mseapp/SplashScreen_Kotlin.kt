package niks.com.mseapp

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

import java.util.Timer
import java.util.TimerTask

class SplashScreen_Kotlin : AppCompatActivity() {

    internal var sp: SharedPreferences? = null
    internal var editor: SharedPreferences.Editor? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splashscreen)

        val tm = Timer()
        tm.schedule(object : TimerTask() {
            override fun run() {

                val nik = Intent(applicationContext, SplashScreen_Menu::class.java)
                startActivity(nik)
                finish()

            }
        }, 1000)

    }
}
