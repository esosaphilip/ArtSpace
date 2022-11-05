package com.esosaphilip.artspace

import androidx.annotation.VisibleForTesting



object TestPractice {

    @VisibleForTesting
    fun palindromeChecker(text: String): String{
        return text.reversed()
    }
}