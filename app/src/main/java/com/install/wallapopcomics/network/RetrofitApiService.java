package com.install.wallapopcomics.network;

import com.install.wallapopcomics.model.CharacterDataWrapper;
import com.install.wallapopcomics.model.response.CharacterResponse;

import org.w3c.dom.CharacterData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;

/**
 * Created by Peter on 07.08.2016.
 */
public class RetrofitApiService implements ApiService {

    private static RetrofitApiService mInstance;
    private final Retrofit retrofitInstance;
    private final AuthManager authManagerInstance;

    private RetrofitApiService(Retrofit retrofit, AuthManager authManager) {
        authManagerInstance = authManager;
        retrofitInstance = retrofit;
    }

    public static RetrofitApiService getApiService(Retrofit retrofit, AuthManager authManager) {
        if (mInstance == null) {
            mInstance = new RetrofitApiService(retrofit, authManager);
        }
        return mInstance;
    }

    @Override
    public void fetchComicsFromCharacter(String characterId, Callback<CharacterDataWrapper> callback) {
        Endpoint service = retrofitInstance.create(Endpoint.class);
        Call<CharacterDataWrapper> charactersCall = service.getCharacters(characterId, authManagerInstance.getAuthParams());
        charactersCall.enqueue(callback);
    }
}
