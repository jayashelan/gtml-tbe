package com.tbe.gtml.common.constants;


public enum ErrorCode {

    SERDE_PARSER_EXCEPTION(1,"SERDE_PARSER_EXCEPTION");


    private int errorCode;
    private String description;

    private ErrorCode(int errorCode,String description){
        this.errorCode = errorCode;
        this.description = description;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
