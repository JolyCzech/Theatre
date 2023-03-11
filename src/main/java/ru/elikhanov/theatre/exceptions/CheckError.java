package ru.elikhanov.theatre.exceptions;

import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.List;


public class CheckError {
    public static boolean checkError(BindingResult bindingResult,String message) {

        if (bindingResult.hasErrors()) {
            StringBuilder errorMsg = new StringBuilder();

            List<FieldError> errors = bindingResult.getFieldErrors();
            for (FieldError e : errors) {
                errorMsg.append(e.getField())
                        .append(" - ").append(e.getDefaultMessage())
                        .append(";");
            }

            throw new BadRequestException(message+" "+errorMsg);
        }
        return false;
    }

}
