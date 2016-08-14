package com.install.wallapopcomics.view.detail;

import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.install.wallapopcomics.R;
import com.install.wallapopcomics.model.ComicsData;
import com.install.wallapopcomics.model.response.Image;
import com.install.wallapopcomics.presenter.ActivityPresenter;
import com.install.wallapopcomics.presenter.NavigationCallback;
import com.install.wallapopcomics.app.util.Constants;
import com.squareup.picasso.Picasso;

public class ComicUi implements View.OnClickListener {

    private final Picasso mPicasso;

    private Toolbar mToolbar;
    private TextView mComicTitle;
    private WebView mComicDescription;
    private ImageView mComicImage;
    private NavigationCallback mNavigationCallback;

    public ComicUi(Picasso picasso) {
        mPicasso = picasso;
    }

    public void createView(ActivityPresenter activityPresenter, NavigationCallback navigationCallback, ComicsData comic) {
        activityPresenter.setContentView(R.layout.activity_comic);
        mNavigationCallback = navigationCallback;

        mToolbar = (Toolbar) activityPresenter.findViewById(R.id.toolbar);
        mComicTitle = (TextView) activityPresenter.findViewById(R.id.comic_title);
        mComicDescription = (WebView) activityPresenter.findViewById(R.id.comic_description);
        mComicImage = (ImageView) activityPresenter.findViewById(R.id.comic_image);

        initToolbar();
        setData(comic);
    }

    @Override
    public void onClick(View view) {
        mNavigationCallback.onUpPressed();
    }

    private void initToolbar() {
        mToolbar.setTitle(R.string.comic_title);
        mToolbar.setNavigationIcon(R.mipmap.ic_up);
        mToolbar.setNavigationOnClickListener(this);
    }

    private void setData(ComicsData comic) {
        Image image = comic.getImages().get(0);
        mComicTitle.setText(comic.getTitle());
        WebSettings settings = mComicDescription.getSettings();

        settings.setDefaultTextEncodingName("utf-8");
        mComicDescription.loadData(comic.getDescription(), "text/html; charset=utf-8",null);
        mPicasso.load(image.getPath() + Constants.EXTENSION_DOT + image.getExtension())
                .placeholder(R.mipmap.comics_list_placeholder)
                .into(mComicImage);
    }

}
