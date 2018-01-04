package com.example.gosia.glucophone.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;


public class Pomiar implements Parcelable {
    private Long id;
    private Integer wartosc;
    private String data;

    public Pomiar() {
    }

    private Pomiar(Parcel in){
        wartosc = in.readInt();
        data = in.readString();
    }

    public static final Creator<Pomiar> CREATOR = new Creator<Pomiar>() {
        @Override
        public Pomiar createFromParcel(Parcel in) {
            return new Pomiar(in);
        }

        @Override
        public Pomiar[] newArray(int size) {
            return new Pomiar[size];
        }
    };

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getWartosc() {
        return wartosc;
    }

    public void setWartosc(Integer wartosc) {
        this.wartosc = wartosc;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(wartosc);
        parcel.writeString(data);
    }
}
