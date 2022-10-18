package com.example.qulturapp.view.sesion


import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.example.qulturapp.R
import org.hamcrest.Matchers.allOf
import org.hamcrest.core.IsInstanceOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class ActivitySignInTest {

    @Rule
    @JvmField
    var mActivityScenarioRule = ActivityScenarioRule(ActivitySignIn::class.java)

    @Test
    fun activitySignInTest() {
        val editText = onView(
            allOf(
                withId(R.id.edit_text_email), withText("Email"),
                withParent(
                    allOf(
                        withId(R.id.rl_settings),
                        withParent(IsInstanceOf.instanceOf(android.widget.RelativeLayout::class.java))
                    )
                ),
                isDisplayed()
            )
        )
        editText.check(matches(withText("mayala@gmail.com")))

        val editText2 = onView(
            allOf(
                withId(R.id.edit_text_pass), withText("Contrase�a"),
                withParent(
                    allOf(
                        withId(R.id.rl_settings),
                        withParent(IsInstanceOf.instanceOf(android.widget.RelativeLayout::class.java))
                    )
                ),
                isDisplayed()
            )
        )
        editText2.check(matches(withText("marrero1234")))

        val button = onView(
            allOf(
                withId(R.id.button_signin), withText("SIGN IN"),
                withParent(
                    allOf(
                        withId(R.id.rl_settings),
                        withParent(IsInstanceOf.instanceOf(android.widget.RelativeLayout::class.java))
                    )
                ),
                isDisplayed()
            )
        )
        button.check(matches(isDisplayed()))

        val button2 = onView(
            allOf(
                withId(R.id.button_signin), withText("SIGN IN"),
                withParent(
                    allOf(
                        withId(R.id.rl_settings),
                        withParent(IsInstanceOf.instanceOf(android.widget.RelativeLayout::class.java))
                    )
                ),
                isDisplayed()
            )
        )
        button2.check(matches(isDisplayed()))
    }
}
