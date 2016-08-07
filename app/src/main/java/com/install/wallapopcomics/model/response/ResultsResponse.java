package com.install.wallapopcomics.model.response;

/**
 * Created by Peter on 07.08.2016.
 */
public class ResultsResponse {
    private long id;
    private String name;
    private String description;
    private String modified; //":"2016-06-02T12:38:22-0400",
    private ThumbnailResponse thumbnail;
    private String resourceURI;//":"http://gateway.marvel.com/v1/public/characters/1009220",

    public ResultsResponse() {
    }

    public ResultsResponse(String description, long id, String modified, String name, String resourceURI, ThumbnailResponse thumbnail) {
        this.description = description;
        this.id = id;
        this.modified = modified;
        this.name = name;
        this.resourceURI = resourceURI;
        this.thumbnail = thumbnail;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getModified() {
        return modified;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResourceURI() {
        return resourceURI;
    }

    public void setResourceURI(String resourceURI) {
        this.resourceURI = resourceURI;
    }

    public ThumbnailResponse getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(ThumbnailResponse thumbnail) {
        this.thumbnail = thumbnail;
    }
}
