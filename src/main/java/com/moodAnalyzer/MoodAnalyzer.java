package com.moodAnalyzer;

public class MoodAnalyzer {
    public String analyzeMood (String moodMessage) {
        if (moodMessage.contains("SAD")) {
            return "SAD";
        } else {
            return "HAPPY";
        }
    }
}
