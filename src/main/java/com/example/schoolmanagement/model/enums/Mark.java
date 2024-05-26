package com.example.schoolmanagement.model.enums;


public enum Mark {

    F , E, D , C , B , A;

    public static Mark getMarkByScore(Double score){
        double order = (score - 51) / 10;

        for (Mark item: Mark.values() ) {
            if(item.ordinal() > order){
                return item;
            }
        }
        return null;
    }

}
