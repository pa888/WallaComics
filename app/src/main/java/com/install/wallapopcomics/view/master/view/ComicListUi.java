package com.install.wallapopcomics.view.master.view;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.install.wallapopcomics.BuildConfig;
import com.install.wallapopcomics.R;
import com.install.wallapopcomics.view.master.ComicListCallback;
import com.install.wallapopcomics.model.ComicsData;
import com.install.wallapopcomics.presenter.ActivityPresenter;

import java.util.List;

public class ComicListUi {

    private final ComicsAdapter comicsAdapter;
    private final RecyclerView.ItemAnimator itemAnimator;
    private final RecyclerView.ItemDecoration itemDecoration;
    private final RecyclerView.LayoutManager layoutManager;

    private RecyclerView comicsRecycler;
    private LinearLayout loadingLayout;
    private TextView errorTextView;
    private ComicListCallback callback;

    ComicListUi(ComicsAdapter comicsAdapter,
                RecyclerView.ItemAnimator itemAnimator,
                RecyclerView.ItemDecoration itemDecoration,
                RecyclerView.LayoutManager layoutManager) {
        this.comicsAdapter = comicsAdapter;
        this.itemAnimator = itemAnimator;
        this.itemDecoration = itemDecoration;
        this.layoutManager = layoutManager;
    }

    public void createView(ActivityPresenter activityController, ComicListCallback callBack) {
        activityController.setContentView(R.layout.activity_comics_list);
        callback = callBack;

        Toolbar toolbar = (Toolbar) activityController.findViewById(R.id.toolbar);
        comicsRecycler = (RecyclerView) activityController.findViewById(R.id.comics_recycler);
        loadingLayout = (LinearLayout) activityController.findViewById(R.id.loading_layout);
        errorTextView = (TextView) activityController.findViewById(R.id.error_view);

        initToolbar(toolbar);
        setupRecyclerView();
    }

    public void setLoading() {
        loadingLayout.setVisibility(View.VISIBLE);
        errorTextView.setVisibility(View.GONE);
        comicsRecycler.setVisibility(View.GONE);
    }

    public void showError() {
        loadingLayout.setVisibility(View.GONE);
        errorTextView.setVisibility(View.VISIBLE);
        comicsRecycler.setVisibility(View.GONE);
    }

    public void setComics(List<ComicsData> comics) {
        errorTextView.setVisibility(View.GONE);
        loadingLayout.setVisibility(View.GONE);
        comicsRecycler.setVisibility(View.VISIBLE);
        comicsAdapter.setData(comics);
    }

    private void initToolbar(Toolbar toolbar) {
        toolbar.setTitle(R.string.app_name);
    }

    private void setupRecyclerView() {
        comicsAdapter.setPresenterCallback(callback);
        comicsRecycler.setLayoutManager(layoutManager);
        comicsRecycler.setItemAnimator(itemAnimator);
        comicsRecycler.addItemDecoration(itemDecoration);
        comicsRecycler.setAdapter(comicsAdapter);
    }
}
