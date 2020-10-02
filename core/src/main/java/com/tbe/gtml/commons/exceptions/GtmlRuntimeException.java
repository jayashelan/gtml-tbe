package com.tbe.gtml.commons.exceptions;

import com.tbe.gtml.constants.ErrorCode;

public class GtmlRuntimeException extends RuntimeException {

    private final ErrorCode code;

    public GtmlRuntimeException(ErrorCode code) {
        super();
        this.code = code;
    }



    public GtmlRuntimeException(String message, Throwable cause, ErrorCode code) {
        super(message, cause);
        this.code = code;
    }

    public GtmlRuntimeException(String message, ErrorCode code) {
        super(message);
        this.code = code;
    }

    public GtmlRuntimeException(Throwable cause, ErrorCode code) {
        super(cause);
        this.code = code;
    }

    public ErrorCode getCode() {
        return this.code;
    }
}
