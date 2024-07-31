package co.bw.weblogic.springuser.util;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.Date;

/**
 * Created by oaitsekokome on Jul, 19, 2024
 */
@Getter
@Setter
public class HttpResponse<E> {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-dd-yyyy hh:mm:ss", timezone = "Africa/Gaborone")
    private Date timeStamp;
    private int httpStatusCode;
    private HttpStatus httpStatus;
    private String reason;
    private String message;
    private E data;

    @Deprecated
    public HttpResponse() {
        this.timeStamp = new Date();
        this.data = null;
    }

    public HttpResponse(HttpStatus httpStatus, String message, E data) {
        this.timeStamp = new Date();
        this.httpStatusCode = httpStatus.value();
        this.httpStatus = httpStatus;
        this.reason = httpStatus.getReasonPhrase();
        this.message = message;
        this.data = data;
    }

    public HttpResponse(HttpStatus httpStatus, E data) {
        this.timeStamp = new Date();
        this.httpStatusCode = httpStatus.value();
        this.httpStatus = httpStatus;
        this.reason = httpStatus.getReasonPhrase();
        this.message = null;
        this.data = data;
    }
}