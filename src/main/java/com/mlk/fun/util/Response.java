package com.mlk.fun.util;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

@Data
public class Response<T> implements Serializable {
    protected HttpStatus code = HttpStatus.OK;
    protected String message;

    private T data;

    public Response(T data) {
        this.data = data;
    }

    public Response(HttpStatus errorCode, String errorMessage) {
        this.code = errorCode;
        this.message = errorMessage;
    }
}
