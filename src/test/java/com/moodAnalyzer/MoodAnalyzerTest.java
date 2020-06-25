package com.moodAnalyzer;

import com.moodAnalyzer.exceptions.MoodAnalysisException;
import com.moodAnalyzer.services.MoodAnalyzer;
import com.moodAnalyzer.services.MoodAnalyzerReflector;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyzerTest {
    MoodAnalyzer moodAnalyzer;

    @Test
    public void setFieldValue_When_ShouldThrowException() {
        try {
            Object moodAnalyzer = MoodAnalyzerReflector.createMoodAnalyzer("I am in a Happy Mood","com.moodAnalyzer.services.MoodAnalyzer", String.class);
            MoodAnalyzerReflector.setFieldValue(moodAnalyzer, "moodMessage", "I am in a Happy Mood");
            Object analyzeMood = MoodAnalyzerReflector.invokeMethod(moodAnalyzer, "analyzeMood");
            Assert.assertEquals("HAPPY",analyzeMood);
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.ExceptionType.ENTERED_NULL, e.type);
        }
    }

    @Test
    public void setFieldValue_WhenImproper_ShouldThrowException() {
        try {
            Object moodAnalyzer = MoodAnalyzerReflector.createMoodAnalyzer("","com.moodAnalyzer.services.MoodAnalyzer", String.class);
            MoodAnalyzerReflector.setFieldValue(moodAnalyzer, "moodMessge", "I am in a Happy Mood");
            Object analyzeMood = MoodAnalyzerReflector.invokeMethod(moodAnalyzer, "analyzeMood");
            Assert.assertEquals("HAPPY",analyzeMood);
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.ExceptionType.NO_SUCH_FIELD, e.type);
        }
    }

    @Test
    public void givenMoodAnalyzer_OnChangeMood_ShouldReturnHappy() throws MoodAnalysisException {
        Object moodAnalyzer = MoodAnalyzerReflector.createMoodAnalyzer("I am in a Happy Mood","com.moodAnalyzer.services.MoodAnalyzer", String.class);
        MoodAnalyzerReflector.setFieldValue(moodAnalyzer, "moodMessage", "I am in a Happy Mood");
        Object analyzeMood = MoodAnalyzerReflector.invokeMethod(moodAnalyzer, "analyzeMood");
        Assert.assertEquals("HAPPY",analyzeMood);
    }

    @Test
    public void givenHappyMessage_WhenImproper_ShouldReturnException() {
        Object moodAnalyzer = null;
        try {
            moodAnalyzer = MoodAnalyzerReflector.createMoodAnalyzer("I am in a Happy Mood", "com.moodAnalyzer.services.MoodAnalyzer", String.class);
            Object analyzeMood = MoodAnalyzerReflector.invokeMethod(moodAnalyzer, "analeMood");
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.ExceptionType.IMPROPER_METHOD, e.type);
        }
    }

    @Test
    public void givenHappyMessageUsingReflection_WhenProper_ShouldReturnHAPPYMood() throws MoodAnalysisException, NoSuchMethodException {
        Object moodAnalyzer = MoodAnalyzerReflector.createMoodAnalyzer("I am in a Happy Mood", "com.moodAnalyzer.services.MoodAnalyzer", String.class);
        Object analyzeMood = MoodAnalyzerReflector.invokeMethod(moodAnalyzer, "analyzeMood");
        Assert.assertEquals("HAPPY",analyzeMood);
    }

    @Test
    public void givenClass_WhenConstructorNotProper_ShouldThrowMoodAnalysisException() {
        try {
            MoodAnalyzer moodAnalyzer = MoodAnalyzerReflector.createMoodAnalyzer("I am in a Happy Mood", "com.moodAnalyzer.services.MoodAnalyzer", Integer.class);
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.ExceptionType.IMPROPER_CONSTRUCTOR, e.type);
        }
    }

    @Test
    public void givenClassName_WhenImproper_ShouldThrowMoodAnalysisException() {
        try {
            MoodAnalyzer moodAnalyzer = MoodAnalyzerReflector.createMoodAnalyzer("I am in Happy Mood", "com.moodAnalyzer.services.MoodAnalyse",String.class);
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.ExceptionType.IMPROPER_CLASS, e.type);
        }
    }

    @Test
    public void givenMoodAnalyzerClass_WhenProper_ShouldReturnObject() throws MoodAnalysisException {
        MoodAnalyzer moodAnalyzer = MoodAnalyzerReflector.createMoodAnalyzer("I am in a Happy Mood","com.moodAnalyzer.services.MoodAnalyzer", String.class);
        Assert.assertTrue(new MoodAnalyzer("I am in a Happy Mood").equals(moodAnalyzer));
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