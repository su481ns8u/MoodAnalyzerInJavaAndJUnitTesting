package com.moodAnalyze;

import com.moodAnalyzer.MoodAnalyzer;
import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyzerTest {
    MoodAnalyzer moodAnalyzer = new MoodAnalyzer();

    @Test
    public void sadMoodTest_returnsSAD_ifMoodEqualsSad() {
        String mood = moodAnalyzer.analyzeMood("I am in Sad Mood");
        Assert.assertEquals("SAD",mood);
    }

    @Test
    public void happyMoodTest_returnsHAPPY_ifMoodEqualsAnythingOtherThanSad() {
        String mood = moodAnalyzer.analyzeMood("I am in Any mood");
        Assert.assertEquals("HAPPY",mood);
    }
}
