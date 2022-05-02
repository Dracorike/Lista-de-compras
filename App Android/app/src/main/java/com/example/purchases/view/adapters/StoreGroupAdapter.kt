package com.example.purchases.view.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.purchases.R
import com.example.purchases.databinding.ItemStoreGroupBinding
import com.example.purchases.model.Store
import com.example.purchases.util.ClickCard

class StoreGroupAdapter(private val groupStores: List<Store>, val context: Context, val clickCard: ClickCard) :
    RecyclerView.Adapter<StoreGroupAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_store_group, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.buildView(groupStores[position])
    }

    override fun getItemCount(): Int = groupStores.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemStoreGroupBinding.bind(itemView)

        fun buildView(store: Store) {
            binding.iconviewStore.setImageDrawable(context.getDrawable(store.icon))
            binding.titleStore.text = store.title
            itemView.setOnClickListener{
                clickCard.switchFragment()
            }
        }
    }
}