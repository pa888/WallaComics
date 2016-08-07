package com.install.wallapopcomics.master.view;

import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.install.wallapopcomics.app.App;
import com.squareup.picasso.Picasso;

public class ViewModule {

    public static ComicListUi comicListUi() {
        return new ComicListUi(comicsAdapter(),
                defaultItemAnimator(),
                comicItemDecoration(),
                comicsLayoutManager());
    }

    public static Picasso picasso() {
        return Picasso.with(App.getInstance());
    }

    private static ComicsAdapter comicsAdapter() {
        return new ComicsAdapter(viewHolderFactory(), picasso());
    }

    private static RecyclerView.ItemAnimator defaultItemAnimator() {
        return new DefaultItemAnimator();
    }

    private static RecyclerView.ItemDecoration comicItemDecoration() {
        return new ComicItemDecoration(App.getInstance().getResources());
    }

    private static RecyclerView.LayoutManager comicsLayoutManager() {
        return new GridLayoutManager(App.getInstance(), ComicListUi.CARDS_PER_ROW);
    }

    private static ViewHolderFactory viewHolderFactory() {
        return new ViewHolderFactory();
    }

}
