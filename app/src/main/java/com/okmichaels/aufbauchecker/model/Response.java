package com.okmichaels.aufbauchecker.model;

/**
 * holds the model for a http response from the API server
 */

public class Response {
    String http_code;
    boolean success;
    String content;

    public Response() {
        this(null, false, null);
    }

    public Response(String code, boolean status, String ctn) {
        this.http_code = code;
        this.success = status;
        this.content = ctn;
    }

    public String getHttp_code() {
        return http_code;
    }

    public void setHttp_code(String http_code) {
        this.http_code = http_code;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
