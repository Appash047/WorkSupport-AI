package com.worksupport.handlers;

import com.worksupport.exception.BadDataException;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleAllException(Exception ex, Model model) {
        model.addAttribute("error", "There is some glitch, we'll get back to you soon on this");
        return "error";
    }

    @ExceptionHandler(value = BadDataException.class)
    public String badDataExceptionHandler(RedirectAttributes attributes, BadDataException exception) {
        attributes.addAttribute("error", exception.getMessage());
        return exception.getRedirectUrl();
    }
}