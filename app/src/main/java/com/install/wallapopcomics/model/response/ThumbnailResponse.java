package com.install.wallapopcomics.model.response;

/**
 * Created by Peter on 07.08.2016.
 */
public class ThumbnailResponse {
    private String path;//":"http://i.annihil.us/u/prod/marvel/i/mg/3/50/537ba56d31087",
    private String extension;//":"jpg"

    public ThumbnailResponse() {
    }

    public ThumbnailResponse(String extension, String path) {
        this.extension = extension;
        this.path = path;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
