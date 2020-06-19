package com.moodAnalyze;

import com.moodAnalyzer.MoodAnalyzer;
import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyzerTest {
    MoodAnalyzer moodAnalyzer = new MoodAnalyzer();

    @Test
    public void sadMoodTest_returnsSAD_ifMoodEqualsSad() {
        moodAnalyzer = new MoodAnalyzer("I am in Sad Mood");
        String mood = this.moodAnalyzer.analyzeMood();
        Assert.assertEquals("SAD",mood);
    }

    @Test
    public void happyMoodTest_returnsHAPPY_ifMoodEqualsAnythingOtherThanSad() {
        moodAnalyzer = new MoodAnalyzer("HAPPY");
        String mood = moodAnalyzer.analyzeMood();
        Assert.assertEquals("HAPPY",mood);
    }
}
