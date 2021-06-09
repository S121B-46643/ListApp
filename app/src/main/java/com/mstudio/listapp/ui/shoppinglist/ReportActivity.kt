package com.mstudio.listapp.ui.shoppinglist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.mstudio.listapp.R
import com.mstudio.listapp.data.db.entities.ReportItem
import com.mstudio.listapp.other.ReportItemAtapter
import kotlinx.android.synthetic.main.activity_report.*
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

class ReportActivity : AppCompatActivity(), KodeinAware {

    override val kodein by kodein()
    private val factory: ReportViewModelFactory by instance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_report)

        val viewModel = ViewModelProviders.of(this, factory).get(ReportViewModel::class.java)

        val adapter = ReportItemAtapter(listOf(), viewModel)

        rvShoppingItems.layoutManager = LinearLayoutManager(this)
        rvShoppingItems.adapter = adapter

        viewModel.getAllShoppingItems().observe(this, Observer{
            adapter.items = it
            adapter.notifyDataSetChanged()
        })

        fab.setOnClickListener {
            AddReportItemDialog(context = this, object : AddDialogListener{
                override fun onAddButtonCLicked(item: ReportItem) {
                    viewModel.upsert(item)
                }
            }).show()
        }
    }
}