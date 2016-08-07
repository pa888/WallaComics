package com.install.wallapopcomics.detail;

import static com.install.wallapopcomics.master.view.ViewModule.picasso;

public class DetailModule {

    static ComicUi comicUi() {
        return new ComicUi(picasso());
    }

}
