package com.mstudio.listapp

import android.app.Application
import com.mstudio.listapp.data.db.ReportDatabase
import com.mstudio.listapp.data.repositories.ReportRepository
import com.mstudio.listapp.ui.shoppinglist.ReportViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class ReportAplication: Application(), KodeinAware {

    override val kodein: Kodein = Kodein.lazy {
        import(androidXModule(this@ReportAplication))
        bind() from singleton { ReportDatabase(instance()) }
        bind() from singleton { ReportRepository(instance()) }
        bind() from provider {
            ReportViewModelFactory(instance())
        }

    }
}