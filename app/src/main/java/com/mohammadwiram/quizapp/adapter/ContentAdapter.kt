package com.mohammadwiram.quizapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mohammadwiram.quizapp.databinding.ItemContentBinding
import com.mohammadwiram.quizapp.model.Answer
import com.mohammadwiram.quizapp.model.Content

class ContentAdapter: RecyclerView.Adapter<ContentAdapter.ViewHolder>() {

  private var contents = mutableListOf<Content>()

  class ViewHolder(private val itemContentBinding: ItemContentBinding)
    : RecyclerView.ViewHolder(itemContentBinding.root) {
    fun bindItem(content: Content) {
      val answerAdapter = AnswerAdapter()

      // menampilkan teks pertanyaan quiz dari data gson
      itemContentBinding.tvQuiz.text = content.body

      // menampilkan gambar dari data gson
      if (content.image != null && content.image.isNotEmpty()){
        itemContentBinding.ivQuiz.visibility = View.VISIBLE
        Glide.with(itemView)
          .load(content.image)
          .placeholder(android.R.color.darker_gray)
          .into(itemContentBinding.ivQuiz)
      }else{
        itemContentBinding.ivQuiz.visibility = View.GONE
      }

      // menampilkan asnwer adapter
      if (content.answers != null){
        answerAdapter.setData(content.answers as MutableList<Answer>)

        itemContentBinding.rvAnswerQuiz.adapter = answerAdapter
      }
    }

  }

  // mengembalikan data binding
  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    val binding = ItemContentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    return ViewHolder(binding)
  }

  // memecah data ke dalam bentuk objek
  override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    holder.bindItem(contents[position])
  }

  override fun getItemCount(): Int = contents.size

  // menginformasikan bila terjadi perubahan data
  fun setData(contents: MutableList<Content>){
    this.contents = contents
    notifyDataSetChanged()
  }

  fun getResults(): MutableList<Content> {
    return contents
  }
}