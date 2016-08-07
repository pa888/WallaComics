package com.install.wallapopcomics.presenter;

import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.view.View;

public interface ActivityPresenter {

    void setContentView(@LayoutRes int layoutResID);

    View findViewById(@IdRes int id);

}
