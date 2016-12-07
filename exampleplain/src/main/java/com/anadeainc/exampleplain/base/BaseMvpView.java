package com.anadeainc.exampleplain.base;

import com.anadeainc.lightmvp.contract.IPresenter;
import com.anadeainc.lightmvp.contract.IView;
import com.anadeainc.lightmvp.mvpview.IMvpParent;
import com.anadeainc.lightmvp.mvpview.MvpView;

import java.util.Observable;
import java.util.Observer;

public abstract class BaseMvpView<T extends IMvpParent, V extends IView, P extends IPresenter<V>>
        extends MvpView<T, V, P> implements Observer {

    public BaseMvpView(P presenter) {
        super(presenter);
    }

    public void onCreate(T parent, Observable observable) {
        super.onCreate(parent);
        observable.addObserver(this);
    }

    @Override
    public void update(Observable observable, Object action) {
        boolean isChangingConfigurations = false;
        switch ((CompositeCoordinator.Action) action) {
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
                observable.deleteObserver(this);
                break;
            }
        }
    }
}
