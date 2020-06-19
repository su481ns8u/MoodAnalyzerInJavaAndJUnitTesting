package com.moodAnalyzer;

public class MoodAnalyzer {
    String moodMessage;

    public MoodAnalyzer() {
        moodMessage = null;
    }

    public MoodAnalyzer(String moodMessage) {
        this.moodMessage = moodMessage;
    }

    public String analyzeMood () {
        if (moodMessage.contains("SAD")) {
            return "SAD";
        } else if (moodMessage.contains("HAPPY")) {
            return "HAPPY";
        } else {
            return null;
        }
    }
}