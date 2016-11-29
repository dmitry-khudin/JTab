package krt.com.jtab.Models;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by bryden on 11/25/16.
 */

public class SongModel implements Comparable<SongModel>, Parcelable{
    private boolean isHeader;
    private String title;
    private String description;
    private ArtistModel artistModel;

    public SongModel() {
    }

    public SongModel(String title, String description) {
        this.title = title;
        this.description = description;
        this.isHeader = false;
        this.artistModel = null;
    }

    public SongModel(String title) {
        this.title = title;
        this.isHeader = true;
    }

    public SongModel(String title, String description, ArtistModel artistModel) {
        this.title = title;
        this.description = description;
        this.artistModel = artistModel;
        this.isHeader = false;
    }

    protected SongModel(Parcel in) {
        isHeader = in.readByte() != 0;
        title = in.readString();
        description = in.readString();
    }

    public static final Creator<SongModel> CREATOR = new Creator<SongModel>() {
        @Override
        public SongModel createFromParcel(Parcel in) {
            return new SongModel(in);
        }

        @Override
        public SongModel[] newArray(int size) {
            return new SongModel[size];
        }
    };

    public boolean isHeader() {
        return isHeader;
    }

    public void setHeader(boolean header) {
        isHeader = header;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArtistModel getArtistModel() {
        return artistModel;
    }

    public void setArtistModel(ArtistModel artistModel) {
        this.artistModel = artistModel;
    }

    public SongModel(boolean isHeader, String title, String description, ArtistModel artistModel) {
        this.isHeader = isHeader;
        this.title = title;
        this.description = description;
        this.artistModel = artistModel;
    }

    @Override
    public int compareTo(SongModel songModel) {
        return title.compareTo(songModel.title);
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte((byte) (isHeader ? 1 : 0));
        parcel.writeString(title);
        parcel.writeString(description);
    }

}