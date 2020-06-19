package com.moodAnalyze;

import com.moodAnalyzer.MoodAnalysisException;
import com.moodAnalyzer.MoodAnalyzer;
import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.rmi.server.ExportException;

public class MoodAnalyzerTest {
    MoodAnalyzer moodAnalyzer;

    @Test
    public void analyzeMoodTest_returnsSAD_ifMoodEqualsSad() throws MoodAnalysisException {
        moodAnalyzer = new MoodAnalyzer("I am in Sad Mood");
        String mood = this.moodAnalyzer.analyzeMood();
        Assert.assertEquals("SAD",mood);
    }

    @Test
    public void analyzeMoodTest_returnsHAPPY_ifMoodEqualsAnythingOtherThanSad() throws MoodAnalysisException {
        moodAnalyzer = new MoodAnalyzer("I am in Any Mood");
        String mood = moodAnalyzer.analyzeMood();
        Assert.assertEquals("HAPPY",mood);
    }

    @Test
    public void givenNullMood_shouldThrowException() {
        moodAnalyzer = new MoodAnalyzer(null);
        try {
            moodAnalyzer.analyzeMood();
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.ExceptionType.ENTERED_NULL,e.type);
        }
    }

    @Test
    public void givenNoMood_shouldThrowException() {
        moodAnalyzer = new MoodAnalyzer("");
        try {
            moodAnalyzer.analyzeMood();
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.ExceptionType.ENTERED_EMPTY,e.type);
        }
    }
}
