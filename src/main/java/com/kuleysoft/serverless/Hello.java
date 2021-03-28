package com.kuleysoft.serverless;

import java.util.function.Function;

public class Hello implements Function<String, String> {

    @Override
    public String apply(final String s) {
        return "Hello " + s;
    }

}
