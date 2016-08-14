package com.install.wallapopcomics.presenter;

import android.app.Activity;
import android.content.Intent;

import com.install.wallapopcomics.view.detail.ComicActivity;
import com.install.wallapopcomics.model.ComicsData;

public class ActivityLauncher {

    public void launchComicActivity(Activity sourceActivity, ComicsData comic) {
        Intent comicIntent = new Intent(sourceActivity, ComicActivity.class);
        comicIntent.putExtra(ComicActivity.COMIC_EXTRA, comic);
        sourceActivity.startActivity(comicIntent);
    }

}
