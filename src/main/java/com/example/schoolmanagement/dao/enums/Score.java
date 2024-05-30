package com.example.schoolmanagement.dao.enums;

public enum Score {
    A, B, C, D, E, F;

    public static Score getScore(Double score) {
        if (score < 0 || score > 100) {
            throw new IllegalArgumentException("Score must be between 0 and 100");
        }
        if (score < 50.5) {
            return F;
        } else if (score < 60.5) {
            return E;
        } else if (score < 70.5) {
            return D;
        } else if (score < 80.5) {
            return C;
        } else if (score < 90.5) {
            return B;
        } else {
            return A;
        }
    }
}

