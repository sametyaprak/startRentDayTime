package com.visionrent.exception;

public class ResourceNotFoundException extends RuntimeException {
    /**
     *
     * @param message that will be sent when we throw this exception
     */
    public ResourceNotFoundException(String message){
        super(message);
    }

}
