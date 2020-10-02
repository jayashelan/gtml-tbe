package com.tbe.gtml.commons.exceptions;


import com.tbe.gtml.constants.ErrorCode;

public class GtmlException extends Exception{

    private static final long serialVersionUID = 7718828512143293558L;

    private final ErrorCode code;

    public GtmlException(ErrorCode code) {
        super();
        this.code = code;
    }

    public GtmlException(String message, Throwable cause, ErrorCode code) {
        super(message, cause);
        this.code = code;
    }

    public GtmlException(String message, ErrorCode code) {
        super(message);
        this.code = code;
    }

    public GtmlException(Throwable cause, ErrorCode code) {
        super(cause);
        this.code = code;
    }

    public ErrorCode getCode() {
        return this.code;
    }

}
