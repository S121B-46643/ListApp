package com.mstudio.listapp.other


import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mstudio.listapp.R
import com.mstudio.listapp.data.db.entities.ReportItem
import com.mstudio.listapp.ui.shoppinglist.ReportViewModel
import kotlinx.android.synthetic.main.report_item.view.*

class ReportItemAtapter(
        var items: List<ReportItem>,
        private val viewModel: ReportViewModel
): RecyclerView.Adapter<ReportItemAtapter.ReportViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReportViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.report_item, parent, false)
        return ReportViewHolder(view)
    }


    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ReportViewHolder, position: Int) {
        val curShoppingItem = items[position]


        holder.itemView.tvName.text = curShoppingItem.name
        holder.itemView.tvAmount.text = "Code of type: "+curShoppingItem.CodeType.toInt()

        holder.itemView.ivDelete.setOnClickListener {
            viewModel.delete(curShoppingItem)
        }

        holder.itemView.ivDelete.setOnClickListener {
            curShoppingItem.CodeType++
            viewModel.upsert(curShoppingItem)
        }

        holder.itemView.ivDelete.setOnClickListener{
            if(curShoppingItem.CodeType > 0){
            curShoppingItem.CodeType--
            viewModel.upsert(curShoppingItem)
            }


    }
}
override fun getItemCount(): Int {
    return items.size
}

inner class ReportViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
}