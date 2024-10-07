package com.r3rivera.app.alarms.exceptions;

public class DataProcessException extends Exception{


    public DataProcessException(String message){
        super(message);
    }

    public DataProcessException(String message, Throwable e){
        super(message, e);
    }

}
