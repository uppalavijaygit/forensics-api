package uk.co.which.forensicsapi.exception;

public class IncorrectAPICallException extends RuntimeException{
    public IncorrectAPICallException(String errorMessage) {
        super(errorMessage);
    }
}
