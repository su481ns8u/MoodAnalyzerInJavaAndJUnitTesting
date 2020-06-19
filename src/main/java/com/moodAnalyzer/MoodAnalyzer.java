package com.moodAnalyzer;

public class MoodAnalyzer {
    String moodMessage;

    public MoodAnalyzer() {

    }

    public MoodAnalyzer(String moodMessage) {
        this.moodMessage = moodMessage;
    }

    public String analyzeMood () throws MoodAnalysisException {
        try {
            if (moodMessage.length() == 0) {
                throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.ENTERED_EMPTY,"Please Enter Proper Message");
            }
            if (moodMessage.contains("I am in Sad Mood")) {
                return "SAD";
            } else if (moodMessage.contains("I am in Any Mood")) {
                return "HAPPY";
            } else {
                return null;
            }
        } catch (NullPointerException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.ENTERED_NULL,"Please Enter Proper Message");
        }
    }
}