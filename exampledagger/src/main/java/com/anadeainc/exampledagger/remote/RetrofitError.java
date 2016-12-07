package com.anadeainc.exampledagger.remote;

import com.jakewharton.retrofit2.adapter.rxjava2.HttpException;

import java.io.IOException;

public final class RetrofitError {

    private RetrofitError() {
    }

    public static String message(Throwable throwable) {

        String message = "We don't know what happened";

        if (throwable instanceof HttpException) {
            // non-2XX http error
            HttpException httpException = (HttpException) throwable;
            message = httpException.response().message();
        } else if (throwable instanceof IOException) {
            // A network or conversion error happened
            message = "Check your network connection";
        }

        return message;
    }
}
