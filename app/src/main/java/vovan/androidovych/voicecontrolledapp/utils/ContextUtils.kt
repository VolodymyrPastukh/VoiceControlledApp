package vovan.androidovych.voicecontrolledapp.utils

import android.content.Context
import android.widget.Toast
import androidx.annotation.StringRes

fun Context.toast(message: String) =
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

fun Context.toast(@StringRes stringId: Int) =
    Toast.makeText(this, getString(stringId), Toast.LENGTH_SHORT).show()
