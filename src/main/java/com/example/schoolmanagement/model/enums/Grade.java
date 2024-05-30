package com.example.schoolmanagement.model.enums;

public enum Grade {
    F, D, C, B, A;

    public static Grade convertToGrade(double score){
        if (score > 100 || score < 0)
            throw new RuntimeException("Score should between 0 and 100 range.");

        for (Grade grade : Grade.values())
            if(!(score >= grade.ordinal() * 10 + 61))
                return grade;

        return null;
    }
}
