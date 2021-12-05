package com.example.contact.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.contact.Data.UserData
import com.example.contact.R
import de.hdodenhof.circleimageview.CircleImageView
import kotlinx.android.synthetic.main.itemview.view.*

class UserAdapter(val data:ArrayList<UserData>):RecyclerView.Adapter<UserAdapter.ViewHolder>() {
    private var listener:((Int,Int,String,String)->Unit)? = null
    data class ViewHolder(val view: View):RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.itemview,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView .apply {
            val image: CircleImageView = findViewById(R.id.Image)
            image.setImageResource(data[position].Image!!)
            data[position].Image?.let { Image.setBackgroundResource(it) }
            Name?.text = data[position].Name
            PhoneNomer?.text = data[position].Number
        }
        holder.itemView.image_next.setOnClickListener {
            listener?.invoke(position,data[position].Image!!,data[position].Name!!,data[position].Number!!)
        }

    }

    override fun getItemCount(): Int {
        return data.size
    }
    fun setOnclilcListener(f :(Int,Int,String,String)->Unit){
        listener = f
    }
}