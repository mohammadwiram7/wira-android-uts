package com.mohammadwiram.quizapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mohammadwiram.quizapp.R
import com.mohammadwiram.quizapp.databinding.ItemAnswerBinding
import com.mohammadwiram.quizapp.model.Answer

class AnswerAdapter: RecyclerView.Adapter<AnswerAdapter.ViewHolder>() {

  private var answers = mutableListOf<Answer>()

  inner class ViewHolder(private val itemAnswerBinding: ItemAnswerBinding)
    : RecyclerView.ViewHolder(itemAnswerBinding.root) {
    fun bindItem(answer: Answer) {
      // menampilkan data sesuai objek gson yang sebelumnya
      // telah dipecah
      itemAnswerBinding.tvOption.text = answer.option
      itemAnswerBinding.tvAnswer.text = answer.answer

      // pada saat jawaban di klik
      if (answer.isClick!!){
        // menjalankan fungsi activeCheckAnswer
        activeCheckAnswer()
      }else{
        // menjalankan fungsi inActiveCheckAnswer
        inActiveCheckAnswer()
      }

      // merubah tampilan pada view ketika jawaban quiz dipilih
      // ketika dipilih akan menjadi true
      itemView.setOnClickListener {
        for (i in 0 until answers.size){
          answers[i].isClick = i == adapterPosition
        }
        notifyDataSetChanged()
      }
    }

    // menampilkan image tanpa check
    private fun inActiveCheckAnswer() {
      itemAnswerBinding.ivCheckAnswer.setImageResource(R.drawable.ic_baseline_panorama_fish_eye_24)
    }

    // menampilkan image dengan check
    private fun activeCheckAnswer() {
      itemAnswerBinding.ivCheckAnswer.setImageResource(R.drawable.ic_baseline_check_circle_24)
    }

  }

  // mengembalikan data binding
  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    val binding = ItemAnswerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    return ViewHolder(binding)
  }

  // memecah data ke dalam bentuk objek
  override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    holder.bindItem(answers[position])
  }

  override fun getItemCount(): Int = answers.size

  // menginformasikan bila terjadi perubahan data
  fun setData(answers: MutableList<Answer>){
    this.answers = answers
    notifyDataSetChanged()
  }
}