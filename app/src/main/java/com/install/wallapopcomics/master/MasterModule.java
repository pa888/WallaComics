package com.install.wallapopcomics.master;

import com.install.wallapopcomics.network.NetworkManager;

class MasterModule {
    static ComicListPresenter comicListPresenter() {
        return new ComicListPresenter(NetworkManager.apiService());
    }
}