package krt.com.jtab.Models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by bryden on 11/25/16.
 */

public class ArtistModel implements Comparable<ArtistModel>, Parcelable{
    private String name;
    private boolean isHeader;
    private String imageURL;
    private SongModel[] arraySong;

    public ArtistModel() {
    }

    protected ArtistModel(Parcel in) {
        name = in.readString();
        isHeader = in.readByte() != 0;
        imageURL = in.readString();
        arraySong = in.createTypedArray(SongModel.CREATOR);
    }

    public static final Creator<ArtistModel> CREATOR = new Creator<ArtistModel>() {
        @Override
        public ArtistModel createFromParcel(Parcel in) {
            return new ArtistModel(in);
        }

        @Override
        public ArtistModel[] newArray(int size) {
            return new ArtistModel[size];
        }
    };

    public SongModel[] getArraySong() {
        return arraySong;
    }

    public void setArraySong(SongModel[] arraySong) {
        this.arraySong = arraySong;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isHeader() {
        return isHeader;
    }

    public void setHeader(boolean header) {
        isHeader = header;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public ArtistModel(String name, boolean isHeader, String imageURL, SongModel[] arraySong) {
        this.name = name;
        this.isHeader = isHeader;
        this.imageURL = imageURL;
        this.arraySong = arraySong;
    }

    public ArtistModel(String name) {
        this.name = name;
        this.isHeader = true;
    }

    public ArtistModel(String name, String imageURL, SongModel[] arraySong) {
        this.name = name;
        this.imageURL = imageURL;
        this.arraySong = arraySong;
        this.isHeader = false;
    }

    public ArtistModel(String name, String imageURL) {
        this.name = name;
        this.imageURL = imageURL;
        this.arraySong = null;
        this.isHeader = false;
    }

    @Override
    public int compareTo(ArtistModel artistModel) {
        return name.compareTo(artistModel.getName());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeByte((byte) (isHeader ? 1 : 0));
        parcel.writeString(imageURL);
        parcel.writeTypedArray(arraySong, i);
    }
}
