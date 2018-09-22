package xyz.adhithyan.resume

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.widget.TextView
import com.mikepenz.materialdrawer.DrawerBuilder
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper
import uk.co.chrisjenx.calligraphy.CalligraphyTypefaceSpan
import uk.co.chrisjenx.calligraphy.TypefaceUtils

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        DrawerBuilder().withActivity(this).build()
        changeActionBarFont()
    }

    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase))
    }

    fun changeActionBarFont() {
        val title = SpannableStringBuilder()
        title.append(getTitle())
        val typefaceSpan = CalligraphyTypefaceSpan(TypefaceUtils.load(assets, "fonts/SF-UI-Text-Bold.otf"))
        title.setSpan(typefaceSpan, 0, getTitle().length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        supportActionBar!!.title = title
    }
}
