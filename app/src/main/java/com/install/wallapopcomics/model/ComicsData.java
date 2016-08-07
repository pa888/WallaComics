package com.install.wallapopcomics.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.install.wallapopcomics.model.response.Characters;
import com.install.wallapopcomics.model.response.Creators;
import com.install.wallapopcomics.model.response.Date;
import com.install.wallapopcomics.model.response.Events;
import com.install.wallapopcomics.model.response.Image;
import com.install.wallapopcomics.model.response.Price;
import com.install.wallapopcomics.model.response.Series;
import com.install.wallapopcomics.model.response.Stories;
import com.install.wallapopcomics.model.response.TextObject;
import com.install.wallapopcomics.model.response.Thumbnail;
import com.install.wallapopcomics.model.response.Url;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Peter on 07.08.2016.
 */
public class ComicsData implements Parcelable {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("digitalId")
    @Expose
    private Integer digitalId;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("issueNumber")
    @Expose
    private Double issueNumber;
    @SerializedName("variantDescription")
    @Expose
    private String variantDescription;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("modified")
    @Expose
    private String modified;
    @SerializedName("isbn")
    @Expose
    private String isbn;
    @SerializedName("upc")
    @Expose
    private String upc;
    @SerializedName("diamondCode")
    @Expose
    private String diamondCode;
    @SerializedName("ean")
    @Expose
    private String ean;
    @SerializedName("issn")
    @Expose
    private String issn;
    @SerializedName("format")
    @Expose
    private String format;
    @SerializedName("pageCount")
    @Expose
    private Integer pageCount;
    @SerializedName("textObjects")
    @Expose
    private List<TextObject> textObjects = new ArrayList<TextObject>();
    @SerializedName("resourceURI")
    @Expose
    private String resourceURI;
    @SerializedName("urls")
    @Expose
    private List<Url> urls = new ArrayList<Url>();
    @SerializedName("series")
    @Expose
    private Series series;
    @SerializedName("variants")
    @Expose
    private List<Object> variants = new ArrayList<Object>();
    @SerializedName("collections")
    @Expose
    private List<Object> collections = new ArrayList<Object>();
    @SerializedName("collectedIssues")
    @Expose
    private List<Object> collectedIssues = new ArrayList<Object>();
    @SerializedName("dates")
    @Expose
    private List<Date> dates = new ArrayList<Date>();
    @SerializedName("prices")
    @Expose
    private List<Price> prices = new ArrayList<Price>();
    @SerializedName("thumbnail")
    @Expose
    private Thumbnail thumbnail;
    @SerializedName("images")
    @Expose
    private List<Image> images = new ArrayList<Image>();
    @SerializedName("creators")
    @Expose
    private Creators creators;
    @SerializedName("characters")
    @Expose
    private Characters characters;
    @SerializedName("stories")
    @Expose
    private Stories stories;
    @SerializedName("events")
    @Expose
    private Events events;

    /**
     * @return The title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @return The description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @return The thumbnail
     */
    public Thumbnail getThumbnail() {
        return thumbnail;
    }

    /**
     * @return The images
     */
    public List<Image> getImages() {
        return images;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.id);
        dest.writeValue(this.digitalId);
        dest.writeString(this.title);
        dest.writeValue(this.issueNumber);
        dest.writeString(this.variantDescription);
        dest.writeString(this.description);
        dest.writeString(this.modified);
        dest.writeString(this.isbn);
        dest.writeString(this.upc);
        dest.writeString(this.diamondCode);
        dest.writeString(this.ean);
        dest.writeString(this.issn);
        dest.writeString(this.format);
        dest.writeValue(this.pageCount);
        dest.writeList(this.textObjects);
        dest.writeString(this.resourceURI);
        dest.writeList(this.urls);
        dest.writeParcelable(this.series, flags);
        dest.writeList(this.variants);
        dest.writeList(this.collections);
        dest.writeList(this.collectedIssues);
        dest.writeList(this.dates);
        dest.writeList(this.prices);
        dest.writeParcelable(this.thumbnail, flags);
        dest.writeList(this.images);
        dest.writeParcelable(this.creators, flags);
        dest.writeParcelable(this.characters, flags);
        dest.writeParcelable(this.stories, flags);
        dest.writeParcelable(this.events, flags);
    }

    protected ComicsData(Parcel in) {
        this.id = (Integer) in.readValue(Integer.class.getClassLoader());
        this.digitalId = (Integer) in.readValue(Integer.class.getClassLoader());
        this.title = in.readString();
        this.issueNumber = (Double) in.readValue(Double.class.getClassLoader());
        this.variantDescription = in.readString();
        this.description = in.readString();
        this.modified = in.readString();
        this.isbn = in.readString();
        this.upc = in.readString();
        this.diamondCode = in.readString();
        this.ean = in.readString();
        this.issn = in.readString();
        this.format = in.readString();
        this.pageCount = (Integer) in.readValue(Integer.class.getClassLoader());
        this.textObjects = new ArrayList<TextObject>();
        in.readList(this.textObjects, TextObject.class.getClassLoader());
        this.resourceURI = in.readString();
        this.urls = new ArrayList<Url>();
        in.readList(this.urls, Url.class.getClassLoader());
        this.series = in.readParcelable(Series.class.getClassLoader());
        this.variants = new ArrayList<Object>();
        in.readList(this.variants, Object.class.getClassLoader());
        this.collections = new ArrayList<Object>();
        in.readList(this.collections, Object.class.getClassLoader());
        this.collectedIssues = new ArrayList<Object>();
        in.readList(this.collectedIssues, Object.class.getClassLoader());
        this.dates = new ArrayList<Date>();
        in.readList(this.dates, Date.class.getClassLoader());
        this.prices = new ArrayList<Price>();
        in.readList(this.prices, Price.class.getClassLoader());
        this.thumbnail = in.readParcelable(Thumbnail.class.getClassLoader());
        this.images = new ArrayList<Image>();
        in.readList(this.images, Image.class.getClassLoader());
        this.creators = in.readParcelable(Creators.class.getClassLoader());
        this.characters = in.readParcelable(Characters.class.getClassLoader());
        this.stories = in.readParcelable(Stories.class.getClassLoader());
        this.events = in.readParcelable(Events.class.getClassLoader());
    }

    public static final Parcelable.Creator<ComicsData> CREATOR = new Parcelable.Creator<ComicsData>() {
        @Override
        public ComicsData createFromParcel(Parcel source) {
            return new ComicsData(source);
        }

        @Override
        public ComicsData[] newArray(int size) {
            return new ComicsData[size];
        }
    };
}