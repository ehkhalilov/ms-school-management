package com.example.schoolmanagement.validations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class MailCheckLogic implements ConstraintValidator<MailCheck,String> {

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        System.out.println("HELLO");
        if(email.endsWith("@mail.az")){
            return true;
        }else{
            return false;
        }
    }
}
