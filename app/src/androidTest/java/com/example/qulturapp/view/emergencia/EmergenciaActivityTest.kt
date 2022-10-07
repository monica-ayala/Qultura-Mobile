package com.example.qulturapp.view.emergencia

import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.doubleClick
import androidx.test.espresso.assertion.LayoutAssertions.noOverlaps
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.activityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.example.qulturapp.R
import org.hamcrest.CoreMatchers.instanceOf
import org.hamcrest.core.Is.`is`
import org.hamcrest.core.IsAnything.anything
import org.junit.Rule
import org.junit.Test
import org.junit.matchers.JUnitMatchers.containsString
import org.junit.runner.RunWith
import java.util.EnumSet.allOf


@RunWith(AndroidJUnit4ClassRunner::class)
class EmergenciaActivityTest{

    // this variable will global for all fun
    @get: Rule var activityScenarioRule = activityScenarioRule<EmergenciaActivity>()

    @Test
    fun checkActivityVisibility(){

        onView(withId(R.id.layout_emergenciaActivity))
            .check(matches(isDisplayed()))
    }

    @Test
    fun checkSpinner(){
        onView(withId(R.id.dropdown_menu))
            .perform(click())
        onData(anything()).atPosition(1).perform(click());
        onView(withId(R.id.dropdown_menu)).check(matches(withText(("Museo de Arte de Queretaro"))))
    }

    @Test
    fun checkOneClick(){
        onView(withId(R.id.panic_btn))
            .perform(click())
            .check(noOverlaps())
    }

    @Test
    fun checkDoubleClick(){
        onView(withId(R.id.panic_btn))
            .perform(doubleClick())
            .check(noOverlaps())
    }



}
