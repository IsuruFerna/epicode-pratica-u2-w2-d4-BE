package myweb.u2w2d1BE.exceptions;

import lombok.extern.slf4j.Slf4j;
import myweb.u2w2d1BE.payload.errors.ErrorsPayloadWithList;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestControllerAdvice
@Slf4j
public class ExeptionHandler {
    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorsPayloadWithList handleBadRequest(BadRequestException ex) {
        List<String> errorsMessages = new ArrayList<>();
        if(ex.getErrorList() != null) {
            errorsMessages = ex.getErrorList().stream().map(err -> err.getDefaultMessage()).toList();
        }
        return new ErrorsPayloadWithList(ex.getMessage(), new Date(), errorsMessages);
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorsPayload handleNotFound(NotFoundException ex) {
        return new ErrorsPayload(ex.getMessage(), LocalDateTime.now());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorsPayload handleNotFound(Exception ex) {
        ex.printStackTrace();
        return new ErrorsPayload("Server side problem! We will fix the issue as soon as possible!", LocalDateTime.now());
    }
}
