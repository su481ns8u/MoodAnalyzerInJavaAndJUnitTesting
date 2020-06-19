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
            if (moodMessage.contains("I am in Sad Mood")) {
                return "SAD";
            } else if (moodMessage.contains("I am in Any Mood")) {
                return "HAPPY";
            } else {
                return null;
            }
        } catch (NullPointerException e) {
            throw new MoodAnalysisException("Please Enter Proper Message");
        }
    }
}