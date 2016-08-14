package com.install.wallapopcomics.view.master;

import com.install.wallapopcomics.app.network.NetworkManager;

class MasterModule {
    static ComicListPresenter comicListPresenter() {
        return new ComicListPresenter(NetworkManager.apiService());
    }
}