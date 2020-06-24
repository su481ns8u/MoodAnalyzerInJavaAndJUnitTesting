package com.moodAnalyzer;

import com.moodAnalyzer.exceptions.MoodAnalysisException;
import com.moodAnalyzer.services.MoodAnalyzer;
import com.moodAnalyzer.services.MoodAnalyzerFactory;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyzerTest {
    MoodAnalyzer moodAnalyzer;

    @Test
    public void givenMoodAnalyzerClass_WhenProper_ShouldReturnObject() throws MoodAnalysisException {
        MoodAnalyzer moodAnalyzer = MoodAnalyzerFactory.createMoodAnalyzer("I am in a Happy Mood");
        String mood = moodAnalyzer.analyzeMood();
        Assert.assertEquals("HAPPY",mood);
    }

    @Test
    public void givenMoodAnalyzer_WhenProper_ShouldReturnObject() throws ClassNotFoundException, NoSuchMethodException {
        Constructor<?> constructor = Class.forName("com.moodAnalyzer.services.MoodAnalyzer").getConstructor(String.class);
        try {
            Object myObj = constructor.newInstance("I am in a Happy Mood");
            MoodAnalyzer moodAnalyzer = (MoodAnalyzer) myObj;
            String mood = moodAnalyzer.analyzeMood();
            Assert.assertEquals("HAPPY", mood);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (MoodAnalysisException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void analyzeMoodTest_returnsSAD_ifMoodEqualsSad() throws MoodAnalysisException {
        moodAnalyzer = new MoodAnalyzer("I am in Sad Mood");
        String mood = this.moodAnalyzer.analyzeMood();
        Assert.assertEquals("SAD", mood);
    }

    @Test
    public void analyzeMoodTest_returnsHAPPY_ifMoodEqualsAnythingOtherThanSad() throws MoodAnalysisException {
        moodAnalyzer = new MoodAnalyzer("I am in Any Mood");
        String mood = moodAnalyzer.analyzeMood();
        Assert.assertEquals("HAPPY", mood);
    }

    @Test
    public void givenNullMood_shouldThrowException() {
        moodAnalyzer = new MoodAnalyzer(null);
        try {
            moodAnalyzer.analyzeMood();
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.ExceptionType.ENTERED_NULL, e.type);
        }
    }

    @Test
    public void givenNoMood_shouldThrowException() {
        moodAnalyzer = new MoodAnalyzer("");
        try {
            moodAnalyzer.analyzeMood();
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.ExceptionType.ENTERED_EMPTY, e.type);
        }
    }
}