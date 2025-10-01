package cat.itacademy.s04.t02.n01.s04t02n01.exception;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.OffsetDateTime;
import java.util.List;

public record ApiError(
        @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssXXX")
        OffsetDateTime timestamp,
        int status,
        String error,
        String message,
        String path,
        List<String> errors
) {}
