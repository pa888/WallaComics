package com.install.wallapopcomics.network;

import com.install.wallapopcomics.model.CharacterDataWrapper;
import retrofit2.Callback;

/**
 * Created by Peter on 07.08.2016.
 */
public interface ApiService {
    void fetchComicsFromCharacter(String characterId, Callback<CharacterDataWrapper> callback);
}
