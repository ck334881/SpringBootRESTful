package com.mobin.exception;

public class EntityNotFoundException extends RuntimeException{
    public EntityNotFoundException(String mes){
      super(mes);
    }
}
