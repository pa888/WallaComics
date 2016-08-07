package com.install.wallapopcomics.network;

import com.install.wallapopcomics.util.Constants;
import com.install.wallapopcomics.util.HashManager;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Peter on 07.08.2016.
 */
public class AuthManager {

    public AuthManager() {}

    public Map<String, String> getAuthParams() {
        String timeStamp = getRandomTs();
        Map<String, String> authHeaders = new HashMap<>();
        authHeaders.put(Constants.TIMESTAMP, timeStamp);
        authHeaders.put(Constants.API_KEY, Constants.PUBLIC_KEY);
        authHeaders.put(Constants.HASH, HashManager.calculateHash(timeStamp));

        return authHeaders;
    }

    private String getRandomTs() {
        SecureRandom secureRandom = new SecureRandom();
        return new BigInteger(130, secureRandom).toString(32);
    }
}
