package com.eq.hrreview.models;

public class AuthenicationResponse {
    private final String jwt;

    public AuthenicationResponse(String jwt) {
        this.jwt = jwt;
    }

    public String getJwt() {
        return jwt;
    }
}
