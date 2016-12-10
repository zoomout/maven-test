package com.bogdan.domain.httpbinbody;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by zoomout on 12/10/16.
 */
public class Headers {
    @JsonProperty("Accept")
    private String accept;

    @JsonProperty("Accept-Encoding")
    private String acceptEncoding;

    @JsonProperty("Content-Length")
    private String contentLength;

    @JsonProperty("Content-Type")
    private String contentType;

    @JsonProperty("Host")
    private String host;

    @JsonProperty("User-Agent")
    private String userAgent;

    public String getAccept() {
        return accept;
    }

    public void setAccept(String accept) {
        this.accept = accept;
    }

    public String getAcceptEncoding() {
        return acceptEncoding;
    }

    public void setAcceptEncoding(String acceptEncoding) {
        this.acceptEncoding = acceptEncoding;
    }

    public String getContentLength() {
        return contentLength;
    }

    public void setContentLength(String contentLength) {
        this.contentLength = contentLength;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }
}
