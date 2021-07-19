package com.example.androidpaginglibrary_30_example.ui

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.androidpaginglibrary_30_example.R
import com.example.androidpaginglibrary_30_example.network.model.Passanger
import com.example.androidpaginglibrary_30_example.utils.loadImage
import kotlinx.android.synthetic.main.item_pessanger.view.*
import javax.inject.Inject

class PassangerAdapter @Inject constructor():
    PagingDataAdapter<Passanger, PassangerAdapter.PassangerViewHolder>(
    PassangerComparator) {

    class PassangerViewHolder(view: View): RecyclerView.ViewHolder(view) {
   }

    override fun onBindViewHolder(holder: PassangerAdapter.PassangerViewHolder, position: Int) {
         val imageViewLogo = holder.itemView.image_view_airlines_logo
         val txtViewHeadQuarter = holder.itemView.text_view_headquarters
         val txtViewNameWithTrips = holder.itemView.text_view_name_with_trips

        //imageViewLogo.loadImage(getItem(position)?.airline?.get(0).logo)
       // txtViewHeadQuarter.text = getItem(position)?.airline?.get(0)?.country
        txtViewNameWithTrips.text = "${getItem(position)?.name}, ${getItem(position)?.trips} Trips"
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ):PassangerViewHolder {
        Log.e("onCreateViewHolder ", "called")
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_pessanger, parent, false)
        return PassangerViewHolder(view)
    }

    object PassangerComparator: DiffUtil.ItemCallback<Passanger>() {
        override fun areItemsTheSame(oldItem: Passanger, newItem: Passanger): Boolean {
            return oldItem._id == newItem._id
        }

        override fun areContentsTheSame(oldItem: Passanger, newItem: Passanger): Boolean {
            return oldItem == newItem
        }
    }
}
