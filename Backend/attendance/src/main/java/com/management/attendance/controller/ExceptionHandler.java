package com.management.attendance.controller;

import com.management.attendance.dto.CustomError;
import com.management.attendance.exception.BadRequestException;
import com.management.attendance.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ExceptionHandler {

    private static final String NOT_FOUND_ERROR_MESSAGE = "The requested resource is not found";

    /*@RequestMapping("/error")
    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    public ModelAndView handleError(Exception ex) {
        return sendMsg("Unexpected error. Please contact support");
    }
    */
    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    public ResponseEntity handleBroadError(Exception ex){
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    CustomError onNotFoundException(NotFoundException e) {
        CustomError customError = new CustomError();
        customError.setErrorCode("404");
        customError.setMessage(NOT_FOUND_ERROR_MESSAGE);
        return customError;
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    CustomError onBadRequestException(BadRequestException e) {
        CustomError customError = new CustomError();
        customError.setErrorCode(e.getErrorCode());
        customError.setMessage(e.getMessage());
        return customError;
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    List<CustomError> onMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        List<CustomError> errorList=new ArrayList<>();
        for (FieldError fieldError : e.getBindingResult().getFieldErrors()) {
            CustomError error = new CustomError();
            error.setErrorCode("Field.Missing");
            error.setMessage(fieldError.getField()+" "+fieldError.getDefaultMessage());
            errorList.add(error);
        }
        return errorList;
    }

    /*private ModelAndView sendMsg(String toString) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("errorMsg", toString);
        mav.setViewName("error");
        return mav;
    }*/
}
