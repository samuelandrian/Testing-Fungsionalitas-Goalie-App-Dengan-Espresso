package GoalieTests.auth.GoalTest;

import android.support.test.espresso.NoMatchingViewException;
import android.support.test.espresso.ViewAction;
import android.support.test.espresso.action.GeneralLocation;
import android.support.test.espresso.action.GeneralSwipeAction;
import android.support.test.espresso.action.Press;
import android.support.test.espresso.action.Swipe;
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

import static GoalieTests.auth.GoalTest.MoveGoalTest.selectCurrentNumber;
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
public class EatGoalTest {
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

    private static ViewAction CostumSwipe() {
        return new GeneralSwipeAction(Swipe.SLOW, GeneralLocation.TOP_CENTER,
                GeneralLocation.BOTTOM_CENTER, Press.FINGER);
    }



    @Test
    public void eattest() {
        TestHelpers.getCurrentActivityScreenshot(activityRule, "OnStart");
        onView(isRoot()).perform(TestHelpers.waitFor(2000));
        onView(withId(R.id.menu_navigation)).perform(click());
        onView(isRoot()).perform(TestHelpers.waitFor(2000));
        onView(withText("Configure Goals")).perform(click());
        onView(isRoot()).perform(TestHelpers.waitFor(2000));
        onView(withText("Eat")).perform(click());
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

        //input for breakfast
        // input 1
        onView(withText("Breakfast")).perform(click());
        onView(isRoot()).perform(TestHelpers.waitFor(2000));
        onView(withId(R.id.picker_target)).perform(selectCurrentNumber(0));
        onView(isRoot()).perform(TestHelpers.waitFor(2000));
        onView(withId(R.id.picker_target)).perform(CostumSwipe());
        onView(isRoot()).perform(TestHelpers.waitFor(2000));
        onView(withText("Save")).perform(click());
        onView(isRoot()).perform(TestHelpers.waitFor(2000));

        // input 2
        onView(withText("Breakfast")).perform(click());
        onView(isRoot()).perform(TestHelpers.waitFor(2000));
        onView(withId(R.id.picker_target)).perform(selectCurrentNumber(1));
        onView(isRoot()).perform(TestHelpers.waitFor(2000));
        onView(withId(R.id.picker_target)).perform(CostumSwipe());
        onView(isRoot()).perform(TestHelpers.waitFor(2000));
        onView(withText("Save")).perform(click());
        onView(isRoot()).perform(TestHelpers.waitFor(2000));

        // input 3
        onView(withText("Breakfast")).perform(click());
        onView(withId(R.id.picker_target)).perform(selectCurrentNumber(2));
        onView(isRoot()).perform(TestHelpers.waitFor(2000));
        onView(withId(R.id.picker_target)).perform(CostumSwipe());
        onView(isRoot()).perform(TestHelpers.waitFor(2000));
        onView(withText("Save")).perform(click());
        onView(isRoot()).perform(TestHelpers.waitFor(2000));

        // input 4
        onView(withText("Breakfast")).perform(click());
        onView(withId(R.id.picker_target)).perform(selectCurrentNumber(3));
        onView(isRoot()).perform(TestHelpers.waitFor(2000));
        onView(withId(R.id.picker_target)).perform(CostumSwipe());
        onView(isRoot()).perform(TestHelpers.waitFor(2000));
        onView(withText("Save")).perform(click());
        onView(isRoot()).perform(TestHelpers.waitFor(2000));

        // input 5
        onView(withText("Breakfast")).perform(click());
        onView(withId(R.id.picker_target)).perform(selectCurrentNumber(4));
        onView(isRoot()).perform(TestHelpers.waitFor(2000));
        onView(withId(R.id.picker_target)).perform(CostumSwipe());
        onView(isRoot()).perform(TestHelpers.waitFor(2000));
        onView(withText("Save")).perform(click());
        onView(isRoot()).perform(TestHelpers.waitFor(2000));

        // input 6
        onView(withText("Breakfast")).perform(click());
        onView(withId(R.id.picker_target)).perform(selectCurrentNumber(5));
        onView(isRoot()).perform(TestHelpers.waitFor(2000));
        onView(withId(R.id.picker_target)).perform(CostumSwipe());
        onView(isRoot()).perform(TestHelpers.waitFor(2000));
        onView(withText("Save")).perform(click());
        onView(isRoot()).perform(TestHelpers.waitFor(2000));

        // input 7
        onView(withText("Breakfast")).perform(click());
        onView(withId(R.id.picker_target)).perform(selectCurrentNumber(6));
        onView(isRoot()).perform(TestHelpers.waitFor(2000));
        onView(withId(R.id.picker_target)).perform(CostumSwipe());
        onView(isRoot()).perform(TestHelpers.waitFor(2000));
        onView(withText("Save")).perform(click());
        onView(isRoot()).perform(TestHelpers.waitFor(2000));



        //input for Lunch
        // input 1
        onView(withText("Lunch")).perform(click());
        onView(withId(R.id.picker_target)).perform(selectCurrentNumber(0));
        onView(isRoot()).perform(TestHelpers.waitFor(2000));
        onView(withId(R.id.picker_target)).perform(CostumSwipe());
        onView(isRoot()).perform(TestHelpers.waitFor(2000));
        onView(withText("Save")).perform(click());
        onView(isRoot()).perform(TestHelpers.waitFor(2000));

        // input 2
        onView(withText("Lunch")).perform(click());
        onView(withId(R.id.picker_target)).perform(selectCurrentNumber(1));
        onView(isRoot()).perform(TestHelpers.waitFor(2000));
        onView(withId(R.id.picker_target)).perform(CostumSwipe());
        onView(isRoot()).perform(TestHelpers.waitFor(2000));
        onView(withText("Save")).perform(click());
        onView(isRoot()).perform(TestHelpers.waitFor(2000));

        // input 3
        onView(withText("Lunch")).perform(click());
        onView(withId(R.id.picker_target)).perform(selectCurrentNumber(2));
        onView(isRoot()).perform(TestHelpers.waitFor(2000));
        onView(withId(R.id.picker_target)).perform(CostumSwipe());
        onView(isRoot()).perform(TestHelpers.waitFor(2000));
        onView(withText("Save")).perform(click());
        onView(isRoot()).perform(TestHelpers.waitFor(2000));


        // input 4
        onView(withText("Lunch")).perform(click());
        onView(withId(R.id.picker_target)).perform(selectCurrentNumber(3));
        onView(isRoot()).perform(TestHelpers.waitFor(2000));
        onView(withId(R.id.picker_target)).perform(CostumSwipe());
        onView(isRoot()).perform(TestHelpers.waitFor(2000));
        onView(withText("Save")).perform(click());
        onView(isRoot()).perform(TestHelpers.waitFor(2000));

        // input 5
        onView(withText("Lunch")).perform(click());
        onView(withId(R.id.picker_target)).perform(selectCurrentNumber(4));
        onView(isRoot()).perform(TestHelpers.waitFor(2000));
        onView(withId(R.id.picker_target)).perform(CostumSwipe());
        onView(isRoot()).perform(TestHelpers.waitFor(2000));
        onView(withText("Save")).perform(click());
        onView(isRoot()).perform(TestHelpers.waitFor(2000));


        // input 6
        onView(withText("Lunch")).perform(click());
        onView(withId(R.id.picker_target)).perform(selectCurrentNumber(5));
        onView(isRoot()).perform(TestHelpers.waitFor(2000));
        onView(withId(R.id.picker_target)).perform(CostumSwipe());
        onView(isRoot()).perform(TestHelpers.waitFor(2000));
        onView(withText("Save")).perform(click());
        onView(isRoot()).perform(TestHelpers.waitFor(2000));

        // input 7
        onView(withText("Lunch")).perform(click());
        onView(withId(R.id.picker_target)).perform(selectCurrentNumber(6));
        onView(isRoot()).perform(TestHelpers.waitFor(2000));
        onView(withId(R.id.picker_target)).perform(CostumSwipe());
        onView(isRoot()).perform(TestHelpers.waitFor(2000));
        onView(withText("Save")).perform(click());
        onView(isRoot()).perform(TestHelpers.waitFor(2000));



        //input for dinner
        // input 1
        onView(withText("Dinner")).perform(click());
        onView(withId(R.id.picker_target)).perform(selectCurrentNumber(0));
        onView(isRoot()).perform(TestHelpers.waitFor(2000));
        onView(withId(R.id.picker_target)).perform(CostumSwipe());
        onView(isRoot()).perform(TestHelpers.waitFor(2000));
        onView(withText("Save")).perform(click());
        onView(isRoot()).perform(TestHelpers.waitFor(2000));

        // input 2
        onView(withText("Dinner")).perform(click());
        onView(withId(R.id.picker_target)).perform(selectCurrentNumber(1));
        onView(isRoot()).perform(TestHelpers.waitFor(2000));
        onView(withId(R.id.picker_target)).perform(CostumSwipe());
        onView(isRoot()).perform(TestHelpers.waitFor(2000));
        onView(withText("Save")).perform(click());
        onView(isRoot()).perform(TestHelpers.waitFor(2000));

        // input 3
        onView(withText("Dinner")).perform(click());
        onView(withId(R.id.picker_target)).perform(selectCurrentNumber(2));
        onView(isRoot()).perform(TestHelpers.waitFor(2000));
        onView(withId(R.id.picker_target)).perform(CostumSwipe());
        onView(isRoot()).perform(TestHelpers.waitFor(2000));
        onView(withText("Save")).perform(click());
        onView(isRoot()).perform(TestHelpers.waitFor(2000));

        // input 4
        onView(withText("Dinner")).perform(click());
        onView(withId(R.id.picker_target)).perform(selectCurrentNumber(3));
        onView(isRoot()).perform(TestHelpers.waitFor(2000));
        onView(withId(R.id.picker_target)).perform(CostumSwipe());
        onView(isRoot()).perform(TestHelpers.waitFor(2000));
        onView(withText("Save")).perform(click());
        onView(isRoot()).perform(TestHelpers.waitFor(2000));

        // input 5
        onView(withText("Dinner")).perform(click());
        onView(withId(R.id.picker_target)).perform(selectCurrentNumber(4));
        onView(isRoot()).perform(TestHelpers.waitFor(2000));
        onView(withId(R.id.picker_target)).perform(CostumSwipe());
        onView(isRoot()).perform(TestHelpers.waitFor(2000));
        onView(withText("Save")).perform(click());
        onView(isRoot()).perform(TestHelpers.waitFor(2000));

        //input 6
        onView(withText("Dinner")).perform(click());
        onView(withId(R.id.picker_target)).perform(selectCurrentNumber(5));
        onView(isRoot()).perform(TestHelpers.waitFor(2000));
        onView(withId(R.id.picker_target)).perform(CostumSwipe());
        onView(isRoot()).perform(TestHelpers.waitFor(2000));
        onView(withText("Save")).perform(click());
        onView(isRoot()).perform(TestHelpers.waitFor(2000));


        //input 7
        onView(withText("Dinner")).perform(click());
        onView(withId(R.id.picker_target)).perform(selectCurrentNumber(6));
        onView(isRoot()).perform(TestHelpers.waitFor(2000));
        onView(withId(R.id.picker_target)).perform(CostumSwipe());
        onView(isRoot()).perform(TestHelpers.waitFor(2000));
        onView(withText("Save")).perform(click());
        onView(isRoot()).perform(TestHelpers.waitFor(2000));







        pressBack();
        onView(isRoot()).perform(TestHelpers.waitFor(2000));

        pressBack();
        onView(isRoot()).perform(TestHelpers.waitFor(2000));


    }
}