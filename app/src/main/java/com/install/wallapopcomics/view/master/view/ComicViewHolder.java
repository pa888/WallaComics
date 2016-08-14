package com.install.wallapopcomics.view.master.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.install.wallapopcomics.R;

class ComicViewHolder extends RecyclerView.ViewHolder {

    TextView mComicName;
    ImageView mComicImage;

    ComicViewHolder(View itemView) {
        super(itemView);

        mComicName = (TextView) itemView.findViewById(R.id.hero_name);
        mComicImage = (ImageView) itemView.findViewById(R.id.hero_image);
    }
}
