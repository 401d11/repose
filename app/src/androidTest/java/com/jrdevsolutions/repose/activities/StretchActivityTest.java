package com.jrdevsolutions.repose.activities;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.ViewInteraction;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import com.jrdevsolutions.repose.R;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class StretchActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void stretchActivityTest() {
        ViewInteraction appCompatEditText = onView(
                allOf(withId(R.id.loginEmailEditText),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                1),
                        isDisplayed()));
        appCompatEditText.perform(replaceText("reposeappuser@gmail.com"), closeSoftKeyboard());

        ViewInteraction appCompatEditText2 = onView(
                allOf(withId(R.id.loginPasswordEditText),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                4),
                        isDisplayed()));
        appCompatEditText2.perform(replaceText("password"), closeSoftKeyboard());

        ViewInteraction materialButton = onView(
                allOf(withId(R.id.loginButton), withText("Login"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                2),
                        isDisplayed()));
        materialButton.perform(click());

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction materialButton2 = onView(
                allOf(withId(R.id.homeRoutinesButton), withText("Routines"),
                        childAtPosition(
                                allOf(withId(R.id.mainActivityConstraintLayout),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                2),
                        isDisplayed()));
        materialButton2.perform(click());

        ViewInteraction materialButton3 = onView(
                allOf(withId(R.id.currentRoutineFragmentButton), withText("Neck"),
                        childAtPosition(
                                allOf(withId(R.id.routineFragmentConstaintLayout),
                                        childAtPosition(
                                                withId(R.id.routinesRecyclerView),
                                                0)),
                                0),
                        isDisplayed()));
        materialButton3.perform(click());

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction button = onView(
                allOf(withId(R.id.currentRoutineFragmentButton), withText("NECK"),
                        withParent(allOf(withId(R.id.routineFragmentConstaintLayout),
                                withParent(withId(R.id.routinesRecyclerView)))),
                        isDisplayed()));
        button.check(matches(isDisplayed()));

        ViewInteraction textView = onView(
                allOf(withId(R.id.currentStretchFragmentTextView), withText("Neck Extension / Flexion"),
                        withParent(allOf(withId(R.id.fragmentConstaintLayout),
                                withParent(withId(R.id.stretchesRecyclerView)))),
                        isDisplayed()));
        textView.check(matches(withText("Neck Extension / Flexion")));

        ViewInteraction button2 = onView(
                allOf(withId(R.id.startRoutine), withText("START"),
                        withParent(withParent(withId(android.R.id.content))),
                        isDisplayed()));
        button2.check(matches(isDisplayed()));

        ViewInteraction button3 = onView(
                allOf(withId(R.id.routineActivityBackButton), withText("BACK"),
                        withParent(withParent(withId(android.R.id.content))),
                        isDisplayed()));
        button3.check(matches(isDisplayed()));

        ViewInteraction materialButton4 = onView(
                allOf(withId(R.id.startRoutine), withText("Start"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                2),
                        isDisplayed()));
        materialButton4.perform(click());

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction textView2 = onView(
                allOf(withId(R.id.stretchNameTextView), withText("Neck Extension / Flexion"),
                        withParent(withParent(withId(android.R.id.content))),
                        isDisplayed()));
        textView2.check(matches(withText("Neck Extension / Flexion")));

        ViewInteraction button4 = onView(
                allOf(withId(R.id.timerButton), withText("START"),
                        withParent(withParent(withId(android.R.id.content))),
                        isDisplayed()));
        button4.check(matches(isDisplayed()));

        ViewInteraction materialButton5 = onView(
                allOf(withId(R.id.timerButton), withText("Start"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                5),
                        isDisplayed()));
        materialButton5.perform(click());

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction materialButton6 = onView(
                allOf(withId(R.id.skipButton), withText("Skip"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                10),
                        isDisplayed()));
        materialButton6.perform(click());

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction materialButton7 = onView(
                allOf(withId(R.id.skipButton), withText("Skip"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                10),
                        isDisplayed()));
        materialButton7.perform(click());

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction textView3 = onView(
                allOf(withId(R.id.finishedTitletextView), withText("Good Job!"),
                        withParent(withParent(withId(android.R.id.content))),
                        isDisplayed()));
        textView3.check(matches(withText("Good Job!")));

        ViewInteraction button5 = onView(
                allOf(withId(R.id.finishedRestartButton), withText("RESTART"),
                        withParent(withParent(withId(android.R.id.content))),
                        isDisplayed()));
        button5.check(matches(isDisplayed()));

        ViewInteraction materialButton8 = onView(
                allOf(withId(R.id.finishedRestartButton), withText("Restart"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                1),
                        isDisplayed()));
        materialButton8.perform(click());

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction textView4 = onView(
                allOf(withId(R.id.routineCategoryTextView), withText("Category"),
                        withParent(withParent(withId(android.R.id.content))),
                        isDisplayed()));
        textView4.check(matches(withText("Category")));

        ViewInteraction textView5 = onView(
                allOf(withId(R.id.routineStretchTextView), withText("Stretch"),
                        withParent(withParent(withId(android.R.id.content))),
                        isDisplayed()));
        textView5.check(matches(withText("Stretch")));
    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
