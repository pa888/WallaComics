package com.install.wallapopcomics.view.detail;

import static com.install.wallapopcomics.view.master.view.ViewModule.picasso;

public class DetailModule {

    static ComicUi comicUi() {
        return new ComicUi(picasso());
    }

}
