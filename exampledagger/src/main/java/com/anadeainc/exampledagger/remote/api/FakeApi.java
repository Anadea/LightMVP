package com.anadeainc.exampledagger.remote.api;

import android.os.SystemClock;

import java.io.IOException;

import io.reactivex.Single;
import io.reactivex.internal.operators.single.SingleError;

public final class FakeApi {

    public Single<String> login(final String login, final String password) {

        return Single.defer(() -> {
            SystemClock.sleep(4000);
            if ("login".equals(login) && "password".equals(password)) {
                return Single.just("result");
            } else {
                return SingleError.error(() -> {
                    return new IOException("Invalid credentials");
                });
            }
        });

    }

}
