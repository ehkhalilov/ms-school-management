package com.example.schoolmanagement.enums;

public enum Grade {
    A(90.01,100.00),
    B(80.01,90.00),
    C(70.01,80.00),
    D(60.01,70.00),
    E(50.01,60.00),
    F(0.00,50.00);

    private final Double start;
    private final Double end;

    Grade(Double start,Double end){
        this.start = start;
        this.end = end;
    }

    public static Grade scoreToGrade(Double score){
        if(score == null){
            return null;
        }

        for(Grade grade : Grade.values()){
            if(score >= grade.start && score <= grade.end){
                return grade;
            }
        }
        return null;
    }
}
