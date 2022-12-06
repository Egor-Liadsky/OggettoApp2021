package com.android.oggettoapp.adapters.event

import android.util.Log
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import androidx.recyclerview.widget.RecyclerView
import com.android.oggettoapp.R
import com.android.oggettoapp.data.local.entity.EventEntity
import com.android.oggettoapp.databinding.ItemEventBinding

class EventAdapter(
    private val deleteEvent: (item: Int) -> Unit
) : RecyclerView.Adapter<EventAdapter.EventHolder>() {

    private val events = mutableListOf<EventEntity>()

    class EventHolder(
        private val binding: ItemEventBinding,
        private val deleteEvent: (item: Int) -> Unit
    ) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: EventEntity) {
            binding.title.text = item.title
            binding.description.text = item.description
            binding.telegram.text = item.telegram
            binding.date.text = item.date
            binding.createDate.text = item.createDate

            binding.itemCard.setOnLongClickListener {
                showPopup(binding.itemCard, item)
                return@setOnLongClickListener true
            }
        }

        private fun showPopup(view: View, item1: EventEntity) {
            val popup = PopupMenu(view.context, view)
            popup.inflate(R.menu.event_menu)
            popup.setOnMenuItemClickListener { item: MenuItem? ->
                when (item?.itemId) {
                    R.id.editFile -> {
//                    renameFile(item1.id)
                    }
                    R.id.deleteFile -> {
                        deleteEvent(item1.id)
                        Log.e("DELETE", "OKEY")
                    }
                }
                true
            }
            popup.show()
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventHolder {
        val inflater = ItemEventBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return EventHolder(inflater, deleteEvent)
    }

    override fun onBindViewHolder(holder: EventHolder, position: Int) {
        holder.bind(events[position])
    }

    override fun getItemCount(): Int = events.size

    fun setData(list: List<EventEntity>) {
        events.clear()
        events.addAll(list)
        notifyDataSetChanged()
    }
}