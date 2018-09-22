package xyz.adhithyan.resume

import android.app.Application
import uk.co.chrisjenx.calligraphy.CalligraphyConfig


class App: Application() {

    override fun onCreate() {
        super.onCreate()

        val font = CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/SF-UI-Display-Regular.otf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        CalligraphyConfig.initDefault(font)
    }
}