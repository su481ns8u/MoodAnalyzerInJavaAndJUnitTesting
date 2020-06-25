package com.moodAnalyzer.services;

import com.moodAnalyzer.exceptions.MoodAnalysisException;

public class MoodAnalyzer {
    String moodMessage;

    public MoodAnalyzer(String moodMessage) {
        this.moodMessage = moodMessage;
    }

    public String analyzeMood(String message) throws MoodAnalysisException {
        this.moodMessage = message;
        return analyzeMood();
    }

    public String analyzeMood() throws MoodAnalysisException {
        try {
            if (moodMessage.length() == 0) {
                throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.ENTERED_EMPTY, "Please Enter Proper Message");
            }
            if (moodMessage.contains("I am in Sad Mood")) {
                return "SAD";
            } else if (moodMessage.contains("I am in a Happy Mood")) {
                return "HAPPY";
            } else {
                return null;
            }
        } catch (NullPointerException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.ENTERED_NULL, "Please Enter Proper Message");
        }
    }

    public boolean equals(MoodAnalyzer another) {
        if (this.moodMessage.equals(another.moodMessage)) {
            return true;
        } else {
            return false;
        }
    }
}