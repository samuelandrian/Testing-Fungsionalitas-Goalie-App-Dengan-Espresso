package GoalieTests.auth.GoalTest;

/**
 * Created by Sense-02 on 29-Jul-16.
 */

import android.support.test.espresso.UiController;
import android.support.test.espresso.ViewAction;
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

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static android.support.test.espresso.matcher.ViewMatchers.isRoot;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by Sense-02 on 21-Jul-16.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class TakeGoalTest {

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



    /*@Test
    public void taketest() throws Exception {
        TestHelpers.getCurrentActivityScreenshot(activityRule, "OnStart");
        onView(isRoot()).perform(TestHelpers.waitFor(2000));
        //press hamburger buttton
        onView(withId(R.id.menu_navigation)).perform(click());
        onView(isRoot()).perform(TestHelpers.waitFor(2000));
        //press configure goal
        onView(withText("Configure Goals")).perform(click());
        onView(isRoot()).perform(TestHelpers.waitFor(2000));
        //press Move menu
        onView(withText("Take")).perform(click());
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
        onView(withText("Add medication")).perform(click());
        onView(isRoot()).perform(TestHelpers.waitFor(2000));

        onView(withId(R.id.medicationName)).
                perform(clearText(), typeText("Obat Kuat"));
        onView(withId(R.id.medicationDose)).
                perform(clearText(), typeText("three times in a day"));
        onView(withId(R.id.select_day)).perform(click());

        //uncheck all days
        onView(withText("Monday")).perform(click());

        onView(withText("Tueday")).perform(click());

        onView(withText("Wednesday")).perform(click());

        onView(withText("Thursday")).perform(click());

        onView(withText("Friday")).perform(click());

        onView(withText("Saturday")).perform(click());

        onView(withText("Sunday")).perform(click());


        //check monday and friday
        onView(withText("Wednesday")).perform(click());
        onView(isRoot()).perform(TestHelpers.waitFor(2000));
        onView(withText("Thursday")).perform(click());
        onView(isRoot()).perform(TestHelpers.waitFor(2000));
        onView(withText("Friday")).perform(click());
        onView(isRoot()).perform(TestHelpers.waitFor(2000));
        pressBack();
        onView(isRoot()).perform(TestHelpers.waitFor(2000));



        onView(withId(R.id.saveMedication)).perform(click());
        onView(isRoot()).perform(TestHelpers.waitFor(2000));
        pressBack();
        onView(isRoot()).perform(TestHelpers.waitFor(2000));


    }
*/


    @Test
    public void taketest1() throws Exception {
        TestHelpers.getCurrentActivityScreenshot(activityRule, "OnStart");
        onView(isRoot()).perform(TestHelpers.waitFor(2000));
        onView(isRoot()).perform(TestHelpers.waitFor(2000));
        onView(isRoot()).perform(TestHelpers.waitFor(2000));

        //press Move menu
        onView(withText("TAKE")).perform(click());
        onView(isRoot()).perform(TestHelpers.waitFor(6000));
        onView(withText("Obat Kuat")).perform(click());
        onView(isRoot()).perform(TestHelpers.waitFor(2000));
        onView(isAssignableFrom(TimePicker.class)).perform(setTime1(12, 36));
        onView(isRoot()).perform(TestHelpers.waitFor(2000));
        onView(withText("Confirm")).perform(click());
        onView(isRoot()).perform(TestHelpers.waitFor(2000));
        pressBack();

    }

}