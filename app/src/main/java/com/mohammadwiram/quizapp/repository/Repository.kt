package com.mohammadwiram.quizapp.repository

import android.content.Context
import com.mohammadwiram.quizapp.model.Content
import com.mohammadwiram.quizapp.model.Contents
import com.google.gson.Gson
import java.io.IOException

object Repository {
  fun getDataContents(context: Context?): List<Content>? {
    val json: String?
    try {
      // menampilkan data dari file json
      val inputStream = context?.assets?.open("json/contents.json")
      json = inputStream?.bufferedReader().use { it?.readText() }
    } catch (e: IOException) {
      return null
    }
    // data dari file json diubah ke objek menggunakan library gson
    // untuk selanjutnya ditampilkan
    val contents = Gson().fromJson(json, Contents::class.java)
    return contents.contents
  }
}