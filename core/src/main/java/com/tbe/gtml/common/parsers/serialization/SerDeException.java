package com.tbe.gtml.common.parsers.serialization;

import com.tbe.gtml.common.constants.ErrorCode;

public class SerDeException extends Exception{

    private static final long serialVersionUID = 7718828512143293558L;

    private final ErrorCode code;

    public SerDeException(ErrorCode code) {
        super();
        this.code = code;
    }

    public SerDeException(String message, Throwable cause, ErrorCode code) {
        super(message, cause);
        this.code = code;
    }

    public SerDeException(String message, ErrorCode code) {
        super(message);
        this.code = code;
    }

    public SerDeException(Throwable cause, ErrorCode code) {
        super(cause);
        this.code = code;
    }

    public ErrorCode getCode() {
        return this.code;
    }

}
