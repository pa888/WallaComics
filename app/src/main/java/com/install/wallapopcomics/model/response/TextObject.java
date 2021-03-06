
package com.install.wallapopcomics.model.response;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TextObject implements Parcelable {

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("language")
    @Expose
    private String language;
    @SerializedName("text")
    @Expose
    private String text;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.type);
        dest.writeString(this.language);
        dest.writeString(this.text);
    }

    public TextObject() {
    }

    protected TextObject(Parcel in) {
        this.type = in.readString();
        this.language = in.readString();
        this.text = in.readString();
    }

    public static final Creator<TextObject> CREATOR = new Creator<TextObject>() {
        @Override
        public TextObject createFromParcel(Parcel source) {
            return new TextObject(source);
        }

        @Override
        public TextObject[] newArray(int size) {
            return new TextObject[size];
        }
    };
}
