package com.demo.aboutcanada.widget

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import com.demo.aboutcanada.R
import com.demo.aboutcanada.utils.FontType
import com.demo.aboutcanada.utils.getTypeface
import com.demo.aboutcanada.utils.FontType.Companion as FontType1

class CustomTextView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : AppCompatTextView(context, attrs, defStyleAttr) {

    init {
        if (attrs != null) {
            @SuppressLint("CustomViewStyleable")
            val typedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomFont)
            val textStyle = typedArray.getInt(R.styleable.CustomFont_textFont, 0)
            withCustomFont(context, FontType1.from(textStyle))
            typedArray.recycle()
        }
    }

    private fun withCustomFont(context: Context, textFont: FontType) {
        typeface = when (textFont) {
            FontType.ROBOTO_LIGHT -> getTypeface(
                context.getString(R.string.roboto_light),
                R.font.roboto_light,
                context
            )
            FontType.ROBOTO_REGULAR -> getTypeface(
                context.getString(R.string.roboto_regular),
                R.font.roboto_regular,
                context
            )
            FontType.ROBOTO_MEDIUM -> getTypeface(
                context.getString(R.string.roboto_medium),
                R.font.roboto_medium,
                context
            )
            FontType.ROBOTO_BOLD -> getTypeface(
                context.getString(R.string.roboto_bold),
                R.font.roboto_bold,
                context
            )
        }
    }
}