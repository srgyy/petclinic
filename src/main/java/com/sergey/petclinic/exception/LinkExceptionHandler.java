package com.sergey.petclinic.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author Sergey Borodkin
 */
@ControllerAdvice
public class LinkExceptionHandler {

    @ExceptionHandler
    public String handleException(RuntimeException exception, Model model){
        model.addAttribute("message", exception.getMessage());
        return "exception-page";
    }
}
