package com.okmichaels.aufbauchecker.model;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;

import java.lang.reflect.Type;
import java.text.ParseException;

/**
 * holds the model for a http response from the API server
 */

public class Response {
    String http_code;
    boolean success;
    Content content;

    public Response() {
        this(null, false, null);
    }

    public Response(String code, boolean status, Content ctn) {
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

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }
}
