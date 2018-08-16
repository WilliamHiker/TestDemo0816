package com.toocms.www.testdemoforwzw;

import android.os.Parcel;
import android.os.Parcelable;

public class Book implements Parcelable {
    private  int a;
    private  int b;

    protected Book(Parcel in) {
        a = in.readInt();
        b = in.readInt();
    }

    public static final Creator<Book> CREATOR = new Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel in) {
            return new Book(in);
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(a);
        parcel.writeInt(b);
    }
}
