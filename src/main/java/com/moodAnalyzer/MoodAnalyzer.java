package com.moodAnalyzer;

public class MoodAnalyzer {
    public String analyzeMood (String moodMessage) {
        if (moodMessage.contains("I am in Sad Mood")) {
            return "SAD";
        } else if (moodMessage.contains("I am in Any mood")) {
            return "HAPPY";
        } else {
            return null;
        }
    }
}
