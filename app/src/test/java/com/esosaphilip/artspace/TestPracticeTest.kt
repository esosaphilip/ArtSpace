package com.esosaphilip.artspace

import com.esosaphilip.artspace.ui.theme.TestPractice
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertTrue
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test




internal class TestPracticeTest{

    @Test
    fun testPalin(){

        val text = "Practice"
        val res = TestPractice.palindromeChecker(text)
        val man = text.reversed()
        assertEquals(res,man)

    }
}