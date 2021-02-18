package org.hino.sbb.controller;

import org.apache.log4j.Logger;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

//@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger logger = Logger.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    public String handleException(Model model) {
        String errorMsg = "Http Error Code: 500. Something went wrong.";
        model.addAttribute("errorMsg", errorMsg);
        return "errors";
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public String renderErrorPage(Model model)  {
        String errorMsg = "Http Error Code: 404. Not found";
        model.addAttribute("errorMsg", errorMsg);
        return "errors";
    }
}
