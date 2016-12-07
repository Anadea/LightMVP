package com.anadeainc.lightmvp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatDelegate;

import com.anadeainc.lightmvp.contract.IPresenter;
import com.anadeainc.lightmvp.contract.IView;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(RobolectricTestRunner.class)
@Config(manifest = Config.NONE)
public class MvpActivityTest {

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    TestPresenter presenter;

    @Mock
    Bundle bundle;

    @Spy
    TestActivity activity = Robolectric.buildActivity(TestActivity.class).get();

    @Test
    public void testLifecycle() {
        when(activity.getLastCustomNonConfigurationInstance()).thenReturn(null);

        activity.onCreate(null);
        assertNotNull(activity.mvpComponent);
        assertNotNull(activity.onRetainCustomNonConfigurationInstance());

        when(activity.isChangingConfigurations()).thenReturn(false);
        activity.onDestroy();
        verify(activity).notifyComponentOnDestroy(false);
        assertNull(activity.mvpComponent);
    }

    @Test
    public void testCreateAfterChangeConfiguration() {
        when(activity.getLastCustomNonConfigurationInstance()).thenReturn(presenter);

        activity.onCreate(null);
        assertNotNull(activity.mvpComponent);
        assertEquals(presenter, activity.mvpComponent);

        when(activity.isChangingConfigurations()).thenReturn(true);
        activity.onDestroy();
        verify(activity).notifyComponentOnDestroy(true);
        assertNull(activity.mvpComponent);
    }

    interface TestPresenter extends IPresenter<IView> {

    }

    static class TestActivity extends MvpActivity<IPresenter<IView>> implements IView {

        @NonNull
        @Override
        public AppCompatDelegate getDelegate() {
            return mock(AppCompatDelegate.class);
        }

        @Override
        protected IPresenter<IView> createRetainedComponent() {
            return mock(TestPresenter.class);
        }

        @Override
        protected void notifyComponentOnDestroy(boolean isChangingConfigurations) {

        }
    }
}