package com.service.buscostcounter.utils

import android.content.Context
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.service.buscostcounter.R

class InputTextValidation {

    companion object {
        fun checkIsFieldNullOrEmpty(
            context: Context?,
            inputEditText: TextInputEditText,
            inputLayout: TextInputLayout
        ): Boolean {
            if (inputEditText.text?.isEmpty()!!) {
                inputLayout.isErrorEnabled = true
                if (context != null) {
                    inputLayout.error = context.getString(R.string.error_msg_empty_field)
                }
                return false
            }
            inputLayout.isErrorEnabled = false
            return true
        }
    }

}