package com.anadeainc.exampledagger.common;

import com.anadeainc.exampledagger.basemvp.BaseMvpActivity;
import com.anadeainc.lightmvp.mvpview.IMvpParent;
import com.jakewharton.rxrelay2.PublishRelay;

import io.reactivex.Observable;

public abstract class CompositeActivity extends BaseMvpActivity implements IMvpParent {

    private PublishRelay<Action> relay = PublishRelay.create();

    protected Observable<Action> observable() {
        return relay;
    }

    @Override
    protected void onStart() {
        super.onStart();
        relay.accept(Action.START);
    }

    @Override
    protected void onStop() {
        super.onStop();
        relay.accept(Action.STOP);
    }

    @Override
    protected void notifyComponentOnDestroy(boolean isChangingConfigurations) {
        relay.accept(isChangingConfigurations() ?
                Action.CHANGING : Action.DESTROY);
        relay = null;
    }

    public enum Action {
        START, STOP, CHANGING, DESTROY
    }

}
