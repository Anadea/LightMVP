package com.anadeainc.exampledagger.features.main.mainview;

import com.anadeainc.exampledagger.remote.models.Post;
import com.anadeainc.lightmvp.contract.IPresenter;
import com.anadeainc.lightmvp.contract.IView;

import java.util.List;

interface MainMvp {

    interface View extends IView {

        void showProgress(boolean show);

        void showBackendError(boolean show, String message);

        void dataSetChanged(List<Post> dataList);

        void showEmptyListMessage(boolean show);

        void showSnakeBar();

        void showItem(String title, String message);

    }

    interface Presenter extends IPresenter<View> {
        void onFabClick();

        void onTryAgainClick();

        void onItemClick(int position);
    }
}
