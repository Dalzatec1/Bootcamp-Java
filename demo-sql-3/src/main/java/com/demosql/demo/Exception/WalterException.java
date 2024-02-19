package com.demosql.demo.Exception;

public class WalterException extends RuntimeException {

    public WalterException(String message, Throwable e){
        super(message, e);
    }

}
