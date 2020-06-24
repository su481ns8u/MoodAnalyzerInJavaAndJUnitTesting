package com.moodAnalyzer.services;

import java.lang.reflect.Constructor;

public class MoodAnalyzerFactory {
    public static MoodAnalyzer createMoodAnalyzer(String message) {
        try {
            Class<?> moodAnalyzerClass = Class.forName("com.moodAnalyzer.services.MoodAnalyzer");
            Constructor<?> moodConstructor = moodAnalyzerClass.getConstructor(String.class);
            Object moodObj = moodConstructor.newInstance(message);
            return (MoodAnalyzer) moodObj;
        } catch (Exception e) {
        }
        return null;
    }
}




