package org.hino.sbb.controller;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger logger = Logger.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(NoHandlerFoundException.class)
    public String renderErrorPage(Exception exception, Model model)  {
        String errorMsg = "Http Error Code: 404. Not found";
        model.addAttribute("errorMsg", errorMsg);
        logger.error(exception.getMessage());
        return "errors";
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleException(Exception exception, Model model) {
        String errorMsg = "Http Error Code: 500. Something went wrong.";
        model.addAttribute("errorMsg", errorMsg);
        logger.error(exception.getMessage());
        logger.error(exception.getStackTrace().toString());
        return "errors";
    }

}
