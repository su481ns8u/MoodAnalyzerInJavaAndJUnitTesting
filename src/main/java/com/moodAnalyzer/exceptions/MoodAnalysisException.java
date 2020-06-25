package com.moodAnalyzer.exceptions;

public class MoodAnalysisException extends Exception {
    public ExceptionType type;

    public enum ExceptionType {
        ENTERED_EMPTY, ENTERED_NULL, IMPROPER_CLASS
    }

    public MoodAnalysisException(ExceptionType type, String message) {
        super(message);
        this.type = type;
    }
}
