package com.moodAnalyzer;

public class MoodAnalysisException extends Exception {
    public ExceptionType type;

    public enum ExceptionType {
        ENTERED_EMPTY, ENTERED_NULL
    }

    public MoodAnalysisException(ExceptionType type, String message) {
        super(message);
        this.type = type;
    }
}
