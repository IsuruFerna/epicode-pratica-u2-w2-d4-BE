package myweb.u2w2d1BE.payload.errors;

import java.time.LocalDateTime;
import java.util.Date;

public record ErrorsPayload(
        String message,
        Date timestamp) {
    public ErrorsPayload(String message, Date timestamp) {
        this.message = message;
        this.timestamp = timestamp;
    }
}
