package myweb.u2w2d1BE.exceptions;

public class BadRequestExeption extends RuntimeException{
    public BadRequestExeption(String message) {
        super(message);
    }
}
