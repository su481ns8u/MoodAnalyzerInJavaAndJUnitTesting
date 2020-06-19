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
        if (moodMessage.contains("I am in Sad Mood")) {
            return "SAD";
        } else if (moodMessage.contains("I am in Any Mood")) {
            return "HAPPY";
        } else {
            return null;
        }
    }
}