package niks.com.mseapp.activities

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.ImageButton
import niks.com.mseapp.R

class SplashScreen_Menu : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splashscreen_menu)


        val screen1 = findViewById<View>(R.id.screen1) as ImageButton
        val screen2 = findViewById<View>(R.id.screen2) as ImageButton


        screen1.setOnClickListener {
            val nik = Intent(applicationContext, MainActivity2::class.java)
            startActivity(nik)
            finish()
        }


        screen2.setOnClickListener {
            val nik = Intent(applicationContext, MainActivity3::class.java)
            startActivity(nik)
            finish()
        }


    }//oncreate

    override fun onBackPressed() {

        AlertDialog.Builder(this@SplashScreen_Menu)
                .setMessage("Do you want to exit!")
                .setIcon(R.mipmap.ando)
                .setPositiveButton("YES") { dialog, which ->
                    val homeIntent = Intent(Intent.ACTION_MAIN)
                    homeIntent.addCategory(Intent.CATEGORY_HOME)
                    homeIntent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
                    startActivity(homeIntent)
                    finish()
                }.setNegativeButton("NO") { dialog, which -> dialog.cancel() }.show()


    }


}//main
