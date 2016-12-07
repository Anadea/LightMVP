package com.anadeainc.exampleplain.base;

import android.support.annotation.NonNull;

import com.anadeainc.lightmvp.MvpActivity;

import java.util.Observable;

public abstract class CompositeCoordinator<T extends MvpActivity> {

    private MvpObservable observable = new MvpObservable();

    protected abstract void onCreate(@NonNull T activity);

    void onStart() {
        observable.performAction(Action.START);
    }

    void onStop() {
        observable.performAction(Action.STOP);
    }

    void onDestroy(boolean isChangingConfigurations) {
        observable.performAction(isChangingConfigurations ?
                Action.CHANGING : Action.DESTROY);
    }

    protected Observable observable() {
        return observable;
    }

    enum Action {
        START, STOP, CHANGING, DESTROY
    }

    private static class MvpObservable extends Observable {

        void performAction(Action action) {
            setChanged();
            notifyObservers(action);
        }
    }
}
