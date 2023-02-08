package com.bancopichincha.retojava.domain.exception;

public class ClienteNotFound extends RuntimeException{

    public ClienteNotFound (String message){
        super(message);
    }

}
