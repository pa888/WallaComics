package com.install.wallapopcomics.master;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import com.install.wallapopcomics.app.App;
import com.install.wallapopcomics.master.view.ComicListUi;
import com.install.wallapopcomics.model.CharacterDataWrapper;
import com.install.wallapopcomics.model.ComicDataContainer;
import com.install.wallapopcomics.model.ComicsData;
import com.install.wallapopcomics.model.response.CharacterResponse;
import com.install.wallapopcomics.network.ApiService;
import com.install.wallapopcomics.presenter.DataPersistor;
import com.install.wallapopcomics.util.Constants;

import org.w3c.dom.CharacterData;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

class ComicListPresenter implements Callback<CharacterDataWrapper> {

    private static final String CHARACTER_ID = Constants.CHARACTER_ID;

    private final ApiService mRetrofitApiService;

    private ComicListUi mComicListUi;
    private DataPersistor<List<ComicsData>> mDataPersistor;

    ComicListPresenter(ApiService retrofitApiService) {
        mRetrofitApiService = retrofitApiService;
    }

    void init(ComicListUi comicListUi, DataPersistor<List<ComicsData>> dataPersistor, List<ComicsData> savedComics) {
        mComicListUi = comicListUi;
        mDataPersistor = dataPersistor;

        if (savedComics == null) {
            fetchComics();
        } else {
            setData(savedComics);
        }
    }

    private void fetchComics() {
        mRetrofitApiService.fetchComicsFromCharacter(CHARACTER_ID, this);
    }

    @Override
    public void onResponse(Call<CharacterDataWrapper> call, Response<CharacterDataWrapper> response) {
        if (response.isSuccessful()) {
            Log.e("","Success");
            try {
                onComicsReceived(response.body());
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            Log.e("","Error");
            try {
                mComicListUi.showError();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onFailure(Call<CharacterDataWrapper> call, Throwable t) {
        mComicListUi.showError();
    }

    private void onComicsReceived(final CharacterDataWrapper characterDataWrapper) {
        App.getInstance().getBackgroundAppManager().executeTask(new Runnable() {
            @Override
            public void run() {
                ComicDataContainer data = characterDataWrapper.getComicDataContainer();
                if (data != null && data.getComics() != null) {
                    List<ComicsData> comics = data.getComics();
                    mDataPersistor.persistData(comics);

                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            setData(comics);
                        }
                    });

                } else {
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            mComicListUi.showError();
                        }
                    });
                }
            }
        });
    }

    private void setData(List<ComicsData> comics) {
        mComicListUi.setComics(comics);
    }

    private Handler handler = new Handler(Looper.getMainLooper());

}
