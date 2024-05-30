package com.example.schoolmanagement.model.enums;


public enum Mark {

    F , E, D , C , B , A;

    public static Mark getMarkByScore(Double score){
        if(score < 51) return F;
        int order = (int)((score - 51) / 10);
        return Mark.values()[order + 1];
    }

}
