package com.spring.restaurant.demo.dto;

public class JwtProperties {
    public static final String SECRET = "Ezzat";
    public static final int EXPIRATION_TIME = 864_000_000; // 10 days
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
}
