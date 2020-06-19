package com.moodAnalyze;

import com.moodAnalyzer.MoodAnalyzer;
import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyzerTest {
    MoodAnalyzer moodAnalyzer = new MoodAnalyzer();

    @Test
    public void sadMoodTest_givesTrue_ifMoodEqualsSad() {
        String mood = moodAnalyzer.analyzeMood("SAD");
        Assert.assertEquals("SAD",mood);
    }

    @Test
    public void happyMoodTest_givesTrue_ifMoodEqualsAnythingOtherThanSad() {
        String mood = moodAnalyzer.analyzeMood("Any mood");
        Assert.assertEquals("HAPPY",mood);
    }
}
