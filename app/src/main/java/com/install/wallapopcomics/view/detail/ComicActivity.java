package com.install.wallapopcomics.view.detail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.install.wallapopcomics.model.ComicsData;
import com.install.wallapopcomics.presenter.ActivityPresenter;
import com.install.wallapopcomics.presenter.NavigationCallback;

public class ComicActivity extends AppCompatActivity implements ActivityPresenter, NavigationCallback {

    public static final String COMIC_EXTRA = "comic_extra";

    private final ComicUi mComicUi;

    @SuppressWarnings("unused")
    public ComicActivity() {
        this(DetailModule.comicUi());
    }

    private ComicActivity(ComicUi comicUi) {
        mComicUi = comicUi;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mComicUi.createView(this, this, getComicFromExtras());
    }

    @Override
    public void onUpPressed() {
        finish();
    }

    private ComicsData getComicFromExtras() {
        Bundle extras = getIntent().getExtras();
        return extras.getParcelable(COMIC_EXTRA);
    }
}
