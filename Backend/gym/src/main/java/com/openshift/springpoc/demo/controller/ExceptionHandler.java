package com.openshift.springpoc.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

@ControllerAdvice
public class ExceptionHandler {

    @RequestMapping("/error")
    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    public ModelAndView handleError(Exception ex) {
        return sendMsg("Unexpected error. Please contact support");
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ModelAndView handleConstraintViolationException(ConstraintViolationException ex) {
        StringBuilder obError1 = new StringBuilder();
        for (ConstraintViolation<?> violation : ex.getConstraintViolations()) {
            obError1.append(ex.getMessage());
            obError1.append(" ");
            obError1.append(violation.getPropertyPath().toString());
            obError1.append(" ");
            obError1.append((violation.getMessage()));
        }
        return sendMsg(obError1.toString());
    }

    private ModelAndView sendMsg(String toString) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("errorMsg", toString);
        mav.setViewName("error");
        return mav;
    }
}
