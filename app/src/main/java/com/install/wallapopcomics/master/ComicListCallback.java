package com.install.wallapopcomics.master;

import com.install.wallapopcomics.model.ComicsData;
import com.install.wallapopcomics.presenter.ActivityPresenter;

public interface ComicListCallback extends ActivityPresenter {

    void onComicClicked(ComicsData comic);
}
