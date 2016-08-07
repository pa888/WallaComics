package com.install.wallapopcomics.master.view;

import android.content.res.Resources;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

class ComicItemDecoration extends RecyclerView.ItemDecoration {

    private Resources resources;
    ComicItemDecoration(Resources resources) {
        this.resources = resources;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        final int horizontalOffset = 12;
        outRect.bottom = 4;
        outRect.left = horizontalOffset;
        outRect.right = horizontalOffset;
    }
}
