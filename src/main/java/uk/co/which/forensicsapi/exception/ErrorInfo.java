package uk.co.which.forensicsapi.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class ErrorInfo {
    private final String message;
}
