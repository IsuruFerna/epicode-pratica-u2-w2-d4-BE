package myweb.u2w2d1BE.payload.errors;

import java.util.Date;
import java.util.List;

public record ErrorsPayloadWithList(
        String message,
        Date timestamp,
        List<String> errorsList
) {
}
