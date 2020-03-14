package com.moringa.myrestaurant;


import android.view.View;

import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import ui.RestaurantsActivity;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.CoreMatchers.anything;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.core.IsNot.not;

@RunWith(AndroidJUnit4.class)
public class RestaurantsActivityInstrumentationTest {
    @Rule
    public ActivityTestRule<RestaurantsActivity> activityTestRule = new ActivityTestRule<>(RestaurantsActivity.class);
    @Test
    public void listItemClickDisplaysToastWithCorrectRestaurant(){
        View activityDecorView = activityTestRule.getActivity().getWindow().getDecorView();
        String restaurantName = "Sweet Hereafter \nServes great: Vegan Food";
        onData(anything())
                .inAdapterView(withId(R.id.listView))
                .atPosition(0)
                .perform(click());
        onView(withText(restaurantName)).inRoot(withDecorView(not(activityDecorView)))
                .check(matches(withText(restaurantName)));

    }
}
