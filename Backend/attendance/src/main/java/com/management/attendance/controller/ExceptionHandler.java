package com.management.attendance.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionHandler {

    @RequestMapping("/error")
    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    public ModelAndView handleError(Exception ex) {
        return sendMsg("Unexpected error. Please contact support");
    }


    private ModelAndView sendMsg(String toString) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("errorMsg", toString);
        mav.setViewName("error");
        return mav;
    }
}
