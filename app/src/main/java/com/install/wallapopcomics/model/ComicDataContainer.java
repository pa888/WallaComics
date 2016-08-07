
package com.install.wallapopcomics.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class ComicDataContainer implements Parcelable {

    @SerializedName("offset")
    @Expose
    private Integer offset;
    @SerializedName("limit")
    @Expose
    private Integer limit;
    @SerializedName("total")
    @Expose
    private Integer total;
    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("results")
    @Expose
    private List<ComicsData> comics = new ArrayList<ComicsData>();

    /**
     * @return The results
     */
    public List<ComicsData> getComics() {
        return comics;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.offset);
        dest.writeValue(this.limit);
        dest.writeValue(this.total);
        dest.writeValue(this.count);
        dest.writeTypedList(this.comics);
    }

    public ComicDataContainer() {
    }

    protected ComicDataContainer(Parcel in) {
        this.offset = (Integer) in.readValue(Integer.class.getClassLoader());
        this.limit = (Integer) in.readValue(Integer.class.getClassLoader());
        this.total = (Integer) in.readValue(Integer.class.getClassLoader());
        this.count = (Integer) in.readValue(Integer.class.getClassLoader());
        this.comics = in.createTypedArrayList(ComicsData.CREATOR);
    }

    public static final Creator<ComicDataContainer> CREATOR = new Creator<ComicDataContainer>() {
        @Override
        public ComicDataContainer createFromParcel(Parcel source) {
            return new ComicDataContainer(source);
        }

        @Override
        public ComicDataContainer[] newArray(int size) {
            return new ComicDataContainer[size];
        }
    };
}
