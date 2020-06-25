package com.moodAnalyzer.services;

import com.moodAnalyzer.exceptions.MoodAnalysisException;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyzerFactory {
    public static MoodAnalyzer createMoodAnalyzer(String message, String className) throws MoodAnalysisException {
        try {
            Class<?> moodAnalyzerClass = Class.forName(className);
            Constructor<?> moodConstructor = moodAnalyzerClass.getConstructor(String.class);
            Object moodObj = moodConstructor.newInstance(message);
            return (MoodAnalyzer) moodObj;
        } catch (ClassNotFoundException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.IMPROPER_CLASS, "Improper Class Name");
        } catch (NoSuchMethodException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.IMPROPER_CONSTRUCTOR, "Constructor improper");
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
        }
        return null;
    }
}




