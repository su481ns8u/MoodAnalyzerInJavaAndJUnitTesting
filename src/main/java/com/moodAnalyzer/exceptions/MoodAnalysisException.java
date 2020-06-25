package com.moodAnalyzer.exceptions;

public class MoodAnalysisException extends Exception {
    public ExceptionType type;

    public enum ExceptionType {
        ENTERED_EMPTY, ENTERED_NULL, IMPROPER_CLASS, IMPROPER_CONSTRUCTOR, IMPROPER_METHOD, NO_SUCH_FIELD, INVOKE_ISSUE, FIELD_SETTING_ISSUE
    }

    public MoodAnalysisException(ExceptionType type, String message) {
        super(message);
        this.type = type;
    }
}
