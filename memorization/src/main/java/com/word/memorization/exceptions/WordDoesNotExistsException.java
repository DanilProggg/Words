package com.word.memorization.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Word does not exists")
public class WordDoesNotExistsException extends RuntimeException {

    public WordDoesNotExistsException() {
        super("Word does not exist");
    }

    public WordDoesNotExistsException(String message) {
        super(message);
    }

    public WordDoesNotExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public WordDoesNotExistsException(Throwable cause) {
        super(cause);
    }
}
