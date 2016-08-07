package com.install.wallapopcomics.network;

import com.install.wallapopcomics.util.Constants;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Peter on 07.08.2016.
 */
public class NetworkManager {
    //TODO: use singleton instance
    private static Retrofit retrofit;

    public static ApiService apiService() {
        return RetrofitApiService.getApiService(retrofit(), authManager());
    }

    private static AuthManager authManager() {
        return new AuthManager();
    }

    private static Retrofit retrofit() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        return new Retrofit.Builder()
                .baseUrl(Constants.GATEWAY)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
