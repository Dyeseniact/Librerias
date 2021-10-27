package com.bedu.librerias

import android.graphics.Typeface.BOLD_ITALIC
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.StyleSpan
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bedu.librerias.databinding.ActivityToastyBinding
import com.bedu.librerias.utils.INFO_FORMATTED
import es.dmoral.toasty.Toasty
import com.bedu.librerias.utils.showToasty

class ToastyActivity : AppCompatActivity() {

    private lateinit var binding: ActivityToastyBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityToastyBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnError.setOnClickListener {
            Toasty.error(this, "This is an error toast.", Toast.LENGTH_SHORT, true).show();

        }

        binding.btnSuccess.setOnClickListener {
            Toasty.success(this, "Success!", Toast.LENGTH_SHORT, true).show();

        }

        binding.btnInfo.setOnClickListener {
            Toasty.info(this, "Here is some info for you.", Toast.LENGTH_SHORT, true).show();

        }

        binding.btnInfoFormatted.setOnClickListener {
            showToasty(this, INFO_FORMATTED, "", Toast.LENGTH_SHORT, true, null, getFormattedMessage());
        }

        binding.btnWarning.setOnClickListener {
            Toasty.warning(this, "Beware of the dog.", Toast.LENGTH_SHORT, true).show();

        }

        binding.btnNormal.setOnClickListener {
            Toasty.normal(this, "Normal toast w/o icon").show();
        }

        binding.btnNormalWithIcon.setOnClickListener {
            val icon = R.drawable.homero_;
            Toasty.normal(this, "Normal toast w/ icon", icon).show();

        }

        binding.btnCustom.setOnClickListener {
            val icon = R.drawable.homero_;
            Toasty.custom(this, "I'm a custom Toast", icon, R.color.purple_700, 20, true,
                true).show();

        }
    }
    private fun getFormattedMessage(): CharSequence? {
        val prefix = "Formatted "
        val highlight = "bold italic"
        val suffix = " text"
        val ssb = SpannableStringBuilder(prefix).append(highlight).append(suffix)
        val prefixLen = prefix.length
        ssb.setSpan(
            StyleSpan(BOLD_ITALIC),
            prefixLen, prefixLen + highlight.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        return ssb
    }

}