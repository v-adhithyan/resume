package xyz.adhithyan.resume

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableString
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.TextUtils
import android.text.style.RelativeSizeSpan
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
//import com.mikepenz.materialdrawer.DrawerBuilder
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper
import uk.co.chrisjenx.calligraphy.CalligraphyTypefaceSpan
import uk.co.chrisjenx.calligraphy.TypefaceUtils

class MainActivity : AppCompatActivity() {
    val largeSizeText = RelativeSizeSpan(3.0f)
    val mediumSizeText = RelativeSizeSpan(2.0f)
    val smallSizeText = RelativeSizeSpan(1.0f)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //DrawerBuilder().withActivity(this).build()
        changeActionBarFont()
        setExperience()
    }

    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase))
    }

    fun changeActionBarFont() {
        val title = SpannableStringBuilder()
        title.append(getTitle())
        title.setSpan(sfBold, 0, getTitle().length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        supportActionBar!!.title = title
    }

    fun setExperience() {
        val header = "Experience"
        val newline = "\n"
        val currentPostion = "Software Development Engineer"
        val h = SpannableStringBuilder(header)
        h.setSpan(largeSizeText, 0, header.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        h.setSpan(sfBold, 0, header.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        h.append(newline)

        val c = SpannableStringBuilder(currentPostion)
        c.setSpan(mediumSizeText, 0, currentPostion.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        c.setSpan(sfRegular, 0, currentPostion.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        c.append(newline)

        textViewExperience.text = TextUtils.concat(h, c)
    }

    val sfBold: CalligraphyTypefaceSpan by lazy {
        CalligraphyTypefaceSpan(TypefaceUtils.load(assets, "fonts/SF-UI-Text-Bold.otf"))
    }

    val sfRegular: CalligraphyTypefaceSpan by lazy {
        CalligraphyTypefaceSpan(TypefaceUtils.load(assets, "fonts/SF-UI-Display-Regular.otf"))
    }
}
