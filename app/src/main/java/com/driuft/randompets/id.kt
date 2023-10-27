import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.driuft.randompets.R


class id(private val petidList: List<String>) :
    RecyclerView.Adapter<id.ViewHolder>() {


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val petName: TextView
        var toast: Toast? = null


        init {
            petName = view.findViewById(R.id.image_id)
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view1 = LayoutInflater.from(parent.context)
            .inflate(R.layout.imagename, parent, false)
        return ViewHolder(view1)
    }
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val pet = petidList.getOrNull(position) ?: "Unknown ID" // Fallback if the list doesn't contain data for this position
        viewHolder.petName.text = pet
        viewHolder.petName.setOnClickListener {
            if (viewHolder.toast != null) {
                viewHolder.toast?.cancel()
            }
            viewHolder.toast = Toast.makeText(viewHolder.itemView.context, "Doggo at position $position clicked", Toast.LENGTH_SHORT)
            viewHolder.toast?.show()
        }
    }


    override fun getItemCount() = petidList.size
}
