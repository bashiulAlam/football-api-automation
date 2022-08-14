package com.assignment.endtoendtest.utils;

import java.util.HashMap;
import java.util.Map;

public class HeaderBuilder {
    public static final String X_AUTH_TOKEN = "X-Auth-Token";
    public static final String CONTENT_TYPE = "Content-Type";

    String xAuthToken = null;
    String contentType = null;

    public HeaderBuilder() {
    }

    public HeaderBuilder addXAuthToken(String xAuthToken) {
        this.xAuthToken = xAuthToken;
        return this;
    }

    public HeaderBuilder addContentType(String contentType) {
        this.contentType = contentType;
        return this;
    }

    public Map<String, String> build() {
        Map<String, String> result = new HashMap<String, String>();

        if (xAuthToken != null) {
            result.put(X_AUTH_TOKEN, this.xAuthToken);
        }
        if (contentType != null) {
            result.put(CONTENT_TYPE, this.contentType);
        }

        return result;
    }
}
