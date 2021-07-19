package com.example.androidpaginglibrary_30_example.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.androidpaginglibrary_30_example.R
import kotlinx.android.synthetic.main.load_state_layout.view.*

class PassangerLoadStateAdapter(private val retry:()-> Unit):
    LoadStateAdapter<PassangerLoadStateAdapter.PassamgerLoadStateViewHolder>() {

    inner class PassamgerLoadStateViewHolder(view: View): RecyclerView.ViewHolder(view) {
    }

    override fun onBindViewHolder(
        holder: PassangerLoadStateAdapter.PassamgerLoadStateViewHolder,
        loadState: LoadState
    ) {
        if(loadState is LoadState.Error) {
            holder.itemView.text_view_error.setText("Please try again..")
        }

        if (loadState is LoadState.Loading) {
            holder.itemView.progressbar.visibility = View.VISIBLE
        }
        if (loadState is LoadState.Error) {
            holder.itemView.button_retry.visibility = View.VISIBLE
            holder.itemView.text_view_error.visibility = View.VISIBLE
        }

        holder.itemView.button_retry.setOnClickListener {
            retry()
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        loadState: LoadState
    ): PassangerLoadStateAdapter.PassamgerLoadStateViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.load_state_layout, parent, false)
        return PassamgerLoadStateViewHolder(view)
    }
}