package myweb.u2w2d1BE.exceptions;

public class NotFoundException extends RuntimeException{
    public NotFoundException(Long id) {
        super("Element wid id " + id + " not found!");
    }
}
