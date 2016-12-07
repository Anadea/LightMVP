package com.anadeainc.lightmvp;

import com.anadeainc.lightmvp.contract.IView;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

@RunWith(MockitoJUnitRunner.class)
public class PresenterTest {

    @Mock
    IView mvpView;

    @Test
    public void testLifecycle() {

        TestPresenter presenter = new TestPresenter();
        assertNull(presenter.mvpView());
        assertFalse(presenter.viewAttached());

        presenter.attachView(mvpView);
        assertNotNull(presenter.mvpView());
        assertEquals(mvpView, presenter.mvpView());
        assertTrue(presenter.viewAttached());

        presenter.detachView();
        assertNull(presenter.mvpView());

        try {
            presenter.destroy();
            fail("Expected an RuntimeException to be thrown");
        } catch (RuntimeException exception) {
            assertTrue("TestPresenter destroy()".equals(exception.getMessage()));
        }

    }

    static class TestPresenter extends Presenter<IView> {
        @Override
        public void destroy() {
            super.destroy();
            throw new RuntimeException("TestPresenter destroy()");
        }
    }
}