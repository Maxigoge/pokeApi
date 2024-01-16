package org.example.errors;

import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@NoArgsConstructor
public class RestTemplateCustomError extends RuntimeException {
    private HttpStatus statusCode;
    private String error;
    public RestTemplateCustomError(HttpStatus statusCode, String error) {
        super(error);
        this.statusCode = statusCode;
        this.error = error;
    }
}