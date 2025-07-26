package com.ecom_graphql.ecom.graphql.helper;

public class ExceptionHelper {

    public static RuntimeException throwResourceNotFoundException() {
        return new RuntimeException("Resource not found");
    }
}
