
package com.install.wallapopcomics.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CharacterDataWrapper implements Parcelable {

    @SerializedName("code")
    @Expose
    private Integer code;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("copyright")
    @Expose
    private String copyright;
    @SerializedName("attributionText")
    @Expose
    private String attributionText;
    @SerializedName("attributionHTML")
    @Expose
    private String attributionHTML;
    @SerializedName("etag")
    @Expose
    private String etag;
    @SerializedName("data")
    @Expose
    private ComicDataContainer comicDataContainer;

    /**
     * @return The data
     */
    public ComicDataContainer getComicDataContainer() {
        return comicDataContainer;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.code);
        dest.writeString(this.status);
        dest.writeString(this.copyright);
        dest.writeString(this.attributionText);
        dest.writeString(this.attributionHTML);
        dest.writeString(this.etag);
        dest.writeParcelable(this.comicDataContainer, flags);
    }

    protected CharacterDataWrapper(Parcel in) {
        this.code = (Integer) in.readValue(Integer.class.getClassLoader());
        this.status = in.readString();
        this.copyright = in.readString();
        this.attributionText = in.readString();
        this.attributionHTML = in.readString();
        this.etag = in.readString();
        this.comicDataContainer = in.readParcelable(ComicDataContainer.class.getClassLoader());
    }

    public static final Creator<CharacterDataWrapper> CREATOR = new Creator<CharacterDataWrapper>() {
        @Override
        public CharacterDataWrapper createFromParcel(Parcel source) {
            return new CharacterDataWrapper(source);
        }

        @Override
        public CharacterDataWrapper[] newArray(int size) {
            return new CharacterDataWrapper[size];
        }
    };
}
