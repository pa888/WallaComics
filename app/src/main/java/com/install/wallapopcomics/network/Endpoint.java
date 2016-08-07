package com.install.wallapopcomics.network;

import com.install.wallapopcomics.model.CharacterDataWrapper;
import com.install.wallapopcomics.model.response.CharacterResponse;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

/**
 * Created by Peter on 07.08.2016.
 */
interface Endpoint {

    @GET("v1/public/characters/{characterId}/comics")
    Call<CharacterDataWrapper> getCharacters(@Path("characterId") String characterId, @QueryMap Map<String, String> authParams);
}
