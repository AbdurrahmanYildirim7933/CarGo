package com.mantis.exceptions;

import java.util.Set;

public class CustomException extends RuntimeException{
    private String title;
    private String message;

    public CustomException(String errorMessages) {
        this.message = errorMessages;
    }

    public CustomException(){

    }public CustomException(String title,String errorMessage){
        this.message = errorMessage;
        this.title = title;
    }

    public String getErrorTitle() {
        return title;
    }


    //Jsona çevirilecek

    public void setErrorTitle(String errorTitle) {
        this.title = errorTitle;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
