package com.example.qulturapp.view


import android.view.View
import android.view.ViewGroup
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.closeSoftKeyboard
import androidx.test.espresso.action.ViewActions.replaceText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.example.qulturapp.R
import com.example.qulturapp.view.sesion.ActivitySignIn
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.*
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class SignInEmailTest {

    @Rule
    @JvmField
    var mActivityScenarioRule = ActivityScenarioRule(ActivitySignIn::class.java)

    @Test
    fun signInEmailTest() {
        val appCompatEditText = onView(
            allOf(
                withId(R.id.edit_text_email),
                childAtPosition(
                    allOf(
                        withId(R.id.rl_settings),
                        childAtPosition(
                            withClassName(`is`("android.widget.RelativeLayout")),
                            1
                        )
                    ),
                    2
                ),
                isDisplayed()
            )
        )
        appCompatEditText.perform(replaceText("UsuarioEjemplo@gmail.com"), closeSoftKeyboard())

        onView(withId(R.id.edit_text_email))
            .perform(replaceText("UsuarioEjemplo@gmail.com"))
            .check(matches(not(withText(""))))

    }

    private fun childAtPosition(
        parentMatcher: Matcher<View>, position: Int
    ): Matcher<View> {

        return object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description) {
                description.appendText("Child at position $position in parent ")
                parentMatcher.describeTo(description)
            }

            public override fun matchesSafely(view: View): Boolean {
                val parent = view.parent
                return parent is ViewGroup && parentMatcher.matches(parent)
                        && view == parent.getChildAt(position)
            }
        }
    }
}
