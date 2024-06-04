package com.example.schoolmanagement.maper.qualifier;

import com.example.schoolmanagement.model.Grade;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;

@Component
public class StudentQualifier {

    @Named("mapScoreToGrade")
    public Grade mapScoreToGrade (Double score) {
        return Grade.fromScore(score);
    }

}
