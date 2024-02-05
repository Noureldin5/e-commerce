package com.example.eCommerce.exception;

public class BlockedException extends RuntimeException {
    public BlockedException() {
        super();
    }

    public BlockedException(String message) {
        super(message);
    }
}
