package com.moodAnalyzer.services;

import com.moodAnalyzer.exceptions.MoodAnalysisException;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MoodAnalyzerFactory {
    public static MoodAnalyzer createMoodAnalyzer(String message, String className, Class dataType) throws MoodAnalysisException {
        try {
            Class<?> moodAnalyzerClass = Class.forName(className);
            Constructor<?> moodConstructor = moodAnalyzerClass.getConstructor(dataType);
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




