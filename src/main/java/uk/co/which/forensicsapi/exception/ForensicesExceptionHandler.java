package uk.co.which.forensicsapi.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
@Slf4j
public class ForensicesExceptionHandler {

    @ResponseBody
    @ExceptionHandler(IncorrectAPICallException.class)
    ResponseEntity incorrectAPICallExceptionHandler(HttpServletRequest request,
                                           HttpServletResponse response, Exception ex) {
        return new ResponseEntity(new ErrorInfo(ex.getMessage()),HttpStatus.BAD_REQUEST);
    }

    @ResponseBody
    @ExceptionHandler(IncorrectGuesslException.class)
    ResponseEntity IncorrectGuesslException(HttpServletRequest request,
                                           HttpServletResponse response, Exception ex) {
        return new ResponseEntity(new ErrorInfo(ex.getMessage()),HttpStatus.OK);
    }
}
