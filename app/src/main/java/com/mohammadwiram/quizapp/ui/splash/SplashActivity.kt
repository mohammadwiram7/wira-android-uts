package com.mohammadwiram.quizapp.ui.splash

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.mohammadwiram.quizapp.R
import com.mohammadwiram.quizapp.ui.main.MainActivity
import org.jetbrains.anko.startActivity

class SplashActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_splash)

    delayAndGotoMain()
  }

  private fun delayAndGotoMain() {
    /*
    * halaman splash akan delay selama 1.2 detik
    * kemudian menjalankan MainActivity
    * */
    Handler(Looper.getMainLooper()).postDelayed({
      startActivity<MainActivity>()
    }, 1200)
  }
}