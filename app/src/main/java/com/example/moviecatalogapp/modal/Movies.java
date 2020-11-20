package com.example.moviecatalogapp.modal;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;

public class Movies implements Parcelable {
    public int id;
    public String url;
    public String name;
    public int season;
    public int number;
    public String type;
    public String airdate;
    public String airtime;
    public String airstamp;
    public int runtime;
    public Image image;
    public String summary;
    public Links _links;

    public String getName() {
        return name;
    }

    public String getSeason() {
        return "" + season;
    }

    public String getNumber() {
        return "" + number;
    }

    public String getRuntime() {
        return runtime + "";
    }

    public String getSummary() { return summary; }

    public Image getImage(){ return image; }

    @BindingAdapter({"app:imageUrl"})
    public static void loadImage(ImageView view, String imageUrl){
        Glide.with(view.getContext())
                .load(imageUrl)
                .into(view);
    }

    protected Movies(Parcel in) {
        id = in.readInt();
        url = in.readString();
        name = in.readString();
        season = in.readInt();
        number = in.readInt();
        type = in.readString();
        airdate = in.readString();
        airtime = in.readString();
        airstamp = in.readString();
        runtime = in.readInt();
        summary = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(url);
        dest.writeString(name);
        dest.writeInt(season);
        dest.writeInt(number);
        dest.writeString(type);
        dest.writeString(airdate);
        dest.writeString(airtime);
        dest.writeString(airstamp);
        dest.writeInt(runtime);
        dest.writeString(summary);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Movies> CREATOR = new Creator<Movies>() {
        @Override
        public Movies createFromParcel(Parcel in) {
            return new Movies(in);
        }

        @Override
        public Movies[] newArray(int size) {
            return new Movies[size];
        }
    };
}
