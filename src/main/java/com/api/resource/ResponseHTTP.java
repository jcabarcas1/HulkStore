package com.api.resource;

import java.io.Serializable;

import org.springframework.http.HttpHeaders;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class ResponseHTTP implements Serializable {

    private Object data;
    private String message;
    private String developerMessage;
    private HttpHeaders httpHeaders = new HttpHeaders();
    private static final long serialVersionUID = 5318063708359922770L;

    public ResponseHTTP() {

        this.getHttpHeaders().add("Content-Type", "application/json");

    }

    public ResponseHTTP(Object data, String message) {

        super();
        this.getHttpHeaders().add("Content-Type", "application/json");
        this.data = data;
        this.message = message;

    }

    public String getMessage() {

        return message;

    }

    public void setMessage(String message) {

        this.message = message;

    }

    public String getDeveloperMessage() {

        return developerMessage;

    }

    public void setDeveloperMessage(String developerMessage) {

        this.developerMessage = developerMessage;

    }

    public Object getData() {

        return data;

    }

    public void setData(Object data) {

        this.data = data;

    }

    public HttpHeaders getHttpHeaders() {

        return httpHeaders;

    }

    public void setHttpHeaders(HttpHeaders httpHeaders) {

        this.httpHeaders = httpHeaders;

    }

}