package com.install.wallapopcomics.model.response;

/**
 * Created by Peter on 07.08.2016.
 */
public class CharacterResponse {
    private int code;
    private String copyright;
    private String etag;
    private DataResponse data;

    public CharacterResponse() {
    }

    public CharacterResponse(int code, String copyright, DataResponse data, String etag) {
        this.code = code;
        this.copyright = copyright;
        this.data = data;
        this.etag = etag;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public DataResponse getData() {
        return data;
    }

    public void setData(DataResponse data) {
        this.data = data;
    }

    public String getEtag() {
        return etag;
    }

    public void setEtag(String etag) {
        this.etag = etag;
    }
}
