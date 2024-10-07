package com.r3rivera.app.alarms.exceptions;


public class DataProcessRuntimeException extends RuntimeException{

    public DataProcessRuntimeException(String message){
        super(message);
    }

    public DataProcessRuntimeException(String message, Throwable e){
        super(message, e);
    }
}
