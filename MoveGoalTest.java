package GoalieTests.auth.GoalTest;

import android.support.test.espresso.NoMatchingViewException;
import android.support.test.espresso.UiController;
import android.support.test.espresso.ViewAction;
import android.support.test.espresso.action.GeneralLocation;
import android.support.test.espresso.action.GeneralSwipeAction;
import android.support.test.espresso.action.Press;
import android.support.test.espresso.action.Swipe;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;
import android.widget.NumberPicker;
import android.widget.TimePicker;

import org.hamcrest.Matcher;
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
import static android.support.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isRoot;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by Sense-02 on 21-Jul-16.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class MoveGoalTest {

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

    public static ViewAction selectCurrentNumber(final int number) {
        return new ViewAction() {
            @Override
            public void perform(UiController uiController, View view) {
                NumberPicker numberPicker = (NumberPicker) view;
                numberPicker.setValue(number);
                }

            @Override
            public String getDescription() {
                return "Set the passed value into the NumberPicker";
            }

            @Override
            public Matcher<View> getConstraints() {
                return isAssignableFrom(NumberPicker.class);
            }
        };
    }






    public static ViewAction setTime1(final int hour1, final int minute1) {
        return new ViewAction() {
            @Override
            public void perform(UiController uiController, View view) {
                TimePicker tp = (TimePicker) view;
                tp.setCurrentHour(hour1);
                tp.setCurrentMinute(minute1);
            }
            @Override
            public String getDescription() {
                return "Set the passed time into the TimePicker";
            }
            @Override
            public Matcher<View> getConstraints() {
                return ViewMatchers.isAssignableFrom(TimePicker.class);
            }
        };
    }



    @Test
    public void movetest() throws Exception {
        TestHelpers.getCurrentActivityScreenshot(activityRule, "OnStart");
        onView(isRoot()).perform(TestHelpers.waitFor(2000));
        //press hamburger buttton
        onView(withId(R.id.menu_navigation)).perform(click());
        onView(isRoot()).perform(TestHelpers.waitFor(2000));
        //press configure goal
        onView(withText("Configure Goals")).perform(click());
        onView(isRoot()).perform(TestHelpers.waitFor(2000));
        //press Move menu
        onView(withText("Move")).perform(click());
        onView(isRoot()).perform(TestHelpers.waitFor(2000));
        //set switch
        try {
            onView(withText("Not active")).check(matches(isDisplayed()));
            //view is displayed logic
            onView(withId(R.id.switchGoal)).perform(click());
            onView(isRoot()).perform(TestHelpers.waitFor(2000));
        } catch (NoMatchingViewException e) {
            //view not displayed logic
            onView(isRoot()).perform(TestHelpers.waitFor(2000));
        }

        onView(isRoot()).perform(TestHelpers.waitFor(2000));



        // set value 30
        onView(withText("Daily activity goal")).perform(click());
        onView(isRoot()).perform(TestHelpers.waitFor(2000));
        onView(withId(R.id.picker_target)).perform(selectCurrentNumber(1));
        onView(isRoot()).perform(TestHelpers.waitFor(2000));
        onView(withId(R.id.picker_target)).perform(CostumSwipe());
        onView(isRoot()).perform(TestHelpers.waitFor(2000));
        onView(withText("Save")).perform(click());
        onView(isRoot()).perform(TestHelpers.waitFor(2000));

        //set value 60
        onView(withText("Daily activity goal")).perform(click());
        onView(isRoot()).perform(TestHelpers.waitFor(2000));
        onView(withId(R.id.picker_target)).perform(selectCurrentNumber(2));
        onView(isRoot()).perform(TestHelpers.waitFor(2000));
        onView(withId(R.id.picker_target)).perform(CostumSwipe());
        onView(isRoot()).perform(TestHelpers.waitFor(2000));
        onView(withText("Save")).perform(click());
        onView(isRoot()).perform(TestHelpers.waitFor(2000));
        //set value 90
        onView(withText("Daily activity goal")).perform(click());
        onView(isRoot()).perform(TestHelpers.waitFor(2000));
        onView(withId(R.id.picker_target)).perform(selectCurrentNumber(3));
        onView(isRoot()).perform(TestHelpers.waitFor(2000));
        onView(withId(R.id.picker_target)).perform(CostumSwipe());
        onView(isRoot()).perform(TestHelpers.waitFor(2000));
        onView(withText("Save")).perform(click());
        onView(isRoot()).perform(TestHelpers.waitFor(2000));
        //set value 120
        onView(withText("Daily activity goal")).perform(click());
        onView(isRoot()).perform(TestHelpers.waitFor(2000));
        onView(withId(R.id.picker_target)).perform(selectCurrentNumber(0));
        onView(isRoot()).perform(TestHelpers.waitFor(2000));
        onView(withId(R.id.picker_target)).perform(CostumSwipe());
        onView(isRoot()).perform(TestHelpers.waitFor(2000));
        onView(withText("Save")).perform(click());
        onView(isRoot()).perform(TestHelpers.waitFor(2000));


        onView(isRoot()).perform(TestHelpers.waitFor(2000));
        pressBack();
        onView(isRoot()).perform(TestHelpers.waitFor(2000));
        pressBack();
        onView(isRoot()).perform(TestHelpers.waitFor(2000));
        }
    @Test
    public void movetest1() throws Exception {
        TestHelpers.getCurrentActivityScreenshot(activityRule, "OnStart");
        onView(isRoot()).perform(TestHelpers.waitFor(2000));

        //press Move menu
        onView(withText("MOVE")).perform(click());
        onView(isRoot()).perform(TestHelpers.waitFor(2000));


        onView(withText("ACTIVITY TODAY")).perform(click());
        onView(isRoot()).perform(TestHelpers.waitFor(2000));

        onView(isAssignableFrom(TimePicker.class)).perform(setTime1(12, 36));

        onView(isRoot()).perform(TestHelpers.waitFor(2000));

        onView(withText("Confirm")).perform(click());

        onView(isRoot()).perform(TestHelpers.waitFor(2000));
        pressBack();


    }

}