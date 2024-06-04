package com.example.schoolmanagement.model;

public enum Grade {
    A, B, C, D, E, F;

    public static Grade fromScore(Double score) {
        if (score >= 91) {
            return A;
        } else if (score >= 81) {
            return B;
        } else if (score >= 71) {
            return C;
        } else if (score >= 61) {
            return D;
        } else if (score >= 51) {
            return E;
        } else {
            return F;
        }
    }
}
