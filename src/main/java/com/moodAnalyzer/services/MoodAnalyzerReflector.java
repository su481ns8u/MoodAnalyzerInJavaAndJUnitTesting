package com.moodAnalyzer.services;

import com.moodAnalyzer.exceptions.MoodAnalysisException;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyzerReflector {
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

    public static Object invokeMethod(Object moodAnalyzerObject, String methodName) throws MoodAnalysisException {
        try {
            return moodAnalyzerObject.getClass().getMethod(methodName).invoke(moodAnalyzerObject);
        } catch (NoSuchMethodException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.IMPROPER_METHOD, "Method Name Improper");
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.INVOKE_ISSUE, "Method Invocation Issue");
        }
    }

    public static void setFieldValue(Object moodAnalyzer, String fieldName, String fieldValue) throws MoodAnalysisException {
        try {
            Field field = moodAnalyzer.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(moodAnalyzer, fieldValue);
        } catch (NoSuchFieldException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NO_SUCH_FIELD, "Method Invocation Issue");
        } catch (IllegalAccessException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.FIELD_SETTING_ISSUE, "Issue setting a field");
        }
    }
}




