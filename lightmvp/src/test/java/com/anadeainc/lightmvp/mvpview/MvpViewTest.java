package com.anadeainc.lightmvp.mvpview;

import com.anadeainc.lightmvp.contract.IPresenter;
import com.anadeainc.lightmvp.contract.IView;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class MvpViewTest {

    @Mock
    IMvpParent parent;

    @Mock
    IPresenter<IView> presenter;

    @Test
    public void testLifecycle() {
        TestMvpView mvpView = new TestMvpView(presenter);
        assertNotNull(mvpView.presenter());
        assertEquals(presenter, mvpView.presenter());
        assertNull(mvpView.parent());

        mvpView.onCreate(parent);
        assertNotNull(mvpView.parent());
        assertEquals(parent, mvpView.parent());

        mvpView.onStart();
        verify(presenter).attachView(mvpView);

        mvpView.onStop();
        verify(presenter).detachView();
    }

    @Test
    public void testOnDestroyIsChangingConfigurations() {
        TestMvpView mvpView = new TestMvpView(presenter);
        mvpView.onCreate(parent);

        mvpView.onDestroy(true);
        verify(presenter, never()).destroy();
        assertNull(mvpView.presenter());
        assertNull(mvpView.parent());
    }

    @Test
    public void testOnDestroy() {
        TestMvpView mvpView = new TestMvpView(presenter);
        mvpView.onCreate(parent);

        mvpView.onDestroy(false);
        verify(presenter).destroy();
        assertNull(mvpView.presenter());
        assertNull(mvpView.parent());
    }

    static class TestMvpView extends MvpView<IMvpParent, IView, IPresenter<IView>> {

        TestMvpView(IPresenter<IView> presenter) {
            super(presenter);
        }

    }

}