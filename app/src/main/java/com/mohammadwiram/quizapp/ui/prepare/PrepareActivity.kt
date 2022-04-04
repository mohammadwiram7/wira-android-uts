package com.mohammadwiram.quizapp.ui.prepare

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mohammadwiram.quizapp.databinding.ActivityPrepareBinding
import com.mohammadwiram.quizapp.R
import com.mohammadwiram.quizapp.ui.content.ContentActivity
import org.jetbrains.anko.startActivity

class PrepareActivity : AppCompatActivity() {

  private lateinit var prepareBinding: ActivityPrepareBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    prepareBinding = ActivityPrepareBinding.inflate(layoutInflater)
    setContentView(prepareBinding.root)

    onClick()
  }

  private fun onClick() {
    prepareBinding.btnStart.setOnClickListener {
      // mengambil data dari inputan user
      val nickname = prepareBinding.etNickname.text.toString()
      if (checkValidation(nickname)) {
        startActivity<ContentActivity>(
          ContentActivity.EXTRA_NICKNAME to nickname
        )
      }
    }
  }

  private fun checkValidation(nickname: String): Boolean {
    return if (nickname.isEmpty()) {
      prepareBinding.etNickname.error = getString(R.string.please_field_your_nickname)
      false
    } else {
      true
    }
  }
}