package com.service.buscostcounter.utils

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager

class SystemCommandUtils {

    companion object {
        fun hideSoftKeyBoard(context: Context?, view: View) {
            try {
                val imm = context!!.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(view.windowToken, InputMethodManager.HIDE_NOT_ALWAYS)
            } catch (e: Exception) {
                e.printStackTrace()
            }

        }
    }

}