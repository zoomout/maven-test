package com.bogdan.domain;

/**
 * Created by zoomout on 12/20/16.
 */
public class Nested {
    private String id;
    private Body body;

    public Nested() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }

    public Nested(String id, Body body) {

        this.id = id;
        this.body = body;
    }
}
