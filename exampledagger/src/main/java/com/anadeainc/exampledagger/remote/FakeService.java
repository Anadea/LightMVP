package com.anadeainc.exampledagger.remote;

import com.anadeainc.exampledagger.remote.api.FakeApi;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class FakeService implements RemoteService<FakeApi> {

    private final FakeApi api = new FakeApi();

    @Inject
    FakeService() {
    }

    @Override
    public FakeApi getApi() {
        return api;
    }

}
