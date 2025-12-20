package com.example.demo.util;

public class RiskLevelUtils {

    /**
     * Maps a numeric total score to a risk level string.
     * Thresholds:
     * 0-19: LOW
     * 20-49: MEDIUM
     * 50-79: HIGH
     * 80+: CRITICAL
     */
    public static String determineRiskLevel(int score) {
        if (score < 0) {
            return "LOW"; // Safety check for negative scores
        }
        if (score <= 19) {
            return "LOW";
        } else if (score <= 49) {
            return "MEDIUM";
        } else if (score <= 79) {
            return "HIGH";
        } else {
            return "CRITICAL";
        }
    }
}