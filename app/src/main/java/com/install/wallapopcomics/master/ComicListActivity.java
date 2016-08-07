package com.install.wallapopcomics.master;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;

import com.install.wallapopcomics.master.view.ComicListUi;
import com.install.wallapopcomics.master.view.ViewModule;
import com.install.wallapopcomics.model.ComicsData;
import com.install.wallapopcomics.presenter.ActivityLauncher;
import com.install.wallapopcomics.presenter.DataPersistor;
import com.install.wallapopcomics.presenter.PresenterModule;

import java.util.ArrayList;
import java.util.List;

public class ComicListActivity extends AppCompatActivity implements ComicListCallback,
        DataPersistor<List<ComicsData>> {

    private final static String COMICS_EXTRA = "comics_extra";

    private final ComicListPresenter mComicListPresenter;
    private final ComicListUi mComicListUi;
    private final ActivityLauncher mActivityLauncher;

    private List<ComicsData> mFetchedComics;

    @SuppressWarnings("unused")
    public ComicListActivity() {
        this(MasterModule.comicListPresenter(), ViewModule.comicListUi(), PresenterModule.activityLauncher());
    }

    private ComicListActivity(ComicListPresenter comicListPresenter,
                              ComicListUi comicListUi,
                              ActivityLauncher activityLauncher) {
        mComicListPresenter = comicListPresenter;
        mComicListUi = comicListUi;
        mActivityLauncher = activityLauncher;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState != null) {
            mFetchedComics = savedInstanceState.getParcelableArrayList(COMICS_EXTRA);
        }

        mComicListUi.createView(this, this);
        mComicListPresenter.init(mComicListUi, this, mFetchedComics);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        try {
            outState.putParcelableArrayList(COMICS_EXTRA, new ArrayList<Parcelable>(mFetchedComics));
        } catch (Exception ignored) {}
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onComicClicked(ComicsData comic) {
        mActivityLauncher.launchComicActivity(this, comic);
    }

    @Override
    public void persistData(List<ComicsData> data) {
        mFetchedComics = data;
    }
}
