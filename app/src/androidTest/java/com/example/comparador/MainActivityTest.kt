package com.example.comparador

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.comparador.app.view.MainActivity
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class MainActivityTest{

    @get: Rule
    var rule : ActivityScenarioRule<*> = ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun setup(){
    }

    @After
    fun tearDown(){
    }

    @Test
    fun mainActivity_compare(){
        Espresso.onView(
            ViewMatchers.withId(R.id.button)
        ).perform(
            ViewActions.click()
        )
        Espresso.onView(
            ViewMatchers.withId(R.id.response_text)
        ).check(
            ViewAssertions.matches(
                ViewMatchers.withText(R.string.response_text_true)
            )
        )
    }
}