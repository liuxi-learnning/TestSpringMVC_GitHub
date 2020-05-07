package com.liuxi.springmvc.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.BAD_REQUEST, reason="do test")
public class UserNameNotMatchPasswordException extends RuntimeException {

    private static final long serialVersionUID = 2231572284368050852L;

}
