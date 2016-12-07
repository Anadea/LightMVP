package com.anadeainc.exampledagger.basemvp;

import com.anadeainc.exampledagger.common.CompositeActivity;
import com.anadeainc.lightmvp.contract.IPresenter;
import com.anadeainc.lightmvp.contract.IView;
import com.anadeainc.lightmvp.mvpview.IMvpParent;
import com.anadeainc.lightmvp.mvpview.MvpView;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

public abstract class BaseMvpView<T extends IMvpParent, V extends IView, P extends IPresenter<V>>
        extends MvpView<T, V, P> {

    private Disposable subscription;

    public BaseMvpView(P presenter) {
        super(presenter);
    }

    public void onCreate(T parent, Observable<CompositeActivity.Action> observable) {
        super.onCreate(parent);
        subscription = observable.subscribe(this::performAction);
    }

    private void performAction(CompositeActivity.Action action) {
        boolean isChangingConfigurations = false;
        switch (action) {
            case START: {
                onStart();
                break;
            }
            case STOP: {
                onStop();
                break;
            }
            case CHANGING: {
                isChangingConfigurations = true;
            }
            case DESTROY: {
                onDestroy(isChangingConfigurations);
                subscription.dispose();
                subscription = null;
                break;
            }
        }
    }

}
