package com.word.memorization.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Word already added")
public class WordAlreadyExistsException extends RuntimeException {

    public WordAlreadyExistsException() {
        super("Word already added");
    }

    public WordAlreadyExistsException(String message) {
        super(message);
    }

    public WordAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public WordAlreadyExistsException(Throwable cause) {
        super(cause);
    }
}
