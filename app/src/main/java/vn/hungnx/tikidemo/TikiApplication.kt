package vn.hungnx.tikidemo

import android.app.Application
import androidx.multidex.MultiDex
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import vn.hungnx.tikidemo.di.appModules

class TikiApplication : Application() {

    companion object{
        lateinit var INSTANCE : TikiApplication

        fun getStringWithId(idRes: Int) : String{
            return INSTANCE.resources.getString(idRes)
        }
    }

    override fun onCreate() {
        super.onCreate()
        MultiDex.install(this)
        INSTANCE = this
        startKoin {
            androidContext(this@TikiApplication)
            modules(appModules)
        }
    }
}