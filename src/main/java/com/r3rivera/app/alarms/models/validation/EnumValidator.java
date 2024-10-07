package com.r3rivera.app.alarms.models.validation;

import java.util.Arrays;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.extern.slf4j.Slf4j;
;

@Slf4j
public class EnumValidator implements ConstraintValidator<ValidEnum, String>{

    private Class<? extends Enum<?>> enumClass;


    @Override
    public void initialize(ValidEnum validEnum){
        this.enumClass = validEnum.enumClass();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        log.info("EnumValidator.isValid() called.");
        if (value == null){
            return true;
        }
        return Arrays.stream(enumClass.getEnumConstants())
            .anyMatch(e -> {
                return e.toString().equalsIgnoreCase(value);
            });
    }

}
