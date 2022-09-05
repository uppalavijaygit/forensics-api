package uk.co.which.forensicsapi.exception;

public class IncorrectGuesslException extends RuntimeException{
    public IncorrectGuesslException(String errorMessage) {
        super(errorMessage);
    }
}
