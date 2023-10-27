package com.driuft.randompets


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


class PetAdapter(private val petList: MutableList<String>) :
    RecyclerView.Adapter<PetAdapter.ViewHolder>() {


    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val petImage: ImageView
        var toast: Toast? = null


        init {
            petImage = view.findViewById(R.id.pet_image)
        }
    }


    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.pet_item, viewGroup, false)


        return ViewHolder(view)


    }


    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        Glide.with(viewHolder.itemView)
            .load(petList[position])
            .placeholder(R.drawable.paw_placeholder)
            .centerCrop()
            .into(viewHolder.petImage)


        viewHolder.petImage.setOnClickListener {
            if (viewHolder.toast != null) { viewHolder.toast?.cancel() }
            viewHolder.toast = Toast.makeText(viewHolder.itemView.context, "Doggo at position $position clicked", Toast.LENGTH_SHORT)
            viewHolder.toast?.show()
        }
    }
    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = petList.size




}
