package GoalieTests.auth.GoalTest;

import android.support.test.espresso.NoMatchingViewException;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import GoalieTests.TestHelpers;
import nl.sense_os.goalie.BaseActivity;
import nl.sense_os.goalie.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isRoot;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by Sense-02 on 21-Jul-16.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class SleepGoalTest {

    @Rule
    public ActivityTestRule<BaseActivity> activityRule = new ActivityTestRule<>(
            BaseActivity.class,
            true,    // initialTouchMode
            true);   // launchActivity. False so we can customize the intent per test method
    private BaseActivity mActivity = null;

    @Before
    public void setup() {
        mActivity = activityRule.getActivity();
    }

    @Test
    public void sleeptest() {
        TestHelpers.getCurrentActivityScreenshot(activityRule, "OnStart");
        onView(isRoot()).perform(TestHelpers.waitFor(2000));
        onView(withId(R.id.menu_navigation)).perform(click());
        onView(isRoot()).perform(TestHelpers.waitFor(2000));
        onView(withText("Configure Goals")).perform(click());
        onView(isRoot()).perform(TestHelpers.waitFor(2000));
        onView(withText("Sleep")).perform(click());
        onView(isRoot()).perform(TestHelpers.waitFor(2000));
        try {
            onView(withText("Not active")).check(matches(isDisplayed()));
            //view is displayed logic
            onView(withId(R.id.switchGoal)).perform(click());
            onView(isRoot()).perform(TestHelpers.waitFor(2000));
        } catch (NoMatchingViewException e) {
            //view not displayed logic
            onView(isRoot()).perform(TestHelpers.waitFor(2000));
        }
        pressBack();
        onView(isRoot()).perform(TestHelpers.waitFor(2000));
        pressBack();
        onView(isRoot()).perform(TestHelpers.waitFor(2000));
    }
}
