package com.moodAnalyzer.services;

import com.moodAnalyzer.exceptions.MoodAnalysisException;

import java.lang.reflect.Constructor;

public class MoodAnalyzerFactory {
    public static MoodAnalyzer createMoodAnalyzer(String message, String className, Class dataType) throws MoodAnalysisException{
        try {
            Class<?> moodAnalyzerClass = Class.forName(className);
            Constructor<?> moodConstructor = moodAnalyzerClass.getConstructor(dataType);
            Object moodObj = moodConstructor.newInstance(message);
            return (MoodAnalyzer) moodObj;
        } catch (ClassNotFoundException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.IMPROPER_CLASS, "Improper Class Name");
        } catch (NoSuchMethodException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.IMPROPER_CONSTRUCTOR, "Constructor improper");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}




