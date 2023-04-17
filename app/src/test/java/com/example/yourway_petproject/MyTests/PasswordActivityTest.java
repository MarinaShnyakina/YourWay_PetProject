package com.example.yourway_petproject.MyTests;


import static org.junit.Assert.assertNotNull;

import com.example.yourway_petproject.MainActivity;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;


@RunWith(RobolectricTestRunner.class)
public class PasswordActivityTest {
    private MainActivity activityTest;

    @Before
    public void setActivity() {
        activityTest = Robolectric.buildActivity(MainActivity.class)
                .create()
                .resume()
                .get();
    }

    @Test
    public void activityShouldNotBeNull() {
        assertNotNull(activityTest);
    }



}