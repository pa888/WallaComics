
package com.install.wallapopcomics.model.response;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Stories implements Parcelable {

    @SerializedName("available")
    @Expose
    private Integer available;
    @SerializedName("collectionURI")
    @Expose
    private String collectionURI;
    @SerializedName("items")
    @Expose
    private List<Item> items = new ArrayList<Item>();
    @SerializedName("returned")
    @Expose
    private Integer returned;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.available);
        dest.writeString(this.collectionURI);
        dest.writeTypedList(this.items);
        dest.writeValue(this.returned);
    }

    public Stories() {
    }

    protected Stories(Parcel in) {
        this.available = (Integer) in.readValue(Integer.class.getClassLoader());
        this.collectionURI = in.readString();
        this.items = in.createTypedArrayList(Item.CREATOR);
        this.returned = (Integer) in.readValue(Integer.class.getClassLoader());
    }

    public static final Creator<Stories> CREATOR = new Creator<Stories>() {
        @Override
        public Stories createFromParcel(Parcel source) {
            return new Stories(source);
        }

        @Override
        public Stories[] newArray(int size) {
            return new Stories[size];
        }
    };
}
